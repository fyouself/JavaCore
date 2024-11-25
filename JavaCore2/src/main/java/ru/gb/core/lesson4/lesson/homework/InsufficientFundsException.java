package ru.gb.core.lesson4.lesson.homework;

public class InsufficientFundsException  extends  Exception{

    private final int balance;

    public InsufficientFundsException(int balance) {
        super();
        this.balance = balance;
    }

    @Override

    public String getMessage() {
        return String.format("Недостаточно средств на счету. Баланс = %d", this.balance);
    }

}
