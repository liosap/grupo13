
package com.salud.archivos;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.salud.modelo.Paciente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Servicio responsable de gestionar la lectura y escritura de los datos
 * de pacientes mediante archivos en formato CSV.
 *
 * Utiliza la biblioteca OpenCSV para procesar los registros y la API
 * de archivos de Java NIO para administrar el almacenamiento.
 *
 * Implementa operaciones de inicialización, lectura, escritura,
 * importación y exportación de pacientes. Además, verifica la estructura
 * del archivo, valida los datos mediante el modelo {@link Paciente}
 * y controla la unicidad de los identificadores.
 *
 * Para escribir los archivos utiliza un archivo temporal y posteriormente
 * intenta reemplazar el destino mediante un movimiento atómico. Si el
 * sistema de archivos no admite esta operación, utiliza un movimiento
 * convencional como alternativa.
 *
 * @author Sistema de Salud
 * @version 1.0
 */
public class CsvService {

    /**
     * Ruta relativa del archivo CSV principal utilizado para almacenar
     * los registros de pacientes.
     */
    private static final Path ARCHIVO = Path.of("pacientes.csv");

    /**
     * Define los nombres y el orden de las columnas que debe contener
     * el encabezado de los archivos CSV procesados por el servicio.
     */
    private static final String[] ENCABEZADO = {
            "id", "nombre", "apellido", "edad", "telefono", "email"
    };

    /**
     * Verifica la existencia y el contenido del archivo CSV principal.
     *
     * Si el archivo no existe o se encuentra vacío, lo crea o inicializa
     * con el encabezado correspondiente y sin registros de pacientes.
     *
     * @throws IOException si ocurre un error de entrada/salida durante
     *                     la consulta, creación o escritura del archivo.
     */
    public void inicializarArchivo() throws IOException {
        // Comprueba si el archivo principal no existe o tiene un tamaño de cero bytes.
        if (Files.notExists(ARCHIVO) || Files.size(ARCHIVO) == 0) {
            escribirArchivo(ARCHIVO, List.of());
        }
    }

    /**
     * Lee los registros de pacientes almacenados en el archivo CSV principal.
     *
     * Antes de realizar la lectura, verifica que el archivo esté inicializado.
     * Posteriormente delega el procesamiento y la validación de sus registros
     * al método {@link #leerArchivo(Path)}.
     *
     * @return lista de pacientes recuperados y validados desde el archivo CSV.
     * @throws IOException si ocurre un error de entrada/salida o si la
     *                     estructura o los datos del archivo son inválidos.
     * @throws CsvValidationException si OpenCSV detecta un error durante
     *                                el análisis de un registro CSV.
     */
    public List<Paciente> leerPacientes()
            throws IOException, CsvValidationException {
        inicializarArchivo();
        return leerArchivo(ARCHIVO);
    }

    /**
     * Lee y procesa los registros de un archivo CSV ubicado en la ruta indicada.
     *
     * Verifica el encabezado y la cantidad de columnas de cada registro,
     * convierte los valores numéricos, construye los objetos {@link Paciente}
     * y comprueba que los identificadores no estén duplicados.
     *
     * La lectura se realiza utilizando la codificación UTF-8.
     *
     * @param ruta ruta del archivo CSV que se desea procesar.
     * @return lista de pacientes construidos y validados a partir de los registros.
     * @throws IOException si ocurre un error de entrada/salida, si el encabezado
     *                     o la cantidad de columnas son incorrectos, si los datos
     *                     no cumplen las validaciones del modelo o si existen
     *                     identificadores duplicados.
     * @throws CsvValidationException si OpenCSV detecta un error durante
     *                                el análisis del archivo.
     */
    private List<Paciente> leerArchivo(Path ruta)
            throws IOException, CsvValidationException {
        List<Paciente> pacientes = new ArrayList<>();

        // Abre el archivo en modo lectura utilizando la codificación UTF-8.
        try (BufferedReader bufferedReader =
                     Files.newBufferedReader(ruta, StandardCharsets.UTF_8);
             CSVReader reader = new CSVReader(bufferedReader)) {

            // Lee el encabezado y comprueba que corresponda con la estructura esperada.
            String[] encabezadoLeido = reader.readNext();
            validarEncabezado(encabezadoLeido, ruta);

            String[] fila;
            int numeroFila = 1;

            // Recorre secuencialmente los registros del archivo CSV.
            while ((fila = reader.readNext()) != null) {
                numeroFila++;

                // Comprueba que cada registro contenga exactamente las columnas esperadas.
                if (fila.length != ENCABEZADO.length) {
                    throw new IOException("CSV " + ruta + ", fila " + numeroFila
                            + ": se esperaban 6 columnas y se encontraron "
                            + fila.length + ".");
                }

                try {
                    int id = Integer.parseInt(fila[0].trim());
                    String nombre = fila[1].trim();
                    String apellido = fila[2].trim();
                    int edad = Integer.parseInt(fila[3].trim());
                    String telefono = fila[4].trim();
                    String email = fila[5].trim();

                    // Construye el paciente y delega la validación de sus atributos al modelo.
                    pacientes.add(new Paciente(
                            id, nombre, apellido, edad, telefono, email
                    ));
                } catch (IllegalArgumentException e) {
                    // Convierte el error de los datos en una excepción de E/S e informa la fila afectada.
                    throw new IOException("CSV " + ruta + ", fila " + numeroFila
                            + ": datos inválidos. " + e.getMessage(), e);
                }
            }
        }

        // Comprueba que no existan identificadores repetidos entre los pacientes leídos.
        verificarIdsUnicos(pacientes, ruta);
        return pacientes;
    }

