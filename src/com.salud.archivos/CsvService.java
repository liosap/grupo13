
package com.salud.archivos;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.salud.modelo.Paciente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvServiceFase1 {

    private static final Path ARCHIVO = Path.of("pacientes.csv");
    private static final String[] ENCABEZADO = {"id", "nombre", "apellido", "edad", "telefono", "email"};

    public void inicializarArchivo() throws IOException {
        if (Files.notExists(ARCHIVO) || Files.size(ARCHIVO) == 0) {
            guardarPacientes(List.of());
        }
    }

    public List<Paciente> leerPacientes() throws IOException, CsvValidationException {
        inicializarArchivo();
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(ARCHIVO, StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReader(reader)) {
            
            // Ignoramos o leemos el encabezado básico
            csvReader.readNext(); 
            String[] fila;

            while ((fila = csvReader.readNext()) != null) {
                int id = Integer.parseInt(fila[0].trim());
                String nombre = fila[1].trim();
                String apellido = fila[2].trim();
                int edad = Integer.parseInt(fila[3].trim());
                String telefono = fila[4].trim();
                String email = fila[5].trim();

                pacientes.add(new Paciente(id, nombre, apellido, edad, telefono, email));
            }
        }
        return pacientes;
    }

    public void guardarPacientes(List<Paciente> pacientes) throws IOException {
        try (Writer writer = Files.newBufferedWriter(ARCHIVO, StandardCharsets.UTF_8);
             CSVWriter csvWriter = new CSVWriter(writer)) {
            
            csvWriter.writeNext(ENCABEZADO);
            for (Paciente p : pacientes) {
                csvWriter.writeNext(new String[]{
                    String.valueOf(p.getId()),
                    p.getNombre(),
                    p.getApellido(),
                    String.valueOf(p.getEdad()),
                    p.getTelefono(),
                    p.getEmail()
                });
            }
        }
    }
}
