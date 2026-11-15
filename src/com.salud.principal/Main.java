
package com.salud.principal;

import com.salud.modelo.Paciente;
import com.salud.servicio.PacienteService;
import com.salud.servicio.PacienteService.ResultadoImportacion;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal de la aplicación Sistema de Pacientes.
 *
 * Proporciona una interfaz de línea de comandos (CLI) que permite
 * al usuario interactuar con el sistema mediante un menú de opciones.
 * Recibe y valida los datos ingresados por consola y delega las
 * operaciones de gestión de pacientes en la clase {@link PacienteService}.
 *
 * @author Sistema de Salud
 * @version 1.0
 */
public class Main {

    /**
     * Lector de entrada estándar utilizado para capturar los datos
     * ingresados por el usuario desde la consola.
     */
    private static final Scanner TECLADO = new Scanner(System.in);

    /**
     * Servicio encargado de ejecutar las operaciones de gestión
     * de pacientes y aplicar las reglas correspondientes al sistema.
     */
    private static final PacienteService SERVICIO = new PacienteService();

    /**
     * Punto de entrada de la aplicación.
     *
     * Ejecuta el menú principal dentro de un ciclo que se mantiene
     * activo hasta que el usuario selecciona la opción de salida.
     * Las excepciones producidas durante las operaciones se capturan
     * para evitar la interrupción abrupta de la aplicación.
     *
     * @param args argumentos recibidos desde la línea de comandos;
     *             no se utilizan en esta aplicación.
     */
    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            try {
                // Selecciona y ejecuta la operación correspondiente a la opción ingresada.
                switch (opcion) {
                    case 1 -> registrarPaciente();
                    case 2 -> listarPacientes();
                    case 3 -> buscarPaciente();
                    case 4 -> modificarPaciente();
                    case 5 -> eliminarPaciente();
                    case 6 -> importarPacientes();
                    case 7 -> exportarPacientes();
                    case 8 -> System.out.println("Gracias por utilizar el sistema.");
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                // Informa el error producido sin finalizar abruptamente el programa.
                System.out.println("No se pudo completar la operación: " + e.getMessage());
            }
        } while (opcion != 8);

