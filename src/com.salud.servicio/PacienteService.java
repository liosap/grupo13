
package com.salud.servicio;

import com.opencsv.exceptions.CsvValidationException;
import com.salud.archivos.CsvService;
import com.salud.modelo.Paciente;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Servicio que implementa las operaciones de gestión de pacientes y la lógica
 * de negocio asociada.
 *
 * Actúa como intermediario entre la interfaz de usuario y el servicio
 * {@link CsvService}, coordinando las operaciones de consulta, alta,
 * modificación, eliminación, importación y exportación de pacientes.
 *
 * La persistencia de los datos se realiza mediante archivos CSV, mientras
 * que las reglas de validación propias de cada paciente se encuentran
 * definidas en la clase {@link Paciente}.
 *
 * @author Sistema de Salud
 * @version 1.0
 */
public class PacienteService {

    // Instancia del servicio responsable de la lectura y escritura de archivos CSV.
    private final CsvService csv = new CsvService();

    /**
     * Resultado de una operación de importación masiva de pacientes.
     *
     * Este record permite informar cuántos pacientes se incorporaron a la
     * colección existente y cuántos fueron omitidos por tener identificadores
     * que ya estaban registrados.
     *
     * @param agregados  Cantidad de pacientes nuevos incorporados.
     * @param duplicados Cantidad de pacientes omitidos por tener un ID ya existente.
     */
    public record ResultadoImportacion(int agregados, int duplicados) { }

    /**
     * Registra un paciente nuevo en el sistema.
     *
     * Antes de incorporarlo, verifica que la referencia recibida no sea nula
     * y que su identificador no se encuentre registrado.
     *
     * Si el ID ya existe, la operación no modifica la colección y devuelve
     * {@code false}. Si no existe, incorpora el paciente y guarda la colección
     * actualizada mediante {@link CsvService}.
     *
     * @param paciente Objeto {@link Paciente} que se desea registrar.
     * @return {@code true} si el paciente fue agregado; {@code false} si su ID
     *         ya se encontraba registrado.
     * @throws IllegalArgumentException si el paciente recibido es {@code null}.
     * @throws IOException si ocurre un error de entrada o salida durante la
     *         lectura o escritura del archivo CSV.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del formato CSV.
     */
    public boolean agregar(Paciente paciente)
            throws IOException, CsvValidationException {
        // Control defensivo para evitar operaciones con referencias nulas
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }

        // Carga los registros actuales para verificar la unicidad del identificador
        List<Paciente> pacientes = csv.leerPacientes();
        if (buscarEnLista(pacientes, paciente.getId()) != null) {
            return false; // El ID ya existe, se rechaza la inserción
        }

