package ru.gb.core.lesson4.lesson.homework;

public class Transaction {

    private Account a;
    private Account b;

    /**
     *
     * @param a откуда переводится деньги
     * @param b куда переводятся деньги
     */
    public Transaction (Account a, Account b) {
        this.a = a;
        this.b = b;
    }


    public void trasit (int trasit) throws IllegalArgumentException, InsufficientFundsException {
        if ( trasit <= 0){
            throw new IllegalArgumentException("Нельзя переводить отрицательную сумму или нуль", trasit);
        } else if (a.getBalance() < trasit) {
            throw  new InsufficientFundsException(a.getBalance());
        }

        a.getMoney(trasit);
        b.setBalance(trasit);

    }


}
