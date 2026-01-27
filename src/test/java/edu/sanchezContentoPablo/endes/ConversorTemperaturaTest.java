package edu.sanchezContentoPablo.endes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConversorTemperaturaTest {
    ConversorTemperatura conv = new ConversorTemperatura();

    @Test
    void testCelsiusAFahrenheit() {
        assertEquals(32, conv.celsiusAFahrenheit(0), 0.0001);
        assertEquals(212, conv.celsiusAFahrenheit(100), 0.0001);
        assertEquals(98.6, conv.celsiusAFahrenheit(37), 0.0001);
    }

    @Test
    void testFahrenheitACelsius() {
        assertEquals(0, conv.fahrenheitACelsius(32), 0.0001);
        assertEquals(100, conv.fahrenheitACelsius(212), 0.0001);
        assertEquals(37, conv.fahrenheitACelsius(98.6), 0.0001);
    }
}

