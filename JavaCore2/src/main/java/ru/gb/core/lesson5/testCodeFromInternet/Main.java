package ru.gb.core.lesson5.testCodeFromInternet;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {


            Path testFilePath = Paths.get("file1.txt");

            Path fileName = testFilePath.getFileName();
            System.out.println(fileName);

            Path parent = testFilePath.getParent();
            System.out.println(parent);

            Path root = testFilePath.getRoot();
            System.out.println(root);

            boolean endWithTxt = testFilePath.endsWith("file1.txt");
            System.out.println(endWithTxt);

            boolean startsWithLalala = testFilePath.startsWith("lalalala");
            System.out.println(startsWithLalala);
        }
}
