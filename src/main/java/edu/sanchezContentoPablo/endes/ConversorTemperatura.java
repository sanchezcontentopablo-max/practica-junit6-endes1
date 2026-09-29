package edu.sanchezContentoPablo.endes;

/**
 * Convierte temperaturas entre las escalas Celsius y Fahrenheit.
 *
 * <p>Las conversiones rechazan valores por debajo del cero absoluto, que no
 * tienen sentido físico.</p>
 *
 * @author Pablo Sánchez Contento
 */
public class ConversorTemperatura {

    /** Cero absoluto en grados Celsius. */
    public static final double CERO_ABSOLUTO_CELSIUS = -273.15;

    /** Cero absoluto en grados Fahrenheit. */
    public static final double CERO_ABSOLUTO_FAHRENHEIT = -459.67;

    /**
     * Crea un conversor de temperatura.
     */
    public ConversorTemperatura() {
        // Sin estado que inicializar.
    }

    /**
     * Convierte grados Celsius a Fahrenheit.
     *
     * @param c temperatura en grados Celsius
     * @return temperatura equivalente en grados Fahrenheit
     * @throws IllegalArgumentException si {@code c} está por debajo del cero absoluto
     */
    public double celsiusAFahrenheit(double c) {
        if (c < CERO_ABSOLUTO_CELSIUS) {
            throw new IllegalArgumentException("Temperatura por debajo del cero absoluto: " + c + " °C");
        }
        return c * 9.0 / 5.0 + 32.0;
    }

    /**
     * Convierte grados Fahrenheit a Celsius.
     *
     * @param f temperatura en grados Fahrenheit
     * @return temperatura equivalente en grados Celsius
     * @throws IllegalArgumentException si {@code f} está por debajo del cero absoluto
     */
    public double fahrenheitACelsius(double f) {
        if (f < CERO_ABSOLUTO_FAHRENHEIT) {
            throw new IllegalArgumentException("Temperatura por debajo del cero absoluto: " + f + " °F");
        }
        return (f - 32.0) * 5.0 / 9.0;
    }
}
