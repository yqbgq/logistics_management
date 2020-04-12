package com.bishe.logistics_management.database.dataObject;

/**
 * 车辆信息数据类
 * @author 黄伟
 */
public class CarObject {
    private int id;
    private int state;
    private String driver;
    private String phone;
    private String type;
    private String brand;
    private String times;
    private float length;
    private float size;
    private float capacity;
    private String tags;
    private String number;
    private String target;
    private String currents;
    private String awaydate;

    //Getter()  and Setter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCurrents() {
        return currents;
    }

    public void setCurrents(String currents) {
        this.currents = currents;
    }

    public String getAwaydate() {
        return awaydate;
    }

    public void setAwaydate(String awaydate) {
        this.awaydate = awaydate;
    }

    //Getter()  and Setter()
}
