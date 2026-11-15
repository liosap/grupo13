
package com.salud.modelo;

import java.util.regex.Pattern;

/**
 * Representa la entidad Paciente dentro del sistema de gestión de pacientes.
 *
 * Almacena los datos personales y de contacto de cada paciente, y establece
 * las reglas de validación necesarias para mantener la consistencia de la
 * información durante su creación y modificación.
 *
 * El identificador es inmutable y debe ser un número positivo. Los campos
 * de texto obligatorios no pueden ser nulos ni estar vacíos. La edad debe
 * encontrarse entre 0 y 130 años, y el correo electrónico debe cumplir
 * con un formato básico definido mediante una expresión regular.
 *
 * @author Sistema de Salud (Grupo 13)
 * @version 1.0
 */
public class Paciente {

    /**
     * Patrón de expresión regular utilizado para comprobar que una dirección
     * de correo electrónico cumpla con un formato básico.
     *
     * Esta validación no garantiza el cumplimiento de todas las reglas
     * establecidas por los estándares de direcciones de correo electrónico.
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    /**
     * Identificador único del paciente.
     *
     * Es inmutable porque se declara como {@code final} y no dispone
     * de un método modificador. Su valor debe ser mayor que cero.
     */
    private final int id;

    /** Nombre del paciente. */
    private String nombre;

    /** Apellido del paciente. */
    private String apellido;

    /** Edad del paciente expresada en años, con un rango permitido de 0 a 130. */
    private int edad;

    /** Número de teléfono de contacto del paciente. */
    private String telefono;

    /** Dirección de correo electrónico del paciente. */
    private String email;

    /**
     * Construye una instancia de {@code Paciente} a partir de los datos
     * personales y de contacto recibidos.
     *
     * Durante la inicialización se valida el identificador y se utilizan
     * los métodos modificadores para comprobar los valores de los demás
     * atributos.
     *
     * @param id identificador único del paciente; debe ser mayor que cero.
     * @param nombre nombre del paciente; no puede ser nulo ni estar vacío.
     * @param apellido apellido del paciente; no puede ser nulo ni estar vacío.
     * @param edad edad del paciente; debe estar comprendida entre 0 y 130 años.
     * @param telefono teléfono de contacto; no puede ser nulo ni estar vacío.
     * @param email dirección de correo electrónico; debe cumplir con el formato
     *              básico establecido por la expresión regular.
     * @throws IllegalArgumentException si alguno de los valores proporcionados
     *                                  no cumple con las reglas de validación.
     */
    public Paciente(int id, String nombre, String apellido, int edad,
                    String telefono, String email) {
        validarId(id);
        this.id = id;
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setTelefono(telefono);
        setEmail(email);
    }

    /**
     * Comprueba que una cadena de texto sea obligatoria y contenga
     * al menos un carácter distinto de los espacios en blanco.
     *
     * Si el valor es válido, elimina los espacios en blanco ubicados
     * al principio y al final mediante el método {@code trim()}.
     *
     * @param valor cadena de texto que se desea validar.
     * @param campo nombre del atributo al que corresponde el valor;
     *              se utiliza para identificar el error.
     * @return cadena de texto sin espacios en blanco al principio
     *         ni al final.
     * @throws IllegalArgumentException si el valor es {@code null}
     *                                  o está vacío después de aplicar
     *                                  {@code trim()}.
     */
    private static String textoObligatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio.");
        }
        return valor.trim();
    }

    /**
     * Valida que el identificador del paciente sea un número positivo.
     *
     * @param id identificador que se desea validar.
     * @throws IllegalArgumentException si el identificador es menor
     *                                  o igual a cero.
     */
    private static void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }

    /**
     * Obtiene el identificador único del paciente.
     *
     * @return identificador del paciente.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del paciente.
     *
     * @return apellido del paciente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la edad del paciente.
     *
     * @return edad del paciente expresada en años.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el teléfono de contacto del paciente.
     *
     * @return número de teléfono registrado.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene la dirección de correo electrónico del paciente.
     *
     * @return dirección de correo electrónico registrada.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece un nuevo nombre para el paciente.
     *
     * El valor se valida mediante {@link #textoObligatorio(String, String)}
     * antes de asignarlo al atributo correspondiente.
     *
     * @param nombre nuevo nombre del paciente.
     * @throws IllegalArgumentException si el nombre es {@code null}
     *                                  o está vacío.
     */
    public void setNombre(String nombre) {
        this.nombre = textoObligatorio(nombre, "nombre");
    }

    /**
     * Establece un nuevo apellido para el paciente.
     *
     * El valor se valida mediante {@link #textoObligatorio(String, String)}
     * antes de asignarlo al atributo correspondiente.
     *
     * @param apellido nuevo apellido del paciente.
     * @throws IllegalArgumentException si el apellido es {@code null}
     *                                  o está vacío.
     */
    public void setApellido(String apellido) {
        this.apellido = textoObligatorio(apellido, "apellido");
    }

    /**
     * Establece una nueva edad para el paciente.
     *
     * Comprueba que el valor se encuentre dentro del intervalo permitido,
     * incluidos ambos límites.
     *
     * @param edad nueva edad del paciente, expresada en años.
     * @throws IllegalArgumentException si la edad es menor que 0
     *                                  o mayor que 130.
     */
    public void setEdad(int edad) {
        if (edad < 0 || edad > 130) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 130 años.");
        }
        this.edad = edad;
    }

    /**
     * Establece un nuevo teléfono de contacto para el paciente.
     *
     * El valor se valida mediante {@link #textoObligatorio(String, String)}
     * antes de asignarlo al atributo correspondiente.
     *
     * @param telefono nuevo número de teléfono del paciente.
     * @throws IllegalArgumentException si el teléfono es {@code null}
     *                                  o está vacío.
     */
    public void setTelefono(String telefono) {
        this.telefono = textoObligatorio(telefono, "teléfono");
    }

    /**
     * Establece una nueva dirección de correo electrónico para el paciente.
     *
     * Primero comprueba que el valor sea obligatorio y luego verifica
     * que coincida con el patrón definido en {@link #EMAIL_PATTERN}.
     *
     * @param email nueva dirección de correo electrónico.
     * @throws IllegalArgumentException si el correo es {@code null},
     *                                  está vacío o no cumple con el
     *                                  formato básico establecido.
     */
    public void setEmail(String email) {
        String valor = textoObligatorio(email, "email");

        // Comprueba que la dirección coincida con el patrón de correo definido.
        if (!EMAIL_PATTERN.matcher(valor).matches()) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
        this.email = valor;
    }

    /**
     * Genera una representación textual del paciente con sus principales
     * datos personales y de contacto.
     *
     * @return cadena de texto con el identificador, nombre, apellido,
     *         edad, teléfono y correo electrónico del paciente.
     */
    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | Apellido: " + apellido
                + " | Edad: " + edad
                + " | Teléfono: " + telefono
                + " | Email: " + email;
    }
}
