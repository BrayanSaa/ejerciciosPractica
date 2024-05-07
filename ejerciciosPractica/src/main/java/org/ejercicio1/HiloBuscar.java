package org.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class HiloBuscar extends Thread {
    private File derectorio;
    private String buscarPalabra;

    public HiloBuscar(File directory, String buscarPalabra) {
        this.derectorio = directory;
        this.buscarPalabra = buscarPalabra;
    }

    @Override
    public void run() {
        int count = buscarArchivo(derectorio, buscarPalabra);
        System.out.println("Total de archivos que contienen la palabra '" + buscarPalabra + "' es: " + count);
    }

    private int buscarArchivo(File directorio, String buscarPalabra) {
        int contador = 0;
        File[] files = directorio.listFiles();
        if (files != null) {
            for (File archivo : files) {
                if (archivo.isDirectory()) {
                    contador += buscarArchivo(archivo, buscarPalabra);
                } else {
                    if (archivo.getName().endsWith(".txt")) {
                        contador += contienePalabra(archivo, buscarPalabra) ? 1 : 0;
                    }
                }
            }
        }
        return contador;
    }

    private boolean contienePalabra(File archivo, String buscarPalabra) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(buscarPalabra)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}