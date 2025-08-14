package dev.efren;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaAhorrosTest {

    @Test
    void testCuentaActivaEInactiva() {
        CuentaAhorros ca = new CuentaAhorros(9000, 12);
        assertFalse(ca.isActiva());
        ca.consignar(2000);
        assertFalse(ca.isActiva());
    }

    @Test
    void testExtractoConComision() {
        CuentaAhorros ca = new CuentaAhorros(15000, 12);
        for (int i = 0; i < 6; i++) {
            ca.retirar(1000);
        }
        ca.extractoMensual();
        assertTrue(ca.getComisionMensual() >= 2000);
    }
}