    /**
     * Comprueba que el encabezado del archivo CSV tenga la cantidad y los
     * nombres de columnas definidos en {@link #ENCABEZADO}.
     *
     * La comparación de los nombres no distingue entre mayúsculas y
     * minúsculas y elimina los espacios externos. También contempla
     * la presencia de un marcador BOM (Byte Order Mark) en el primer campo.
     *
     * @param encabezado arreglo de cadenas correspondiente al encabezado leído.
     * @param ruta ruta del archivo CSV que se está procesando.
     * @throws IOException si el encabezado no existe, tiene una cantidad
     *                     incorrecta de columnas o presenta nombres no válidos.
     */
    private void validarEncabezado(String[] encabezado, Path ruta)
            throws IOException {
        if (encabezado == null || encabezado.length != ENCABEZADO.length) {
            throw new IOException("El archivo " + ruta + " no contiene un encabezado CSV válido.");
        }

        // Elimina el marcador BOM del primer campo, si está presente.
        encabezado[0] = encabezado[0].replace("\uFEFF", "");

        for (int i = 0; i < ENCABEZADO.length; i++) {
            if (!ENCABEZADO[i].equalsIgnoreCase(encabezado[i].trim())) {
                throw new IOException("Encabezado CSV incorrecto en " + ruta
                        + ". Se esperaba: " + String.join(",", ENCABEZADO));
            }
        }
    }

    /**
     * Verifica que todos los pacientes de una colección tengan
     * identificadores únicos.
     *
     * Utiliza un conjunto {@link Set} para detectar si un identificador
     * ya fue procesado. Si encuentra una repetición, interrumpe la operación
     * mediante una excepción.
     *
     * @param pacientes colección de pacientes cuyos identificadores se desean verificar.
     * @param ruta ruta del archivo relacionado con la validación.
     * @throws IOException si se encuentra un identificador duplicado.
     */
    private void verificarIdsUnicos(List<Paciente> pacientes, Path ruta)
            throws IOException {
        Set<Integer> ids = new HashSet<>();
        for (Paciente paciente : pacientes) {
            // Set.add() devuelve false cuando el identificador ya se encuentra en el conjunto.
            if (!ids.add(paciente.getId())) {
                throw new IOException("El archivo " + ruta
                        + " contiene el ID duplicado " + paciente.getId() + ".");
            }
        }
    }

    /**
     * Guarda la colección de pacientes en el archivo CSV principal.
     *
     * Delega la escritura y las validaciones correspondientes
     * al método {@link #escribirArchivo(Path, List)}.
     *
     * @param pacientes lista de pacientes que se desean almacenar.
     * @throws IOException si ocurre un error durante la escritura
     *                     o el reemplazo del archivo.
     * @throws IllegalArgumentException si la lista es nula o contiene
     *                                  algún elemento nulo.
     */
    public void guardarPacientes(List<Paciente> pacientes) throws IOException {
        escribirArchivo(ARCHIVO, pacientes);
    }

