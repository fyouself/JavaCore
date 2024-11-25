package ru.gb.core.lesson4.lesson.homework;

public class Account {
    private String name;
    private int balance;

    public  Account(String name, int balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Нельзя воодить отрицательный баланс", balance);
        }
        this.name = name;
        this.balance = balance;
    }

    public static Account create(String name, int balance) throws IllegalArgumentException {
        if(balance<0){
            throw new IllegalArgumentException("Баланc не должен быть отрицательным", balance);
        }

        return new Account(name,balance);
    }

    public void setBalance(int balance) throws IllegalArgumentException {
       if(balance < 0) {
           throw new IllegalArgumentException("Нельзя вводить отрицательную сумму", balance);
       }
        this.balance += balance;
    }

    public void getMoney (int money) throws InsufficientFundsException {
        if(this.balance - money < 0){
            throw new InsufficientFundsException(balance);
        }
        this.balance -= money;

    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getBalance() {
        return balance;
    }
}
