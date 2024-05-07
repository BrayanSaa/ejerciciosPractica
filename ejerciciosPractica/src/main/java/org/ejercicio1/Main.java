package org.ejercicio1;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String directoryPath = "ejerciciosPractica/src/main/java/org/ejercicio1/archivos"; // Reemplaza con la ruta de tu directorio
        String searchWord = "cosa"; // La palabra que quieres buscar

        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("El directorio especificado no es válido.");
            return;
        }

        // Crear y lanzar dos hilos para buscar las palabras
        HiloBuscar thread1 = new HiloBuscar(directory, "cosa");
        HiloBuscar thread2 = new HiloBuscar(directory, "otraPalabra");

        thread1.start();
        thread2.start();
    }
}