    /**
     * Escribe una colección de pacientes en un archivo CSV de destino.
     *
     * Primero comprueba que los identificadores sean únicos y prepara
     * el directorio de destino. Luego genera un archivo temporal en el
     * mismo directorio, escribe el encabezado y los registros utilizando
     * OpenCSV y codificación UTF-8.
     *
     * Una vez finalizada la escritura, intenta reemplazar el archivo
     * de destino mediante un movimiento atómico. Si esta operación no
     * está soportada por el sistema de archivos, utiliza un movimiento
     * convencional. Si el reemplazo no se completa, intenta eliminar
     * el archivo temporal.
     *
     * @param destino ruta del archivo CSV que se desea crear o reemplazar.
     * @param pacientes lista de pacientes que se desean almacenar.
     * @throws IOException si ocurre un error durante la creación del directorio,
     *                     la generación del archivo temporal, la escritura,
     *                     el reemplazo o la limpieza del archivo temporal.
     * @throws IllegalArgumentException si la lista es nula o contiene
     *                                  algún paciente nulo.
     */
    private void escribirArchivo(Path destino, List<Paciente> pacientes)
            throws IOException {
        if (pacientes == null) {
            throw new IllegalArgumentException("La lista de pacientes no puede ser nula.");
        }

        // Verifica que no existan identificadores duplicados antes de escribir el archivo.
        verificarIdsUnicos(pacientes, destino);

        Path absoluto = destino.toAbsolutePath();
        Path directorio = absoluto.getParent();
        if (directorio != null) {
            Files.createDirectories(directorio);
        }

        // Crea un archivo temporal en el directorio del archivo de destino.
        Path temporal = Files.createTempFile(
                directorio, "pacientes-", ".tmp"
        );

        boolean reemplazado = false;
        try {
            // Escribe los registros CSV en el archivo temporal utilizando UTF-8 y OpenCSV.
            try (Writer output = Files.newBufferedWriter(
                    temporal, StandardCharsets.UTF_8);
                 CSVWriter writer = new CSVWriter(output)) {

                writer.writeNext(ENCABEZADO);
                for (Paciente paciente : pacientes) {
                    if (paciente == null) {
                        throw new IllegalArgumentException(
                                "La lista contiene un paciente nulo.");
                    }
                    writer.writeNext(new String[]{
                            String.valueOf(paciente.getId()),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            String.valueOf(paciente.getEdad()),
                            paciente.getTelefono(),
                            paciente.getEmail()
                    });
                }
            }

            // Intenta reemplazar el archivo de destino mediante un movimiento atómico.
            try {
                Files.move(temporal, absoluto,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.ATOMIC_MOVE);
            } catch (AtomicMoveNotSupportedException e) {
                // Utiliza un movimiento convencional si el sistema de archivos no admite el movimiento atómico.
                Files.move(temporal, absoluto,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            reemplazado = true;
        } finally {
            // Si el reemplazo no se completó, intenta eliminar el archivo temporal.
            if (!reemplazado) {
                Files.deleteIfExists(temporal);
            }
        }
    }

    /**
     * Importa los registros de pacientes desde un archivo CSV externo.
     *
     * Valida la ruta recibida y comprueba que corresponda a un archivo
     * regular con permisos de lectura. Luego procesa su contenido
     * mediante el método {@link #leerArchivo(Path)}.
     *
     * Esta operación lee el archivo externo, pero no modifica directamente
     * el archivo CSV principal de almacenamiento.
     *
     * @param ruta ubicación del archivo CSV externo que se desea importar.
     * @return lista de pacientes recuperados y validados desde el archivo externo.
     * @throws IOException si el archivo no existe, no es un archivo regular,
     *                     no tiene permisos de lectura o presenta errores
     *                     durante su procesamiento.
     * @throws CsvValidationException si OpenCSV detecta un error durante
     *                                el análisis del archivo.
     * @throws IllegalArgumentException si la ruta es nula o está vacía,
     *                                  o si no puede convertirse en una ruta válida.
     */
    public List<Paciente> importarPacientes(String ruta)
            throws IOException, CsvValidationException {
        Path archivoExterno = validarRuta(ruta);
        if (!Files.isRegularFile(archivoExterno) || !Files.isReadable(archivoExterno)) {
            throw new IOException("No se puede leer el archivo: " + archivoExterno);
        }
        return leerArchivo(archivoExterno);
    }

    /**
     * Exporta una colección de pacientes hacia un archivo CSV externo.
     *
     * Comprueba que la ruta de destino no corresponda al archivo principal
     * de almacenamiento para evitar su sobrescritura accidental.
     * La escritura se delega al método {@link #escribirArchivo(Path, List)}.
     *
     * @param pacientes lista de pacientes que se desean exportar.
     * @param ruta ruta del archivo CSV de destino.
     * @throws IOException si la ruta corresponde al archivo principal
     *                     o si ocurre un error durante la escritura.
     * @throws IllegalArgumentException si la ruta no es válida o la lista
     *                                  de pacientes es nula o contiene
     *                                  algún elemento nulo.
     */
    public void exportarPacientes(List<Paciente> pacientes, String ruta)
            throws IOException {
        Path destino = validarRuta(ruta).toAbsolutePath();
        // Evita que la exportación sobrescriba el archivo CSV principal.
        if (destino.equals(ARCHIVO.toAbsolutePath())) {
            throw new IOException("La exportación no puede sobrescribir el archivo principal.");
        }
        escribirArchivo(destino, pacientes);
    }

    /**
     * Valida una ruta recibida como cadena de texto y la convierte
     * en un objeto {@link Path} absoluto y normalizado.
     *
     * Elimina los espacios externos de la cadena antes de construir
     * la ruta y aplica la normalización para resolver sus componentes
     * relativos, como {@code .} y {@code ..}.
     *
     * @param ruta cadena de texto que representa la ubicación del archivo.
     * @return ruta absoluta y normalizada.
     * @throws IllegalArgumentException si la cadena es nula, está vacía
     *                                  o contiene una ruta que no puede
     *                                  convertirse en un objeto {@code Path}.
     */
    private Path validarRuta(String ruta) {
        if (ruta == null || ruta.isBlank()) {
            throw new IllegalArgumentException("Debe indicar una ruta de archivo.");
        }
        return Path.of(ruta.trim()).toAbsolutePath().normalize();
    }
}
