
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
                    case 3 -> buscarPaciente();
                    case 4 -> modificarPaciente();
                    case 5 -> eliminarPaciente();
                    case 6 -> System.out.println("Gracias por utilizar el sistema.");
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                System.out.println("No se pudo completar la operación: " + e.getMessage());
            }
        } while (opcion != 6);

        TECLADO.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n================================");
        System.out.println("  SISTEMA DE PACIENTES (Fase 2)");
        System.out.println("================================");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Listar pacientes");
        System.out.println("3. Buscar paciente");
        System.out.println("4. Modificar paciente");
        System.out.println("5. Eliminar paciente");
        System.out.println("6. Salir");
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

    private static void buscarPaciente() throws Exception {
        System.out.println("\n--- BUSCAR PACIENTE ---");
        int id = leerEnteroPositivo("Ingrese ID: ");
        Paciente paciente = SERVICIO.buscarPorId(id);
        if (paciente == null) {
            System.out.println("Paciente no encontrado.");
        } else {
            System.out.println(paciente);
        }
    }

    private static void modificarPaciente() throws Exception {
        System.out.println("\n--- MODIFICAR PACIENTE ---");
        int id = leerEnteroPositivo("Ingrese ID del paciente: ");
        Paciente existente = SERVICIO.buscarPorId(id);
        if (existente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.println("Paciente actual: " + existente);
        System.out.println("Ingrese los nuevos datos:");

        Paciente actualizado = new Paciente(
                id,
                leerTexto("Nombre: "),
                leerTexto("Apellido: "),
                leerEnteroEnRango("Edad: ", 0, 130),
                leerTexto("Teléfono: "),
                leerTexto("Email: ")
        );

        if (SERVICIO.modificar(actualizado)) {
            System.out.println("Paciente modificado correctamente.");
        } else {
            System.out.println("No se pudo modificar el paciente.");
        }
    }

    private static void eliminarPaciente() throws Exception {
        System.out.println("\n--- ELIMINAR PACIENTE ---");
        int id = leerEnteroPositivo("Ingrese ID: ");
        if (SERVICIO.eliminar(id)) {
            System.out.println("Paciente eliminado correctamente.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
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
