
package com.salud.servicio;

// Importación de la excepción utilizada por OpenCSV
import com.opencsv.exceptions.CsvValidationException;

// Servicio encargado de gestionar la lectura y escritura del archivo CSV
import com.salud.archivos.CsvService;

// Clase que representa la información de un paciente
import com.salud.modelo.Paciente;

// Importaciones para trabajar con listas y manejar errores de entrada/salida
import java.io.IOException;
import java.util.List;

public class PacienteService {

    // Instancia de CsvService que permite acceder al archivo de pacientes
    // Se declara final para evitar que la referencia sea modificada
    private final CsvService csv = new CsvService();

    public boolean agregar(Paciente paciente)
            throws IOException, CsvValidationException {

        // Comprueba que el objeto recibido no sea nulo
        if (paciente == null) {
            throw new IllegalArgumentException(
                "El paciente no puede ser nulo."
            );
        }

        // Recupera todos los pacientes almacenados en el archivo CSV
        List<Paciente> pacientes = csv.leerPacientes();

        // Busca si ya existe un paciente con el mismo ID
        // Si encuentra uno, no permite agregar el nuevo registro
        if (buscarEnLista(pacientes, paciente.getId()) != null) {
            return false;
        }

        // Incorpora el nuevo paciente a la lista
        pacientes.add(paciente);

        // Guarda la lista actualizada en el archivo CSV
        csv.guardarPacientes(pacientes);

        // Indica que el paciente fue agregado correctamente
        return true;
    }

    public List<Paciente> listar()
            throws IOException, CsvValidationException {

        // Delega la lectura del archivo CSV en CsvService
        return csv.leerPacientes();
    }

    public Paciente buscarPorId(int id)
            throws IOException, CsvValidationException {

        // Lee los pacientes del archivo y utiliza el método auxiliar
        // buscarEnLista() para localizar el ID solicitado
        return buscarEnLista(csv.leerPacientes(), id);
    }

    private Paciente buscarEnLista(List<Paciente> pacientes, int id) {

        // Recorre cada paciente de la lista
        for (Paciente paciente : pacientes) {

            // Compara el ID del paciente actual con el ID buscado
            if (paciente.getId() == id) {

                // Devuelve el paciente cuando encuentra coincidencia
                return paciente;
            }
        }

        // Si termina el recorrido sin encontrar coincidencias,
        // devuelve null para indicar que el paciente no existe
        return null;
    }

    public boolean eliminar(int id)
            throws IOException, CsvValidationException {

        // Recupera todos los pacientes registrados
        List<Paciente> pacientes = csv.leerPacientes();

        // removeIf() recorre la lista y elimina los elementos
        // cuya condición sea verdadera.
        // En este caso, elimina al paciente cuyo ID coincida.
        // Devuelve true si se eliminó al menos un elemento.
        boolean eliminado = pacientes.removeIf(
            p -> p.getId() == id
        );

        // Solamente guarda los cambios si se encontró y eliminó
        // un paciente. Si no existe, evita reescribir el archivo.
        if (eliminado) {
            csv.guardarPacientes(pacientes);
        }

        // Devuelve el resultado de la operación
        return eliminado;
    }

    public boolean modificar(Paciente actualizado)
            throws IOException, CsvValidationException {

        // Comprueba que el objeto recibido no sea nulo
        if (actualizado == null) {
            throw new IllegalArgumentException(
                "El paciente actualizado no puede ser nulo."
            );
        }

        // Recupera todos los pacientes almacenados en el CSV
        List<Paciente> pacientes = csv.leerPacientes();

        // Busca dentro de la lista el paciente que tenga el mismo ID
        // que el objeto recibido con los datos actualizados
        Paciente existente = buscarEnLista(
            pacientes,
            actualizado.getId()
        );

        // Si no encuentra el paciente, no hay nada que modificar
        if (existente == null) {
            return false;
        }

        // Actualiza los atributos del paciente encontrado
        // utilizando los valores del objeto recibido
        existente.setNombre(actualizado.getNombre());
        existente.setApellido(actualizado.getApellido());
        existente.setEdad(actualizado.getEdad());
        existente.setTelefono(actualizado.getTelefono());
        existente.setEmail(actualizado.getEmail());

        // Guarda la lista con los datos modificados en el CSV
        csv.guardarPacientes(pacientes);

        // Indica que la modificación se realizó correctamente
        return true;
    }

    public int exportar(String ruta)
            throws IOException, CsvValidationException {

        // Recupera todos los pacientes registrados
        List<Paciente> pacientes = csv.leerPacientes();

        // Delega en CsvService la generación del archivo de exportación
        csv.exportarPacientes(pacientes, ruta);

        // Devuelve la cantidad de pacientes que se exportaron
        return pacientes.size();
    }
}
