
package com.salud.archivos;

// Librerías para leer y escribir archivos CSV
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

// Clase que representa a cada paciente
import com.salud.modelo.Paciente;

// Librerías para manejo de archivos y entrada/salida
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

// Librerías para trabajar con listas y conjuntos
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CsvService {

    // Ruta del archivo CSV donde se almacenan los pacientes
    private static final Path ARCHIVO = Path.of("pacientes.csv");

    // Nombres de las columnas que tendrá el archivo CSV
    private static final String[] ENCABEZADO = {
        "id", "nombre", "apellido", "edad", "telefono", "email"
    };

    /**
     * Inicializa el archivo CSV.
     *
     * Comprueba si el archivo no existe o está vacío.
     * En cualquiera de esos casos, crea un archivo nuevo
     * que contendrá únicamente el encabezado.
     *
     * @throws IOException si ocurre un error al acceder al archivo.
     */
    public void inicializarArchivo() throws IOException {

        // Verifica si el archivo no existe o tiene tamaño cero
        if (Files.notExists(ARCHIVO) || Files.size(ARCHIVO) == 0) {

            // Crea el archivo con el encabezado y sin pacientes
            guardarPacientes(List.of());
        }
    }

    /**
     * Lee los pacientes almacenados en el archivo CSV.
     *
     * Comprueba que el encabezado y las filas tengan
     * la estructura esperada y que no existan IDs duplicados.
     *
     * @return lista de pacientes encontrados en el archivo.
     * @throws IOException si el archivo tiene una estructura incorrecta
     *                     o se produce un error de lectura.
     * @throws CsvValidationException si OpenCSV detecta un error CSV.
     */
    public List<Paciente> leerPacientes()
            throws IOException, CsvValidationException {

        // Garantiza que el archivo exista antes de intentar leerlo
        inicializarArchivo();

        // Lista donde se almacenarán los pacientes recuperados
        List<Paciente> pacientes = new ArrayList<>();

        // Abre el archivo utilizando codificación UTF-8
        // try-with-resources cierra automáticamente los recursos
        try (BufferedReader bufferedReader =
                    Files.newBufferedReader(ARCHIVO, StandardCharsets.UTF_8);

             CSVReader reader = new CSVReader(bufferedReader)) {

            // Lee la primera línea del CSV, correspondiente al encabezado
            String[] encabezadoLeido = reader.readNext();

            // Comprueba que exista un encabezado y tenga seis columnas
            if (encabezadoLeido == null ||
                    encabezadoLeido.length != ENCABEZADO.length) {

                throw new IOException("Encabezado CSV inválido.");
            }

            // Variable que almacenará cada fila leída del archivo
            String[] fila;

            // Contador de filas.
            // Comienza en 1 porque la primera línea es el encabezado
            int numeroFila = 1;

            // Conjunto utilizado para controlar que no existan IDs repetidos
            // HashSet permite comprobar duplicados de manera eficiente
            Set<Integer> ids = new HashSet<>();

            // Lee las filas del archivo hasta llegar al final
            while ((fila = reader.readNext()) != null) {

                // Incrementa el número de fila procesada
                numeroFila++;

                // Comprueba que la fila tenga exactamente seis columnas
                if (fila.length != ENCABEZADO.length) {

                    throw new IOException(
                        "Fila " + numeroFila + ": columnas incompletas."
                    );
                }

                // Obtiene el ID del paciente y elimina espacios sobrantes
                int id = Integer.parseInt(fila[0].trim());

                // Intenta agregar el ID al conjunto.
                // Si ya existe, add() devuelve false y se informa el error
                if (!ids.add(id)) {

                    throw new IOException(
                        "ID duplicado encontrado: " + id
                    );
                }

                // Convierte los datos de la fila en un objeto Paciente
                // trim() elimina espacios al principio y al final
                pacientes.add(new Paciente(
                    id,
                    fila[1].trim(),
                    fila[2].trim(),
                    Integer.parseInt(fila[3].trim()),
                    fila[4].trim(),
                    fila[5].trim()
                ));
            }
        }

        // Devuelve la lista con todos los pacientes recuperados
        return pacientes;
    }

    /**
     * Guarda una lista de pacientes en el archivo CSV.
     *
     * Para evitar que el archivo original quede incompleto
     * si ocurre un error durante la escritura, primero genera
     * un archivo temporal y luego lo utiliza para reemplazar
     * el archivo original.
     *
     * @param pacientes lista de pacientes que se desea guardar.
     * @throws IOException si ocurre un error durante la escritura.
     */
    public void guardarPacientes(List<Paciente> pacientes)
            throws IOException {

        // Obtiene la ruta absoluta del directorio donde está el CSV
        Path directorio = ARCHIVO.toAbsolutePath().getParent();

        // Crea el directorio si no existe.
        // Si ya existe, no realiza ninguna modificación
        if (directorio != null) {
            Files.createDirectories(directorio);
        }

        // Crea un archivo temporal dentro del mismo directorio
        // El prefijo será "pacientes-" y la extensión ".tmp"
        Path temporal = Files.createTempFile(
            directorio, "pacientes-", ".tmp"
        );

        try {

            // Abre el archivo temporal para escribir los datos
            // Se utiliza UTF-8 para admitir caracteres especiales
            try (Writer output =
                        Files.newBufferedWriter(temporal, StandardCharsets.UTF_8);

                 CSVWriter writer = new CSVWriter(output)) {

                // Escribe primero los nombres de las columnas
                writer.writeNext(ENCABEZADO);

                // Recorre la lista de pacientes recibida como parámetro
                for (Paciente p : pacientes) {

                    // Convierte los atributos del paciente en una fila CSV
                    // Los valores numéricos se convierten a String
                    writer.writeNext(new String[]{
                        String.valueOf(p.getId()),
                        p.getNombre(),
                        p.getApellido(),
                        String.valueOf(p.getEdad()),
                        p.getTelefono(),
                        p.getEmail()
                    });
                }
            }

            // Una vez terminada la escritura, reemplaza el archivo original
            // REPLACE_EXISTING permite sobrescribir el archivo existente
            // ATOMIC_MOVE solicita que el reemplazo sea una operación atómica
            Files.move(
                temporal,
                ARCHIVO,
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.ATOMIC_MOVE
            );

        } finally {

            // Elimina el archivo temporal si todavía existe
            // Esto evita dejar archivos innecesarios si ocurre un error
            Files.deleteIfExists(temporal);
        }
    }
}
