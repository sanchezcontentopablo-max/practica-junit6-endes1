package edu.sanchezContentoPablo.endes;

import java.util.ArrayList;
import java.util.List;

/**
 * Valida contraseñas según unas reglas de seguridad básicas.
 *
 * <p>Una contraseña es válida si:</p>
 * <ul>
 *   <li>no es {@code null};</li>
 *   <li>tiene al menos {@value #LONGITUD_MINIMA} caracteres;</li>
 *   <li>contiene al menos una letra mayúscula;</li>
 *   <li>contiene al menos un dígito.</li>
 * </ul>
 *
 * @author Pablo Sánchez Contento
 */
public class ValidadorPassword {

    /** Número mínimo de caracteres exigido. */
    public static final int LONGITUD_MINIMA = 8;

    /**
     * Crea un validador con las reglas por defecto.
     */
    public ValidadorPassword() {
        // Sin estado que inicializar.
    }

    /**
     * Indica si una contraseña cumple todas las reglas.
     *
     * @param password la contraseña a validar
     * @return {@code true} si la contraseña cumple todas las reglas
     */
    public boolean validar(String password) {
        return errores(password).isEmpty();
    }

    /**
     * Devuelve la lista de reglas que incumple una contraseña, en lenguaje
     * natural, para poder mostrárselas al usuario.
     *
     * @param password la contraseña a comprobar
     * @return lista de mensajes de error; vacía si la contraseña es válida
     */
    public List<String> errores(String password) {
        List<String> errores = new ArrayList<>();
        if (password == null) {
            errores.add("La contraseña es obligatoria");
            return errores;
        }
        if (password.length() < LONGITUD_MINIMA) {
            errores.add("Debe tener al menos " + LONGITUD_MINIMA + " caracteres");
        }
        if (password.chars().noneMatch(Character::isUpperCase)) {
            errores.add("Debe contener al menos una letra mayúscula");
        }
        if (password.chars().noneMatch(Character::isDigit)) {
            errores.add("Debe contener al menos un número");
        }
        return errores;
    }
}
