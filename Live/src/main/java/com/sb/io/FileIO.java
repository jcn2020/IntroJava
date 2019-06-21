package com.sb.io;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileIO {

    public static void main(String[] args) throws IOException {
        FileIO fio = new FileIO();
        //fio.go();
        fio.playwithFiles();
        //fio.stdinput();
        //fio.stdinputScanner();
    }

    public void go() throws IOException {
        try(FileReader fReader = new FileReader("pom.xml");
            BufferedReader bReader = new BufferedReader(fReader);

            FileWriter fWriter = new FileWriter("/tmp/out");
            PrintWriter printWriter = new PrintWriter(fWriter)) {

            int ch;
            //while ((ch = bReader.read()) != -1) {
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
                //processing

                printWriter.println(line);
            }

        }
    }

    public void playwithFiles() throws IOException {
        String userDir = System.getProperty("user.dir");
        String classPath = System.getProperty("java.class.path");
        System.out.println(userDir + ", classPath = " + classPath);
        Path pathToFile = Paths.get("pom.xml");
        Path absPath = pathToFile.toAbsolutePath();

        Files.copy(pathToFile, Paths.get("/tmp/pom2.xml"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(pathToFile + ", abspath = " + absPath);

        try(BufferedReader bReader = Files.newBufferedReader(Paths.get("pom.xml"))) {

        }
    }

    public void stdinput() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String line;
        System.out.print("Enter something ->");
        while((line = br.readLine()) != null && !line.equals("quit")) {
            System.out.println("Just read: " + line);
            System.out.print("Enter something ->");
        }
    }

    public void stdinputScanner() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String line;
        System.out.print("Enter something ->");
        while(scanner.hasNext() && (line = scanner.nextLine()) != null && !line.equals("quit")) {
            System.out.println("Just read: " + line);
            System.out.print("Enter something ->");
        }
    }
}
