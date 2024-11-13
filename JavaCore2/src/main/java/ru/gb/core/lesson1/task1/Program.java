package ru.gb.core.lesson1.task1;

import ru.gb.core.lesson1.services.Calcul;
import ru.gb.core.lesson1.utils.Decorator;

public class Program {


    public static void main(String[] args) {

        int result = Calcul.add(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calcul.sub(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calcul.mul(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calcul.div(2, 2);
        System.out.println(Decorator.decorate(result));
    }
}
