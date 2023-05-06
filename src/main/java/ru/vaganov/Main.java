package ru.vaganov;

public class Main {
    public static void main(String[] args) {
        Strategy stratA = new ConcreteStrategyA();
        Strategy stratB = new ConcreteStrategyB();
        Strategy stratC = new ConcreteStrategyC();

        Context context = new Composition();
        context.setStrategy(stratA);
        System.out.println(context.executeStrategy()+"\n");


        context.setStrategy(stratB);
        System.out.println(context.executeStrategy()+"\n");


        context.setStrategy(stratC);
        System.out.println(context.executeStrategy());

    }
}