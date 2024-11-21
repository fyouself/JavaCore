package ru.gb.core.lesson3;


public abstract class  Employee implements Comparable <Employee>  {

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

    @Override
    public int compareTo(Employee o) {
        return Integer.valueOf(this.salare()).compareTo(Integer.valueOf(o.salare()));
    }
}
