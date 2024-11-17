package ru.gb.core.lesson3;

public class Freelancer extends Employee {
    private int salareHour;


    private Freelancer(String name, int age, int salareHour) {
        super(name, age);
        this.salareHour = salareHour;
    }

    public static Freelancer creat(String name, int age, int salareHour) {
        if (name == null || name.length() < 3) {
            throw new RuntimeException("Некорректное имя человека.");
        }
        if (age < 18) {
            throw new RuntimeException("Некорректный возраст человека.");
        }
        return new Freelancer(name, age, salareHour);

    }


    @Override
    int salare() {
        return (int) (20.8 * 8 * this.salareHour);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", salare = " + salare() +
                ", salareHour = " + salareHour +
                '}';
    }
}

