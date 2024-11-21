package ru.gb.core.lesson4.lesson.task1;

public class Program {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        UtilArray arrayUtils = new UtilArray();
        for (int i = 0; i < 10; i++){
            System.out.printf("\n***** Итерация #%d *****\n", i + 1);
            processArray(arrayUtils);
        }
    }


    public static void processArray(UtilArray utilArray) throws MyArraySizeException, MyArrayDataException {
        try {
            System.out.printf("Сумма всех элементов массива: %d\n", utilArray.processArray(utilArray.generateArray()));
        } catch (MyArrayDataException e) {
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());

        } catch (MyArraySizeException e) {
            System.out.printf("%s Требовалось 4x4, получили %dx%d\n", e.getMessage(), e.getX(), e.getY());
        }

    }


}
