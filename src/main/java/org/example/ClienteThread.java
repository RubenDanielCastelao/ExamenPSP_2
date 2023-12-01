package org.example;

import java.util.Random;

public class ClienteThread extends Thread{

    String nombre;
    SuperMarket superMarket;
    public ClienteThread(String nombre, SuperMarket superMarket) {
        this.nombre = nombre;
        this.superMarket = superMarket;
    }

    public void run() {
        System.out.println("Soy el cliente " + nombre + " y entro al supermercado");
        try {
            Random rand = new Random();
            int randomNumber = rand.nextInt(7001) + 1000;
            sleep(randomNumber);
        } catch (InterruptedException ex) {
            System.out.println("Error en espera cliente");
        }
        superMarket.entrarSupermercado(nombre);
    }
}
