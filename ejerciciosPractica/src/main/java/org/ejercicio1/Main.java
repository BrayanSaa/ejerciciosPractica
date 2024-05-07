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
        SearchThread thread1 = new SearchThread(directory, "cosa");
        SearchThread thread2 = new SearchThread(directory, "otraPalabra");

        thread1.start();
        thread2.start();
    }
}
