package com.bishe.logistics_management.database.dataObject;

public class WarehouseUnit {
    int id;

    String belong;

    String belongPos;

    int capacity;//总容量

    int size;//剩余容量

    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getBelongPos() {
        return belongPos;
    }

    public void setBelongPos(String belongPos) {
        this.belongPos = belongPos;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
