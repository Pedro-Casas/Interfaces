public class Factura {
    // Declaracion de la interfaz Constantes
public interface Constantes {
    double valorMaximo = 10000000.0;
    double valorMinimo = -0.01;
}
 
// Declaracion de la interfaz Variaciones
public interface Variaciones {
    void asignaValor(double x);
    void rebaja(double t);
}
 
// Declaracion de la clase Factura
public static class factura implements Constantes, Variaciones {
    private double totalSinIVA;
    public final static double IVA = 0.16;
 
    public double sinIVA() {
        return this.totalSinIVA;
    }
 
    public double conIVA() {
        return this.totalSinIVA * (1+IVA);
    }
 
    public void asignaValor(double x) {
        if (this.valorMinimo<x)
            this.totalSinIVA=x;
        else
            this.totalSinIVA=0;
    }
 
    public void rebaja(double t) {
        this.totalSinIVA *= (1-t/100);
    }
 
    public static void main (String [] args) {
        factura a = new factura();
        a.asignaValor(250.0);
 
        System.out.println("El precio sin IVA es: " + a.sinIVA());
        System.out.println("El precio con IVA es: " + a.conIVA());
        System.out.println("Rebajado durante el mes de mayo un 20%");
 
        a.rebaja(20);
        System.out.println("Rebajado sin IVA es: " + a.sinIVA());
        System.out.println("Rebajado con IVA es: " + a.conIVA());
    }
}
}
