package ru.gb.core.lesson4.lesson.homework;

public class Account {
    private String name;
    private int balance;

    private  Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public static Account create(String name, int balance) throws IllegalArgumentException {
        if(balance<0){
            throw new IllegalArgumentException("Балан не должен быть отрицательным, вы ввел = %d", balance);
        }

        return new Account(name,balance);
    };


}
