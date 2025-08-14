package dev.efren;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

  @Override
public void consignar(float cantidad) {
    if (activa) {   
        super.consignar(cantidad);
    }
    activa = saldo >= 10000;
}

@Override
public void retirar(float cantidad) {
    if (activa) {
        super.retirar(cantidad);
    }
    activa = saldo >= 10000;
}


    @Override
    public void extractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.extractoMensual();
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return "Saldo: " + saldo +
               ", Comisión mensual: " + comisionMensual +
               ", Transacciones: " + (numeroConsignaciones + numeroRetiros);
    }

    public boolean isActiva() {
        return activa;
    }
}
