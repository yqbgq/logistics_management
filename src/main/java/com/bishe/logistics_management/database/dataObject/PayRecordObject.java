package com.bishe.logistics_management.database.dataObject;

/**
 * 支付记录的数据类
 * @author 黄伟
 */
public class PayRecordObject {
    private int id;
    private int orders;
    private int payId;
    private String user;
    private float money;
    private String date;

    //Setter() and Getter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //Setter() and Getter()
}
