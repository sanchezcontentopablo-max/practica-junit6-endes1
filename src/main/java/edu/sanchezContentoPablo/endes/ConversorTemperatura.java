package edu.sanchezContentoPablo.endes;

/**
 * Clase que proporciona métodos para convertir temperaturas entre Celsius y Fahrenheit.
 */
public class ConversorTemperatura {
    /**
     * Convierte grados Celsius a Fahrenheit.
     * @param c temperatura en grados Celsius
     * @return temperatura equivalente en grados Fahrenheit
     */
    public double celsiusAFahrenheit(double c) {
        return c * 9.0 / 5.0 + 32.0;
    }

    /**
     * Convierte grados Fahrenheit a Celsius.
     * @param f temperatura en grados Fahrenheit
     * @return temperatura equivalente en grados Celsius
     */
    public double fahrenheitACelsius(double f) {
        return (f - 32.0) * 5.0 / 9.0;
    }
}

