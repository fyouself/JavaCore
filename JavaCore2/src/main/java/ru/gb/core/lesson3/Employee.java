package ru.gb.core.lesson3;


public abstract class  Employee   {

    protected String name;
    protected int age;

    protected Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    abstract int salare ();

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }




}
