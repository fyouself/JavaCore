package ru.gb.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final int WIN_COUNT = 3; // Выигрышная комбинация

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     *
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot) {
        // Проверка по трем горизонталям
        if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
        if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
        if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;

        // Проверка по трем вертикалям
        if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
        if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
        if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;

        // Проверка по двум диагоналям
        if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
        if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;

        return false;
    }


    static boolean checkWinV2(char dot) {
        //проверяем горизонтали
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY - WIN_COUNT + 1; y++) {
                if (check1(x, y, dot)) return true;
            }
        }
        //Проверяем вертикаль
        for (int x = 0; x < fieldSizeX- WIN_COUNT + 1; x++) {
            for (int y = 0; y < fieldSizeY ; y++) {
                if (check2(x, y, dot)) return true;
            }
        }

        //Проверяем горизонталь вправо вниз

        for (int x = 0; x < fieldSizeX- WIN_COUNT + 1; x++) {
            for (int y = 0; y < fieldSizeY - WIN_COUNT + 1; y++) {
                if (check3(x, y, dot)) return true;
            }
        }

        //Проверяем горизонталь вниз влево
        for (int x = 0; x < fieldSizeX- WIN_COUNT + 1; x++) {
            for (int y = fieldSizeY-1; y > 0 ; y--) {
                if (check4(x, y, dot)) return true;
            }
        }

        return false;
    }

    static boolean check1(int x, int y, char dot) {


        boolean res = false;
        int count = 0;
        int max = 0;
        for (int i = y; i < fieldSizeY; i++) {
            if (field[x][i] == dot) {
                count++;
            } else count = 0;
            if (count > max) max = count;
        }

        if (max >= WIN_COUNT) res = true;

        return res;
    }


    static boolean check2(int x, int y, char dot) {
        boolean res = false;
        int count = 0;
        int max = 0;
        for (int i = x; i < fieldSizeX; i++) {
            if (field[i][y] == dot) {
                count++;
            } else count = 0;
            if (count > max) max = count;
        }

        if (max >= WIN_COUNT) res = true;

        return res;
    }

    static boolean check3(int x, int y, char dot) {

        boolean res = false;
        int count = 0;
        int max = 0;
        int j = y;
        for (int i = x; i < fieldSizeX; i++) {
            if (field[i][j] == dot) {
                count++;
                j++;
            } else count = 0;
            if (count > max) max = count;
        }

        if (max >= WIN_COUNT) res = true;

        return res;

    }

    static boolean check4(int x, int y, char dot) {
        boolean res = false;
        int count = 0;
        int max = 0;
        int j = y;
        for (int i = x; i < fieldSizeX; i++) {
            if (field[i][j] == dot) {
                count++;
                j--;
            } else count = 0;
            if (count > max) max = count;
        }

        if (max >= WIN_COUNT) res = true;

        return res;

    }


    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, String s) {
        if (checkWinV2(dot)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Комп победил!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }


}
