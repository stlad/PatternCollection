package ru.vaganov;

public abstract class StorageComponent {
    public abstract String getName();
    abstract void add(StorageComponent component) throws Exception;
    abstract void remove(StorageComponent component) throws Exception;
    abstract StorageComponent getChild(int position) throws Exception;

}


