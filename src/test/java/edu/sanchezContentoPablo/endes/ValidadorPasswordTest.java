package edu.sanchezContentoPablo.endes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Validador de contraseñas")
class ValidadorPasswordTest {

    private final ValidadorPassword validador = new ValidadorPassword();

    @Nested
    @DisplayName("validar()")
    class Validar {

        @ParameterizedTest(name = "\"{0}\" es válida")
        @ValueSource(strings = {"Abcdefg1", "Password123", "ÑANDÚ2024xx", "12345678A"})
        @DisplayName("acepta contraseñas que cumplen todas las reglas")
        void validas(String password) {
            assertTrue(validador.validar(password));
        }

        @ParameterizedTest(name = "\"{0}\" no es válida")
        @ValueSource(strings = {"Abc1", "abcdefg1", "Abcdefgh", "", "        ", "ABCDEFGH"})
        @DisplayName("rechaza contraseñas que incumplen alguna regla")
        void invalidas(String password) {
            assertFalse(validador.validar(password));
        }

        @Test
        @DisplayName("rechaza null")
        void nula() {
            assertFalse(validador.validar(null));
        }

        @Test
        @DisplayName("acepta exactamente la longitud mínima")
        void longitudMinima() {
            assertTrue(validador.validar("Abcdef12"));
            assertFalse(validador.validar("Abcde12"));
        }
    }

    @Nested
    @DisplayName("errores()")
    class Errores {

        @Test
        @DisplayName("devuelve una lista vacía para una contraseña válida")
        void sinErrores() {
            assertEquals(List.of(), validador.errores("Password123"));
        }

        @Test
        @DisplayName("con null solo indica que es obligatoria")
        void nula() {
            assertEquals(List.of("La contraseña es obligatoria"), validador.errores(null));
        }

        @Test
        @DisplayName("enumera todas las reglas incumplidas")
        void todasLasReglas() {
            assertEquals(List.of(
                    "Debe tener al menos 8 caracteres",
                    "Debe contener al menos una letra mayúscula",
                    "Debe contener al menos un número"), validador.errores("abc"));
        }

        @Test
        @DisplayName("indica solo la regla que falta")
        void unaRegla() {
            assertEquals(List.of("Debe contener al menos un número"), validador.errores("Abcdefgh"));
        }
    }
}
