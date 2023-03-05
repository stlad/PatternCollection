package ru.vaganov;

import java.util.logging.Logger;

public abstract class StorageComponent {

    public abstract String getName();
    public abstract void add(StorageComponent component) throws Exception;
    public abstract void remove(StorageComponent component) throws Exception;
    public abstract StorageComponent getChild(int position) throws Exception;

    public abstract boolean hasChild();

    public abstract void signUpForRecord(Storage storage);
}


