package dev.efren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {

    @Test
    void testSobregiro() {
        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        cc.retirar(7000); 
        assertEquals(0, cc.getSaldo());
        assertEquals(2000, cc.getSobregiro());
    }

    @Test
    void testConsignarReduceSobregiroParcial() {
        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        cc.retirar(7000);
        cc.consignar(1000); 
        assertEquals(1000, cc.getSobregiro());
        assertEquals(0, cc.getSaldo());
    }

    @Test
    void testConsignarReduceSobregiroTotalYAgregaSaldo() {
        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        cc.retirar(7000); 
        cc.consignar(3000); 
        assertEquals(0, cc.getSobregiro());
        assertEquals(1000, cc.getSaldo());
    }

    @Test
    void testConsignarSinSobregiro() {
        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        cc.consignar(2000); 
        assertEquals(7000, cc.getSaldo());
        assertEquals(0, cc.getSobregiro());
    }

    @Test
    void testExtractoMensual() {
        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        cc.extractoMensual(); 
        assertTrue(cc.getSaldo() > 5000); 
    }

    @Test
    void testImprimir() {
        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        String output = cc.imprimir();
        assertTrue(output.contains("Saldo"));
        assertTrue(output.contains("Sobregiro"));
    }
}
