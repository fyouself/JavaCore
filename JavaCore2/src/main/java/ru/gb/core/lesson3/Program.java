package ru.gb.core.lesson3;

import java.util.Arrays;
import java.util.Collections;

public class Program {

    public static void main(String[] args) {
        Employee[] employees = {
                Worker.create("Aaaa", 20, 1800),
                Worker.create("Bbbb", 30, 1000),
                Freelancer.creat("Cccc", 23, 5),
                Freelancer.creat("Dddd", 40, 8)
        };
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        Arrays.sort(employees, new SortAge());
        System.out.println();
        System.out.println("SORT Age ");

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

        System.out.println("SORT Salare ");
        Arrays.sort(employees, new SortSalare());
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }
    }
}
