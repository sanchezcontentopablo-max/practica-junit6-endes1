package edu.sanchezContentoPablo.endes;

/**
 * Realiza las cuatro operaciones aritméticas básicas.
 *
 * @author Pablo Sánchez Contento
 */
public class Calculadora {
    /**
     * Crea una calculadora.
     */
    public Calculadora() {
        // Sin estado que inicializar.
    }

    /**
     * Suma dos números.
     * @param a primer sumando
     * @param b segundo sumando
     * @return la suma de a y b
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números.
     * @param a minuendo
     * @param b sustraendo
     * @return la resta de a menos b
     */
    public double restar(double a, double b) {
        return a - b;
    }

    /**
     * Multiplica dos números.
     * @param a primer factor
     * @param b segundo factor
     * @return el producto de a y b
     */
    public double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Divide dos números.
     * @param a dividendo
     * @param b divisor
     * @return el cociente de a entre b
     * @throws IllegalArgumentException si el divisor es 0
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }
        return a / b;
    }
}

