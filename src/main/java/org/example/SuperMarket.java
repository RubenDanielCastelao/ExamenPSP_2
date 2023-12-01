package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class SuperMarket {

    int nCajas;
    ArrayList[] cajas;
    int [] cajasDinero;
    int Resultado = 0;

    public SuperMarket(int nCajas) {
        this.nCajas = nCajas;
        cajas = new ArrayList[nCajas];
        for (int i = 1; i < nCajas; i++) {
            cajas[i] = new ArrayList<String>();
        }
        cajasDinero = new int[nCajas];
    }

    public synchronized void entrarSupermercado(String nombreCliente) {

        Random rand = new Random();
        int cajaAleatoria = rand.nextInt(nCajas-1) + 1;
        cajas[cajaAleatoria].add(nombreCliente);
        System.out.println("Caja " + cajaAleatoria + " Cola: " + cajas[cajaAleatoria].toString());
        try {
            wait(rand.nextInt(10000) + 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!cajas[cajaAleatoria].get(0).equals(nombreCliente)) {
            while (!cajas[cajaAleatoria].get(0).equals(nombreCliente)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        int pago = rand.nextInt(100) + 1;
        cajasDinero[cajaAleatoria] += pago;
        Resultado += pago;
        System.out.println("Caja " + cajaAleatoria + " ha recibido: " + pago + "€ de " + nombreCliente + ", Dinero total de la caja: " + cajasDinero[cajaAleatoria] + "€ ,Dinero total del supermercado: " + Resultado + "€");
        cajas[cajaAleatoria].remove(0);
        notifyAll();
    }
}
