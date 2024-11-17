package ru.gb.core.lesson3;

public class Worker extends Employee{

    private int salareMonth;

    private Worker(String name, int age, int salareMonth) {
        super(name, age);
        this.salareMonth= salareMonth;
    }

    public static Worker create(String name, int age, int salareMonth){
        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека.");
        }
        return new Worker(name, age, salareMonth);
    };



    @Override
    int salare() {
        return salareMonth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +'\''+
                ", salare = " + salare() +
                '}';
    }
}
