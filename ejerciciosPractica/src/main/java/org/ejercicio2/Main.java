package org.ejercicio2;

public class Main {

    public static void main(String[] args) {
        Tuberia tuberia = new Tuberia();

        // Creamos dos instancias de Productor y las iniciamos con el mismo conjunto de letras lanzadas
        Productor productor1 = new Productor(tuberia, 15);
        Productor productor2 = new Productor(tuberia, 1);
        Consumidor consumidor = new Consumidor(tuberia);

        productor1.start();
        productor2.start();
        consumidor.start();
    }
}