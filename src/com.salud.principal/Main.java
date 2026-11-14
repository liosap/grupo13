// Interacción con el usuario
package com.salud.principal;

import com.salud.modelo.Paciente;
import com.salud.servicio.PacienteService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner TECLADO = new Scanner(System.in);
    private static final PacienteService SERVICIO = new PacienteService();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            try {
                switch (opcion) {
                    case 1 -> registrarPaciente();
                    case 2 -> listarPacientes();
                    case 3 -> System.out.println("Gracias por utilizar el sistema.");
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                System.out.println("No se pudo completar la operación: " + e.getMessage());
            }
        } while (opcion != 3);

        TECLADO.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n================================");
        System.out.println("  SISTEMA DE PACIENTES (Fase 1)");
        System.out.println("================================");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Listar pacientes");
        System.out.println("3. Salir");
        System.out.println("================================");
    }

    private static void registrarPaciente() throws Exception {
        System.out.println("\n--- REGISTRAR PACIENTE ---");
        int id = leerEnteroPositivo("ID: ");
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        int edad = leerEnteroEnRango("Edad: ", 0, 130);
        String telefono = leerTexto("Teléfono: ");
        String email = leerTexto("Email: ");

        Paciente paciente = new Paciente(id, nombre, apellido, edad, telefono, email);

        if (SERVICIO.agregar(paciente)) {
            System.out.println("Paciente registrado correctamente.");
        } else {
            System.out.println("No se registró: el ID ya existe.");
        }
    }

    private static void listarPacientes() throws Exception {
        System.out.println("\n--- LISTADO DE PACIENTES ---");
        List<Paciente> pacientes = SERVICIO.listar();

        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        pacientes.forEach(System.out::println);
        System.out.println("Total de pacientes: " + pacientes.size());
    }

    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = TECLADO.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("El dato no puede estar vacío.");
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(TECLADO.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int numero = leerEntero(mensaje);
            if (numero > 0) return numero;
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    private static int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        while (true) {
            int numero = leerEntero(mensaje);
            if (numero >= minimo && numero <= maximo) return numero;
            System.out.println("El valor debe estar entre " + minimo + " y " + maximo + ".");
        }
    }
}
