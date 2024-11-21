package ru.gb.core.lesson4.lesson.task1;

public class MyArraySizeException extends CustomArrayException{
    public MyArraySizeException(String m, int x, int y) {
        super(m, x, y);
    }
}
