package util;

import java.util.regex.Pattern;

public class Validador {

    public static boolean validarRUT(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches("^[0-9]{7,8}-[0-9kK]$", rut.trim());
    }

    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email.trim());
    }

    public static boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            return false;
        }
        return Pattern.matches("^(\\+56|0)?[0-9]{9}$", telefono.trim());
    }

    public static boolean validarTextoNoVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean validarNumeroPositivo(double numero) {
        return numero > 0;
    }

    public static boolean validarCalificacion(int calificacion) {
        return calificacion >= 1 && calificacion <= 5;
    }

    public static String sanitizarTexto(String texto) {
        if (texto == null) return "";
        return texto.trim().replaceAll("\\s+", " ");
    }
}