package ru.gb.core.lesson4.lesson.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Создать программу управления банковским счетом (Account).
 * <p>
 * Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита и
 * сумму снятия средств. При этом она должна обрабатывать следующие исключительные ситуации:
 * <p>
 * Попытка создать счет с отрицательным начальным балансом должна вызывать
 * исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка внести депозит с отрицательной суммой должна вызывать
 * исключение IllegalArgumentException с соответствующим сообщением.
 * Попытка снять средства, сумма которых превышает текущий баланс,
 * должна вызывать исключение InsufficientFundsException с сообщением о недостаточных
 * средствах и текущим балансом.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 * выводя соответствующие сообщения об ошибках.
 * <p>
 * 2*.
 * Создать несколько типов счетов, унаследованных от Account, например: CreditAcciunt, DebitAccount.
 * Создать класс (Transaction), позволяющий проводить транзакции между счетами
 * (переводить сумму с одного счета на другой)
 * <p>
 * Класс Transaction должен возбуждать исключение в случае неудачной
 * попытки перевести деньги с одного счета на другой.
 * <p>
 * Продемонстрируйте работу вашего приложения:
 * Программа должна обрабатывать все исключения с помощью конструкции try-catch,
 * выводя соответствующие сообщения об ошибках.
 */
public class Program {


    public static void main(String[] args) {

        CreditAccount a = null;
        DebitAccount b = null;


        try {
            a = new CreditAccount("A", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            b = new DebitAccount("B", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a);
        System.out.println(b);

        Transaction transaction = new Transaction(a, b);
        try {
            transaction.trasit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Проведена операция снятия  НЕ ликвидной суммы");
        System.out.println(a);
        System.out.println(b);

        try {
            transaction.trasit(50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Проведена операция снятия ликвидной суммы");
        System.out.println(a);
        System.out.println(b);

        try {
            transaction.trasit(50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Проведена операция снятия ликвидной суммы");
        System.out.println(a);
        System.out.println(b);
        try {
            transaction.trasit(50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Проведена операция снятия НЕ ликвидной суммы");
        System.out.println(a);
        System.out.println(b);

//        Account accountA = null;
//        try {
//            accountA = new Account("A", 1);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//            ;
//        }
//
//
//        System.out.println(accountA);

//        if (accountA != null) {
//            try {
//                accountA.setBalance(100);
//                System.out.println(accountA);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//
//            try {
//                accountA.setBalance(-1);
//                System.out.println(accountA);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//
//            try {
//                accountA.getMoney(1);
//                System.out.println(accountA);
//            } catch (InsufficientFundsException e) {
//                System.out.println(e.getMessage());
//            }
//
//
//            try {
//                accountA.getMoney(100);
//                System.out.println(accountA);
//            } catch (InsufficientFundsException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }
}
