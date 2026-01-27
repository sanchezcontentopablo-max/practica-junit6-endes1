package edu.sanchezContentoPablo.endes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidadorPasswordTest {
    ValidadorPassword validador = new ValidadorPassword();

    @Test
    void testPasswordValida() {
        assertTrue(validador.validar("Abcdefg1"));
        assertTrue(validador.validar("Password123"));
    }

    @Test
    void testPasswordNull() {
        assertFalse(validador.validar(null));
    }

    @Test
    void testPasswordCorta() {
        assertFalse(validador.validar("Abc1"));
    }

    @Test
    void testPasswordSinMayuscula() {
        assertFalse(validador.validar("abcdefg1"));
    }

    @Test
    void testPasswordSinNumero() {
        assertFalse(validador.validar("Abcdefgh"));
    }
}