        // Cierra el lector de entrada estándar al finalizar la aplicación.
        TECLADO.close();
    }

    /**
     * Muestra en consola el menú principal con las operaciones
     * disponibles en el sistema.
     */
    private static void mostrarMenu() {
        System.out.println("\n================================");
        System.out.println("        SISTEMA DE PACIENTES");
        System.out.println("================================");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Listar pacientes");
        System.out.println("3. Buscar paciente");
        System.out.println("4. Modificar paciente");
        System.out.println("5. Eliminar paciente");
        System.out.println("6. Importar pacientes CSV");
        System.out.println("7. Exportar pacientes CSV");
        System.out.println("8. Salir");
        System.out.println("================================");
    }

    /**
     * Solicita al usuario los datos necesarios para registrar
     * un nuevo paciente.
     *
     * Los datos ingresados se utilizan para crear un objeto
     * {@link Paciente}, que posteriormente se envía al servicio
     * para intentar incorporarlo al sistema.
     *
     * @throws Exception si se produce un error durante la operación
     *                   de registro o en el acceso al almacenamiento.
     */
    private static void registrarPaciente() throws Exception {
        System.out.println("\n--- REGISTRAR PACIENTE ---");
        int id = leerEnteroPositivo("ID: ");
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        int edad = leerEnteroEnRango("Edad: ", 0, 130);
        String telefono = leerTexto("Teléfono: ");
        String email = leerTexto("Email: ");

        // Crea el objeto Paciente; el constructor aplica las validaciones del modelo.
        Paciente paciente = new Paciente(
                id, nombre, apellido, edad, telefono, email
        );

        if (SERVICIO.agregar(paciente)) {
            System.out.println("Paciente registrado correctamente.");
        } else {
            System.out.println("No se registró: el ID ya existe en el sistema.");
        }
    }

    /**
     * Obtiene y muestra todos los pacientes registrados en el sistema.
     * También informa la cantidad total de pacientes recuperados.
     *
     * @throws Exception si se produce un error al consultar
     *                   el archivo de almacenamiento.
     */
    private static void listarPacientes() throws Exception {
        System.out.println("\n--- LISTADO DE PACIENTES ---");
        List<Paciente> pacientes = SERVICIO.listar();

        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados actualmente.");
            return;
        }

        // Recorre la lista e imprime la representación textual de cada paciente.
        pacientes.forEach(System.out::println);
        System.out.println("Total de pacientes: " + pacientes.size());
    }

    /**
     * Solicita el identificador de un paciente y realiza su búsqueda
     * mediante el servicio de gestión.
     *
     * Si el paciente existe, muestra sus datos; de lo contrario,
     * informa que no se encontró el registro.
     *
     * @throws Exception si se produce un error durante la consulta
     *                   del almacenamiento.
     */
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

    /**
     * Permite modificar los datos de un paciente existente.
     *
     * Primero verifica que el paciente esté registrado.
     * Si existe, solicita los nuevos datos, construye un objeto
     * {@link Paciente} con el mismo identificador y envía la
     * modificación al servicio.
     *
     * @throws Exception si se produce un error durante la consulta
     *                   o la actualización del almacenamiento.
     */
    private static void modificarPaciente() throws Exception {
        System.out.println("\n--- MODIFICAR PACIENTE ---");
        int id = leerEnteroPositivo("Ingrese ID del paciente: ");
        Paciente existente = SERVICIO.buscarPorId(id);

        if (existente == null) {
            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.println("Paciente actual:");
        System.out.println(existente);
        System.out.println("\nIngrese los nuevos datos:");

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
            System.out.println("No se encontró el paciente para modificar.");
        }
    }

    /**
     * Solicita el identificador de un paciente y solicita al servicio
     * su eliminación del sistema.
     *
     * Informa al usuario si la operación se realizó correctamente
     * o si no se encontró un paciente con el identificador indicado.
     *
     * @throws Exception si se produce un error durante la operación
     *                   de eliminación o la actualización del archivo CSV.
     */
    private static void eliminarPaciente() throws Exception {
        System.out.println("\n--- ELIMINAR PACIENTE ---");
        int id = leerEnteroPositivo("Ingrese ID: ");

        if (SERVICIO.eliminar(id)) {
            System.out.println("Paciente eliminado correctamente.");
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }

    /**
     * Solicita la ruta de un archivo CSV externo e inicia la importación
     * de sus registros mediante el servicio de gestión de pacientes.
     *
     * Al finalizar, muestra la cantidad de pacientes agregados
     * y la cantidad de registros duplicados omitidos.
     *
     * @throws Exception si se produce un error de acceso al archivo,
     *                   de lectura o de validación durante la importación.
     */
    private static void importarPacientes() throws Exception {
        System.out.println("\n--- IMPORTAR PACIENTES ---");
        String ruta = leerTexto("Archivo a importar (ej: pacientes_importar.csv): ");

        ResultadoImportacion resultado = SERVICIO.importar(ruta);
        System.out.println("Importación finalizada.");
        System.out.println("Pacientes agregados: " + resultado.agregados());
        System.out.println("Pacientes duplicados: " + resultado.duplicados());
    }

    /**
     * Solicita una ruta de destino e inicia la exportación
     * de los pacientes registrados a un archivo CSV.
     *
     * Informa la cantidad de registros exportados al finalizar.
     *
     * @throws Exception si se produce un error durante la escritura
     *                   del archivo o la validación de la ruta.
     */
    private static void exportarPacientes() throws Exception {
        System.out.println("\n--- EXPORTAR PACIENTES ---");
        String ruta = leerTexto("Nombre o ruta del archivo de destino: ");
        int cantidad = SERVICIO.exportar(ruta);
        System.out.println("Exportación realizada correctamente.");
        System.out.println("Pacientes exportados: " + cantidad);
    }

    /**
     * Lee una cadena de texto ingresada por el usuario.
     *
     * Elimina los espacios en blanco ubicados al principio y al final
     * de la entrada mediante {@code trim()} y vuelve a solicitarla
     * mientras el resultado esté vacío.
     *
     * @param mensaje texto que se muestra como indicación al usuario.
     * @return cadena ingresada sin espacios externos y no vacía.
     */
    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = TECLADO.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El campo no puede estar vacío.");
        }
    }

    /**
     * Lee una entrada de consola y la convierte a un número entero.
     *
     * Si el usuario ingresa un valor que no puede convertirse
     * a entero, informa el error y vuelve a solicitar la entrada.
     *
     * @param mensaje texto que se muestra como indicación al usuario.
     * @return número entero ingresado correctamente.
     */
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(TECLADO.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido.");
            }
        }
    }

    /**
     * Solicita un número entero hasta obtener un valor mayor que cero.
     *
     * @param mensaje texto que se muestra como indicación al usuario.
     * @return número entero positivo ingresado por el usuario.
     */
    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int numero = leerEntero(mensaje);
            if (numero > 0) {
                return numero;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    /**
     * Solicita un número entero y verifica que se encuentre
     * dentro del intervalo indicado, incluidos ambos límites.
     *
     * @param mensaje texto que se muestra como indicación al usuario.
     * @param minimo valor mínimo permitido.
     * @param maximo valor máximo permitido.
     * @return número entero comprendido entre {@code minimo}
     *         y {@code maximo}, inclusive.
     */
    private static int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        while (true) {
            int numero = leerEntero(mensaje);
            if (numero >= minimo && numero <= maximo) {
                return numero;
            }
            System.out.println("El valor debe estar comprendido entre " + minimo + " y " + maximo + ".");
        }
    }
}
