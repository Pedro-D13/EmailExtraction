package com.thomas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Email {
    public static void main(String[] args) throws FileNotFoundException {
     /*   File myObject = new File("Email/sample.txt");
        System.out.println(myObject.exists());
        Scanner newReader = new Scanner(myObject);
        String firstLine = newReader.nextLine();
        System.out.println(firstLine);
        String secondLine = newReader.nextLine();
        System.out.println(secondLine);

      */

        fileReader();
    }

    private static void fileReader() {
        Path filePath = Paths.get("Email/sample.txt");

        try
        {
            String content = Files.readString(filePath);

            System.out.println(content);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
