package ru.gb.core.lesson4.lesson.task1;
import java.util.Random;
public class UtilArray {
    private static Random random = new Random();

    /**
     * Посчитать сумму значений элементов массива
     * @param array массив
     * @return сумма значений элементов массива
     * @throws MyArraySizeException Некорректная размерность массива
     * @throws MyArrayDataException Некорректный формат данных
     */
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 && array[0].length != 4){
            throw new MyArraySizeException("Некорректный размер массива.", array.length, array[0].length);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                sum += parseInt(array[i][j], i, j);
            }
        }
        return sum;
    }




    public void printArray(String[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%s\t", array[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] generateArray(){
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = Integer.toString(random.nextInt(10, 100));
            }
        }

        if (random.nextInt(3) == 0){
            array[random.nextInt(array.length)][random.nextInt(array.length)] = "abc";
        }

        printArray(array);
        return array;
    }


    /**
     * Метод для превращения элемента массива в цифру
     * @param str значение элемента массива
     * @param x индекс элемента массива
     * @param y индекс элемента массива
     * @return число
     * @throws MyArrayDataException ошибка формата числа
     */
    private int parseInt (String str, int x, int y) throws MyArrayDataException {

        try {
            return Integer.parseInt(str);
        }
        catch ( NumberFormatException e){
            throw new MyArrayDataException(" Неправильный формат цифры ", x , y);
        }






    };




}
