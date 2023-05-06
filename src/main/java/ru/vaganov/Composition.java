package ru.vaganov;

public class Composition implements Context {
    private Strategy strategy;

    public String executeStrategy(){
        return strategy.execute();
    }

    public void setStrategy(Strategy strat){
        strategy = strat;
    }
}
