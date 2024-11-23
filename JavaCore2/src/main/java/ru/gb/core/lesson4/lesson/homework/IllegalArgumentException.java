package ru.gb.core.lesson4.lesson.homework;

public class IllegalArgumentException extends Exception{
    int balance;

    public int getBalance() {
        return balance;
    }

    public IllegalArgumentException(String message, int balance) {
        super(message);
        this.balance = balance;
    }
}
