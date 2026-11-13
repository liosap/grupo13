
package com.salud.modelo;

import java.util.regex.Pattern;

/**
 * Representa a un paciente dentro del sistema de salud.
 * Contiene la información personal básica y aplica validaciones estrictas
 * para asegurar la integridad de los datos (ID positivo, campos obligatorios,
 * rangos de edad válidos y formato de correo electrónico correcto).
 * 
 * @author Sistema de Salud (Grupo 13)
 * @version 1.0
 */
public class Paciente {

    // Patrón de expresiones regulares para validar el formato básico de un correo electrónico.
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    // Identificador único del paciente (inmutable y mayor que cero).
    private final int id;
    private String nombre;
    private String apellido;
    private int edad; // Edad del paciente en años (entre 0 y 130)
    private String telefono;
    private String email;

    /**
     * Crea una nueva instancia de {@code Paciente} con los datos especificados.
     * Todos los parámetros son validados durante la instanciación.
     *
     * @param id       Identificador único del paciente (debe ser mayor a 0).
     * @param nombre   Nombre del paciente (no puede ser nulo o vacío).
     * @param apellido Apellido del paciente (no puede ser nulo o vacío).
     * @param edad     Edad del paciente (debe estar entre 0 y 130).
     * @param telefono Teléfono de contacto (no puede ser nulo o vacío).
     * @param email    Correo electrónico válido.
     * @throws IllegalArgumentException si alguno de los valores no cumple con las reglas de validación.
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
     * Método auxiliar privado para validar que un texto no sea nulo ni esté vacío,
     * eliminando automáticamente los espacios en blanco sobrantes al inicio y al final.
     *
     * @param valor  El texto a validar.
     * @param campo  El nombre del campo (utilizado para describir el error).
     * @return El texto recortado (trimmed).
     * @throws IllegalArgumentException si el valor es nulo o está vacío.
     */
    private static String textoObligatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio.");
        }
        return valor.trim();
    }

    /**
     * Valida que el ID del paciente sea un número positivo.
     *
     * @param id Identificador a validar.
     * @throws IllegalArgumentException si el ID es menor o igual a cero.
     */
    private static void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }

    /**
     * Obtiene el identificador único del paciente.
     *
     * @return El ID del paciente.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido del paciente.
     *
     * @return El apellido del paciente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la edad del paciente.
     *
     * @return La edad en años.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el teléfono de contacto del paciente.
     *
     * @return El número de teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el correo electrónico del paciente.
     *
     * @return La dirección de email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece o actualiza el nombre del paciente, validando que no sea nulo o vacío.
     *
     * @param nombre El nuevo nombre.
     * @throws IllegalArgumentException si el nombre es nulo o está vacío.
     */
    public void setNombre(String nombre) {
        this.nombre = textoObligatorio(nombre, "nombre");
    }

    /**
     * Establece o actualiza el apellido del paciente, validando que no sea nulo o vacío.
     *
     * @param apellido El nuevo apellido.
     * @throws IllegalArgumentException si el apellido es nulo o está vacío.
     */
    public void setApellido(String apellido) {
        this.apellido = textoObligatorio(apellido, "apellido");
    }

    /**
     * Establece o actualiza la edad del paciente, validando que se encuentre en un rango lógico (0 a 130 años).
     *
     * @param edad La nueva edad.
     * @throws IllegalArgumentException si la edad es menor a 0 o mayor a 130.
     */
    public void setEdad(int edad) {
        if (edad < 0 || edad > 130) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 130 años.");
        }
        this.edad = edad;
    }

    /**
     * Establece o actualiza el teléfono del paciente, validando que no sea nulo o vacío.
     *
     * @param telefono El nuevo teléfono.
     * @throws IllegalArgumentException si el teléfono es nulo o está vacío.
     */
    public void setTelefono(String telefono) {
        this.telefono = textoObligatorio(telefono, "teléfono");
    }

    /**
     * Establece o actualiza el correo electrónico del paciente, validando tanto que no esté vacío 
     * como que cumpla con el formato estándar de una dirección de correo.
     *
     * @param email El nuevo correo electrónico.
     * @throws IllegalArgumentException si el email es nulo, vacío o tiene un formato no válido.
     */
    public void setEmail(String email) {
        String valor = textoObligatorio(email, "email");
        
        // Verifica si el texto cumple con la expresión regular del email
        if (!EMAIL_PATTERN.matcher(valor).matches()) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
        this.email = valor;
    }

    /**
     * Devuelve una representación en cadena de texto legible con los detalles principales del paciente.
     *
     * @return Una cadena formateada con los atributos del paciente.
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
