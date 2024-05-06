package org.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SearchThread extends Thread {
    private File directory;
    private String searchWord;

    public SearchThread(File directory, String searchWord) {
        this.directory = directory;
        this.searchWord = searchWord;
    }

    @Override
    public void run() {
        int count = searchFiles(directory, searchWord);
        System.out.println("Total de archivos que contienen la palabra '" + searchWord + "' es: " + count);
    }

    private int searchFiles(File directory, String searchWord) {
        int count = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    count += searchFiles(file, searchWord);
                } else {
                    if (file.getName().endsWith(".txt")) {
                        count += containsWord(file, searchWord) ? 1 : 0;
                    }
                }
            }
        }
        return count;
    }

    private boolean containsWord(File file, String searchWord) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchWord)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}