package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {

    public static void main(String[] args) {

	// FileReader with Try-with-resource
        try (
            FileReader fRead = new FileReader("files/xanadu.txt")
                ){
            System.out.println((char)fRead.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    // BufferedReader with Try-with-resource *and* File Writer
        try (
          FileReader fRead = new FileReader("files/xanadu.txt");
          BufferedReader bRead = new BufferedReader(fRead);
          FileWriter fWrite = new FileWriter("files/targetfile.txt");
                ) {
                    String s;
                    while (true) {
                        if ((s=bRead.readLine()) == null){
                            break;
                        } else {
                            System.out.println(s);
                            fWrite.write(s + "\n");
                        }
                    }
        } catch (IOException e) {
            e.printStackTrace();
        }

    // Much Simpler way to Copy Files
        Path sourceFile = Paths.get("files", "xanadu.txt");
        Path targetFile = Paths.get("files", "newXanadu.txt");

    // Copy Actual File
        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
