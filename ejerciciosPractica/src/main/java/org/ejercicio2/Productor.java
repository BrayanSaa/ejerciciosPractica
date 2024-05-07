package org.ejercicio2;

public class Productor extends Thread {

    private Tuberia tuberia;
    private int cantidadLetras;

    public Productor(Tuberia t, int cantidadLetras) {
        this.tuberia = t;
        this.cantidadLetras = cantidadLetras;
    }

    @Override
    public void run() {
        int letrasProducidas = 0; // Contador para el número de letras producidas

        while (letrasProducidas < cantidadLetras) { // Verificar que no se hayan producido más de la cantidad máxima
            char letra = obtenerLetraNoRepetida();
            tuberia.lanzar(letra);
            System.out.println("Productor lanzó la letra " + letra);
            letrasProducidas++; // Incrementar el contador de letras producidas
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private static synchronized char obtenerLetraNoRepetida() { //Uso la syncronizacion para que agarren de a una letra
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char letra;
        do {
            letra = alfabeto.charAt((int)(Math.random() * 26));
        } while (Tuberia.getLetrasLanzadas().contains(letra)); // Verificar si la letra ya ha sido lanzada
        Tuberia.getLetrasLanzadas().add(letra); // Agregar la letra al conjunto de letras lanzadas
        return letra;
    }
}