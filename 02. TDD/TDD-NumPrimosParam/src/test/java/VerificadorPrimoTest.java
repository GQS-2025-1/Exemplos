/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import ex01.tdd.numprimosparam.VerificadorPrimo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class VerificadorPrimoTest {
    @ParameterizedTest
    @CsvSource({
        "0, false",
        "1, false",
        "2, true",
        "3, true",
        "4, false",
        "13, true",
        "20, false",
        "17, true",
        "25, false"
    })
    void deveVerificarSeEhNumeroPrimo(int numero, boolean esperado) {
        assertEquals(esperado, VerificadorPrimo.ePrimo(numero));
    }
}
