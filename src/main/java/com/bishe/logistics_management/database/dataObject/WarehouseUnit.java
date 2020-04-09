package com.bishe.logistics_management.database.dataObject;

/**
 * 仓库库位类
 * @author 黄伟
 */
public class WarehouseUnit {
    private int id;

    private String belong;

    private String belongPos;

    private float capacity;//总容量

    private float size;//剩余容量

    private String name;

    //Getter() and Setter()
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

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter() and Setter()
}