        // Incorpora el nuevo registro y persiste la colección actualizada
        pacientes.add(paciente);
        csv.guardarPacientes(pacientes);
        return true;
    }

    /**
     * Obtiene todos los pacientes registrados en el archivo CSV principal.
     *
     * @return Lista de objetos {@link Paciente} leídos del archivo.
     * @throws IOException si ocurre un error durante la lectura del archivo.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del formato CSV.
     */
    public List<Paciente> listar()
            throws IOException, CsvValidationException {
        return csv.leerPacientes();
    }

    /**
     * Busca un paciente mediante su identificador.
     *
     * La búsqueda se realiza sobre la colección de pacientes obtenida del
     * archivo CSV principal.
     *
     * @param id Identificador del paciente que se desea localizar.
     * @return El objeto {@link Paciente} correspondiente al ID indicado,
     *         o {@code null} si no existe un paciente con ese identificador.
     * @throws IOException si ocurre un error durante la lectura del archivo.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del formato CSV.
     */
    public Paciente buscarPorId(int id)
            throws IOException, CsvValidationException {
        return buscarEnLista(csv.leerPacientes(), id);
    }

    /**
     * Busca un paciente dentro de una lista en memoria mediante su ID.
     *
     * Recorre secuencialmente la colección hasta encontrar un paciente cuyo
     * identificador coincida con el valor solicitado.
     *
     * @param pacientes Lista de pacientes en la que se realizará la búsqueda.
     * @param id Identificador del paciente que se desea localizar.
     * @return El paciente encontrado o {@code null} si no existe coincidencia.
     */
    private Paciente buscarEnLista(List<Paciente> pacientes, int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    /**
     * Elimina de la colección al paciente cuyo identificador coincide con el
     * valor recibido.
     *
     * Si se encuentra y elimina al menos un registro, guarda la colección
     * actualizada en el archivo CSV principal.
     *
     * @param id Identificador del paciente que se desea eliminar.
     * @return {@code true} si se eliminó un paciente; {@code false} si no
     *         se encontró ningún registro con ese ID.
     * @throws IOException si ocurre un error durante la lectura o escritura
     *         del archivo CSV.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del formato CSV.
     */
    public boolean eliminar(int id)
            throws IOException, CsvValidationException {
        List<Paciente> pacientes = csv.leerPacientes();

        // Elimina de la lista todos los registros cuyo ID coincide con el indicado
        boolean eliminado = pacientes.removeIf(p -> p.getId() == id);

        if (eliminado) {
            // Persiste los cambios solo si se removió efectivamente algún registro
            csv.guardarPacientes(pacientes);
        }
        return eliminado;
    }

    /**
     * Modifica los datos de un paciente que ya se encuentra registrado.
     *
     * Localiza al paciente mediante el ID del objeto recibido. Si existe,
     * actualiza su nombre, apellido, edad, teléfono y correo electrónico,
     * utilizando los métodos de modificación definidos en {@link Paciente}.
     *
     * El identificador del paciente existente no se modifica.
     *
     * @param actualizado Objeto {@link Paciente} que contiene el ID del
     *        paciente a localizar y los nuevos datos que se desean aplicar.
     * @return {@code true} si el paciente fue encontrado y modificado;
     *         {@code false} si no existe un paciente con ese ID.
     * @throws IllegalArgumentException si el objeto recibido es {@code null}.
     * @throws IOException si ocurre un error durante la lectura o escritura
     *         del archivo CSV.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del formato CSV.
     */
    public boolean modificar(Paciente actualizado)
            throws IOException, CsvValidationException {
        if (actualizado == null) {
            throw new IllegalArgumentException("El paciente actualizado no puede ser nulo.");
        }

        List<Paciente> pacientes = csv.leerPacientes();
        Paciente existente = buscarEnLista(pacientes, actualizado.getId());

        if (existente == null) {
            return false; // El paciente a modificar no se encuentra registrado
        }

        // Actualización de los campos internos; las reglas de validación recaen en el modelo
        existente.setNombre(actualizado.getNombre());
        existente.setApellido(actualizado.getApellido());
        existente.setEdad(actualizado.getEdad());
        existente.setTelefono(actualizado.getTelefono());
        existente.setEmail(actualizado.getEmail());

        csv.guardarPacientes(pacientes);
        return true;
    }

    /**
     * Importa pacientes desde un archivo CSV externo y los incorpora a la
     * colección principal cuando sus identificadores no se encuentran
     * registrados.
     *
     * Los pacientes cuyo ID ya existe en la colección principal se omiten
     * y se contabilizan como duplicados.
     *
     * La lectura y validación del archivo externo se delega a {@link CsvService}.
     * Por lo tanto, los registros inválidos o los identificadores duplicados
     * dentro del propio archivo de importación pueden provocar una excepción
     * antes de que se realice la incorporación.
     *
     * @param ruta Ruta del archivo CSV externo desde el cual se importarán
     *        los pacientes.
     * @return Un objeto {@link ResultadoImportacion} con las cantidades
     *         de pacientes agregados y duplicados.
     * @throws IOException si ocurre un error de lectura o escritura, si el
     *         archivo externo no puede leerse o si contiene datos inválidos.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del formato CSV externo.
     */
    public ResultadoImportacion importar(String ruta)
            throws IOException, CsvValidationException {
        List<Paciente> importados = csv.importarPacientes(ruta);
        List<Paciente> actuales = csv.leerPacientes();

        // Mapeo inicial de IDs ya registrados para control de colisiones en tiempo O(1)
        Set<Integer> idsExistentes = new HashSet<>();
        for (Paciente actual : actuales) {
            idsExistentes.add(actual.getId());
        }

        int agregados = 0;
        int duplicados = 0;

        // Evaluación de cada paciente importado
        for (Paciente nuevo : importados) {
            // Set.add() retorna true si el elemento no existía en el conjunto
            if (idsExistentes.add(nuevo.getId())) {
                actuales.add(nuevo);
                agregados++;
            } else {
                duplicados++;
            }
        }

        // Consolidación de cambios únicamente si se añadieron registros nuevos
        if (agregados > 0) {
            csv.guardarPacientes(actuales);
        }

        return new ResultadoImportacion(agregados, duplicados);
    }

    /**
     * Exporta todos los pacientes registrados en la colección principal
     * hacia un archivo CSV ubicado en la ruta indicada.
     *
     * La operación obtiene primero la lista actual de pacientes y delega
     * la escritura del archivo de destino a {@link CsvService}.
     *
     * @param ruta Ruta del archivo CSV externo donde se exportarán los datos.
     * @return Cantidad de pacientes exportados.
     * @throws IOException si ocurre un error durante la lectura o escritura
     *         de los archivos involucrados, o si la ruta de destino no es válida.
     * @throws CsvValidationException si se produce un error durante el análisis
     *         o la validación del archivo CSV principal.
     */
    public int exportar(String ruta)
            throws IOException, CsvValidationException {
        List<Paciente> pacientes = csv.leerPacientes();
        csv.exportarPacientes(pacientes, ruta);
        return pacientes.size();
    }
}
