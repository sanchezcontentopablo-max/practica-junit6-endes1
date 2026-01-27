package edu.sanchezContentoPablo.endes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    Calculadora calc = new Calculadora();

    @Test
    void testSumar() {
        assertEquals(5, calc.sumar(2, 3));
        assertEquals(-1, calc.sumar(-2, 1));
        assertEquals(0, calc.sumar(0, 0));
    }

    @Test
    void testRestar() {
        assertEquals(1, calc.restar(3, 2));
        assertEquals(-3, calc.restar(-2, 1));
        assertEquals(0, calc.restar(0, 0));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6, calc.multiplicar(2, 3));
        assertEquals(-2, calc.multiplicar(-2, 1));
        assertEquals(0, calc.multiplicar(0, 5));
    }

    @Test
    void testDividir() {
        assertEquals(2, calc.dividir(6, 3));
        assertEquals(-2, calc.dividir(-6, 3));
        assertEquals(0.5, calc.dividir(1, 2));
    }

    @Test
    void testDividirPorCero() {
        assertThrows(IllegalArgumentException.class, () -> calc.dividir(5, 0));
    }
}
