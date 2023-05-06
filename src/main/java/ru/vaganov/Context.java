package ru.vaganov;

public interface Context {
    public String executeStrategy();
    public void setStrategy(Strategy strat);

}
