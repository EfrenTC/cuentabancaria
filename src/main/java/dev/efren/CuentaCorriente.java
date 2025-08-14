package dev.efren;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            sobregiro += (cantidad - saldo);
            saldo = 0;
        }
        numeroRetiros++;
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                saldo += cantidad;
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
        numeroConsignaciones++;
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public String imprimir() {
        return "Saldo: " + saldo +
               ", Comisión mensual: " + comisionMensual +
               ", Transacciones: " + (numeroConsignaciones + numeroRetiros) +
               ", Sobregiro: " + sobregiro;
    }

    public float getSobregiro() {
        return sobregiro;
    }
}
