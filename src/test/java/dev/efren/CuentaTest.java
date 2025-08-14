package dev.efren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    @Test
    void testConsignarYRetirar() {
        Cuenta c = new Cuenta(1000, 12);
        c.consignar(500);
        assertEquals(1500, c.getSaldo());
        c.retirar(500);
        assertEquals(1000, c.getSaldo());
    }

    @Test
    void testRetirarMasDelSaldo() {
        Cuenta c = new Cuenta(1000, 12);
        c.retirar(2000);
        assertEquals(1000, c.getSaldo());
    }

    @Test
    void testCalcularInteresMensual() {
        Cuenta c = new Cuenta(1200, 12);
        c.calcularInteresMensual();
        assertTrue(c.getSaldo() > 1200);
    }
}
