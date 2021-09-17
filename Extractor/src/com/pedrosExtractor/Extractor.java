package com.pedrosExtractor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Extractor {
    public static void main(String[] args) throws FileNotFoundException {
        fileReader();
    }

    private static void fileReader() {
        try {
            Path filePath = Paths.get("Extractor/sample.txt");
            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (NoSuchFileException f){
            System.out.println("no such file go away and try again!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







