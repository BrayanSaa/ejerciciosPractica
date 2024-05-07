package org.ejercicio2;

import static java.lang.Thread.sleep;

public class Consumidor extends Thread {
    private Tuberia tuberia;

    public Consumidor(Tuberia t) {
        this.tuberia = t;
    }

    @Override
    public void run() {
        while (true) {
            char letra1 = tuberia.recoger();
            char letra2 = tuberia.recoger();
            System.out.println("Consumidor recogió las letras " + letra1 + " y " + letra2);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

