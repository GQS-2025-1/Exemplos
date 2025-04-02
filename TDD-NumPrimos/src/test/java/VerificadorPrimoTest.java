/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import ex01.tdd.numprimos.VerificadorPrimo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;/**
 *
 * @author rafaelamoreira
 */
public class VerificadorPrimoTest {
    @Test
    void deveRetornarFalseParaZero() {
        assertFalse(VerificadorPrimo.ePrimo(0));
    }

    @Test
    void deveRetornarFalseParaUm() {
        assertFalse(VerificadorPrimo.ePrimo(1));
    }

    @Test
    void deveRetornarTrueParaDois() {
        assertTrue(VerificadorPrimo.ePrimo(2));
    }

    @Test
    void deveRetornarTrueParaTreze() {
        assertTrue(VerificadorPrimo.ePrimo(13));
    }

    @Test
    void deveRetornarFalseParaVinte() {
        assertFalse(VerificadorPrimo.ePrimo(20));
    }
}
