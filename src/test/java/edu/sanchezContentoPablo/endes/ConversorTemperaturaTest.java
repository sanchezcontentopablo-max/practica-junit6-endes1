package edu.sanchezContentoPablo.endes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Conversor de temperatura")
class ConversorTemperaturaTest {

    private static final double DELTA = 1e-4;

    private final ConversorTemperatura conv = new ConversorTemperatura();

    @ParameterizedTest(name = "{0} °C = {1} °F")
    @CsvSource({"0, 32", "100, 212", "37, 98.6", "-40, -40", "-273.15, -459.67"})
    @DisplayName("Celsius a Fahrenheit")
    void celsiusAFahrenheit(double celsius, double fahrenheit) {
        assertEquals(fahrenheit, conv.celsiusAFahrenheit(celsius), DELTA);
    }

    @ParameterizedTest(name = "{0} °F = {1} °C")
    @CsvSource({"32, 0", "212, 100", "98.6, 37", "-40, -40", "-459.67, -273.15"})
    @DisplayName("Fahrenheit a Celsius")
    void fahrenheitACelsius(double fahrenheit, double celsius) {
        assertEquals(celsius, conv.fahrenheitACelsius(fahrenheit), DELTA);
    }

    @ParameterizedTest(name = "{0} °C")
    @ValueSource(doubles = {-273.16, -300, -1000})
    @DisplayName("rechaza Celsius por debajo del cero absoluto")
    void celsiusBajoCeroAbsoluto(double celsius) {
        assertThrows(IllegalArgumentException.class, () -> conv.celsiusAFahrenheit(celsius));
    }

    @ParameterizedTest(name = "{0} °F")
    @ValueSource(doubles = {-459.68, -500})
    @DisplayName("rechaza Fahrenheit por debajo del cero absoluto")
    void fahrenheitBajoCeroAbsoluto(double fahrenheit) {
        assertThrows(IllegalArgumentException.class, () -> conv.fahrenheitACelsius(fahrenheit));
    }

    @Test
    @DisplayName("convertir ida y vuelta devuelve el valor original")
    void idaYVuelta() {
        double original = 23.7;
        assertEquals(original, conv.fahrenheitACelsius(conv.celsiusAFahrenheit(original)), DELTA);
    }
}
