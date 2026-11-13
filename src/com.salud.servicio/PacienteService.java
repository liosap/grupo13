// Lógica de negocio y las operaciones de administración de pacientes
package com.salud.servicio;

import com.opencsv.exceptions.CsvValidationException;
import com.salud.archivos.CsvService;
import com.salud.modelo.Paciente;

import java.io.IOException;
import java.util.List;

public class PacienteService {

    private final CsvService csv = new CsvService();

    // Registra un paciente. Devuelve false si el ID ya existe.
    public boolean agregar(Paciente paciente) throws IOException, CsvValidationException {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo.");
        }

        List<Paciente> pacientes = csv.leerPacientes();
        if (buscarEnLista(pacientes, paciente.getId()) != null) {
            return false;
        }

        pacientes.add(paciente);
        csv.guardarPacientes(pacientes);
        return true;
    }

    public List<Paciente> listar() throws IOException, CsvValidationException {
        return csv.leerPacientes();
    }

    public Paciente buscarPorId(int id) throws IOException, CsvValidationException {
        return buscarEnLista(csv.leerPacientes(), id);
    }

    private Paciente buscarEnLista(List<Paciente> pacientes, int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }
}
