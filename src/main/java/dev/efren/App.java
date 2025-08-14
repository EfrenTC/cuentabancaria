package dev.efren;

public class App {
    public static void main(String[] args) {
        CuentaAhorros ca = new CuentaAhorros(12000, 12);
        ca.retirar(2000);
        ca.consignar(5000);
        ca.extractoMensual();
        System.out.println(ca.imprimir());

        CuentaCorriente cc = new CuentaCorriente(5000, 12);
        cc.retirar(8000);
        cc.consignar(2000);
        cc.extractoMensual();
        System.out.println(cc.imprimir());
    }
}
