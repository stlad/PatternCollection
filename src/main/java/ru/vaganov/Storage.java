package ru.vaganov;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Класс-агрегатор, компановщик. Содержит объекты-потомки
 */
public class Storage {
    private List<String> records;
    private StorageComponent storageContent;
    public Storage(){
        records = new ArrayList<String>();
    }

    public void addRecord(String record){
        records.add(record);
    }

    public List<String> getRecords(){
        return records;
    }
}
