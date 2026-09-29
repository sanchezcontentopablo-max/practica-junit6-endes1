package edu.sanchezContentoPablo.endes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Calculadora")
class CalculadoraTest {

    private static final double DELTA = 1e-9;

    private final Calculadora calc = new Calculadora();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"2, 3, 5", "-2, 1, -1", "0, 0, 0", "0.1, 0.2, 0.3", "-1.5, -1.5, -3"})
    @DisplayName("suma")
    void sumar(double a, double b, double esperado) {
        assertEquals(esperado, calc.sumar(a, b), DELTA);
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({"3, 2, 1", "-2, 1, -3", "0, 0, 0", "2, 5, -3"})
    @DisplayName("resta")
    void restar(double a, double b, double esperado) {
        assertEquals(esperado, calc.restar(a, b), DELTA);
    }

    @ParameterizedTest(name = "{0} × {1} = {2}")
    @CsvSource({"2, 3, 6", "-2, 1, -2", "0, 5, 0", "-4, -2.5, 10"})
    @DisplayName("multiplicación")
    void multiplicar(double a, double b, double esperado) {
        assertEquals(esperado, calc.multiplicar(a, b), DELTA);
    }

    @ParameterizedTest(name = "{0} ÷ {1} = {2}")
    @CsvSource({"6, 3, 2", "-6, 3, -2", "1, 2, 0.5", "0, 7, 0", "1, 3, 0.333333333333"})
    @DisplayName("división")
    void dividir(double a, double b, double esperado) {
        assertEquals(esperado, calc.dividir(a, b), 1e-9);
    }

    @ParameterizedTest(name = "{0} ÷ 0 lanza excepción")
    @ValueSource(doubles = {5, 0, -3})
    @DisplayName("dividir entre cero lanza IllegalArgumentException")
    void dividirPorCero(double dividendo) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> calc.dividir(dividendo, 0));
        assertEquals("El divisor no puede ser cero", e.getMessage());
    }

    @Test
    @DisplayName("dividir entre -0.0 también lanza excepción")
    void dividirPorCeroNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calc.dividir(1, -0.0));
    }
}
