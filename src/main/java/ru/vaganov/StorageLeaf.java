package ru.vaganov;

public abstract class StorageLeaf extends StorageComponent
{
    @Override
    @Deprecated
    public void add(StorageComponent component) throws Exception {throw new Exception("Нельзя удалять из листа дерева");}

    @Override
    @Deprecated
    public void remove(StorageComponent component) throws Exception {throw new Exception("Нельзя удалять из листа дерева");}
    @Override
    @Deprecated
    public StorageComponent getChild(int position) throws Exception {throw new Exception("Нельзя получить потомков листа дерева");};


    @Override
    public boolean hasChild(){
        return false;
    }

    @Override
    public void signUpForRecord(Storage storage){
        storage.addRecord(this.getName());
    }
}


