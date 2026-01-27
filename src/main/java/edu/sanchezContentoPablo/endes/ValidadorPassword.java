package edu.sanchezContentoPablo.endes;

/**
 * Clase que valida contraseñas según reglas de seguridad básicas.
 */
public class ValidadorPassword {
    /**
     * Valida una contraseña según las siguientes reglas:
     * <ul>
     *   <li>No puede ser null</li>
     *   <li>Longitud mínima de 8 caracteres</li>
     *   <li>Al menos una letra mayúscula</li>
     *   <li>Al menos un número</li>
     * </ul>
     * @param password la contraseña a validar
     * @return true si la contraseña cumple todas las reglas, false en caso contrario
     */
    public boolean validar(String password) {
        if (password == null) return false;
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
}
