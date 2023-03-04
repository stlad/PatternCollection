package ru.vaganov;

public abstract class StorageLeaf extends StorageComponent
{
    @Override
    @Deprecated
    void add(StorageComponent component) throws Exception {throw new Exception("Нельзя удалять из листа дерева");}

    @Override
    @Deprecated
    void remove(StorageComponent component) throws Exception {throw new Exception("Нельзя удалять из листа дерева");}
    @Override
    @Deprecated
    StorageComponent getChild(int position) throws Exception {throw new Exception("Не реализовано");};
}


