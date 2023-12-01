package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int numClientes = Integer.parseInt(JOptionPane.showInputDialog("Numero de clientes:"));
        int numCajas = Integer.parseInt(JOptionPane.showInputDialog("Numero de cajas:"));
        SuperMarket superMarket = new SuperMarket(numCajas);

        for (int i = 0; i < numClientes; i++) {
            ClienteThread cliente = new ClienteThread("Cliente " + i, superMarket);
            cliente.start();
        }
    }
}