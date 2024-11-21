package ru.gb.core.lesson4.lesson.task1;

public class CustomArrayException extends  Exception{

    private final int x;
    private final int y;

    public CustomArrayException(String message, int x, int y ) {
        super(message);
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



}
