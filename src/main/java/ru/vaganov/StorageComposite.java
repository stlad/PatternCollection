package ru.vaganov;

import java.util.ArrayList;
import java.util.List;

public abstract class StorageComposite extends StorageComponent{

    private List<StorageComponent> childs;
    public StorageComposite(){
        childs = new ArrayList<StorageComponent>();
    }

    @Override
    public void add(StorageComponent component){
        childs.add(component);
    }

    @Override
    public void remove(StorageComponent component) {
        childs.remove(component);
    }

    @Override
    public StorageComponent getChild(int position) throws IndexOutOfBoundsException {
        if(position <0 || position>childs.size()){
            throw new IndexOutOfBoundsException();
        }

        return childs.get(position);
    }

    @Override
    public boolean hasChild() {
        return !childs.isEmpty();
    }

    @Override
    public void signUpForRecord(Storage storage){
        for(StorageComponent component : childs){
            component.signUpForRecord(storage);
        }
    }


    public int size(){
        return this.childs.size();
    }
}
