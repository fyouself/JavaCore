package ru.gb.core.lesson5.task1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class WorkWithFile {
    /**
     * 1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     * 2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     * 3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     * 4.* Написать метод, проверяющий, есть ли указанное слово в папке
     */

    private static final Random random = new Random();

    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;

    private static final String TO_SEARCH = "GeekBrains";


    public static void main(String[] args) throws IOException {
        writeFileContents("file1.txt", 30, 2);
        writeFileContents("file2.txt", 30, 2);
        concatenate("file1.txt", "file2.txt", "fileres.txt");
    }

    /**
     * Метод генерации некоторой последовательности символов
     *
     * @param amount кол-во символов
     * @return последовательность символов
     */
    private static String generateSymbols(int amount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            stringBuilder.append((char) random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        }
        return stringBuilder.toString();
    }

    /**
     * Записать последовательность символов в файл
     *
     * @param fileName имя файла
     * @param length   длина последовательности символов
     * @throws IOException
     */
    static void writeFileContents(String fileName, int length) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(generateSymbols(length).getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * Записать последовательность символов в файл, при этом, случайным образом дописать осознанное слово
     * для поиска
     *
     * @param fileName имя файла
     * @param length   длина последовательности символов
     * @param words    кол-во слов для поиска
     * @throws IOException
     */
    static void writeFileContents(String fileName, int length, int words) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < words; i++) {
                fileOutputStream.write(generateSymbols(length).getBytes(StandardCharsets.UTF_8));
                if (random.nextInt(3) == 0) {
                    fileOutputStream.write(TO_SEARCH.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write(generateSymbols(length).getBytes(StandardCharsets.UTF_8));
                }
            }
        }
    }

    static void concatenate(String file1, String file2, String fileResult) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileResult)) {
            int c;
            try (FileInputStream fileInputStream = new FileInputStream(file1)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }

            }
            try (FileInputStream fileInputStream = new FileInputStream(file2)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }

            }

        }

    }

    static boolean searchWord(String file, String search) throws IOException {
        int len = search.length();
        byte[] bytes = search.getBytes();
        int i = 0;
         try (FileInputStream fileInputStream = new FileInputStream(file)) {

             if(bytes[i])


         }
    }


}
