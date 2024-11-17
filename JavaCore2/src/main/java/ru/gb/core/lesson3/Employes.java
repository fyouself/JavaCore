package ru.gb.core.lesson3;

import java.util.Iterator;
import java.util.function.Consumer;

public class Employes implements Iterable<Employee> {

    Employee[] employees = {
            Worker.create("Aaaa", 20, 1800),
            Worker.create("Bbbb", 30, 1000),
            Freelancer.creat("Cccc", 23, 5),
            Freelancer.creat("Dddd", 40, 8)
    };

    @Override
    public Iterator<Employee> iterator() {
        return null;  }
}
