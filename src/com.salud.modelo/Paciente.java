 package com.salud.modelo;

import java.util.regex.Pattern;

public class Paciente {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    private final int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;
    private String email;

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

    private static String textoObligatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo " + campo + " es obligatorio.");
        }
        return valor.trim();
    }

    private static void validarId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = textoObligatorio(nombre, "nombre");
    }

    public void setApellido(String apellido) {
        this.apellido = textoObligatorio(apellido, "apellido");
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 130) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 130 años.");
        }
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = textoObligatorio(telefono, "teléfono");
    }

    public void setEmail(String email) {
        String valor = textoObligatorio(email, "email");
        if (!EMAIL_PATTERN.matcher(valor).matches()) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
        this.email = valor;
    }

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
