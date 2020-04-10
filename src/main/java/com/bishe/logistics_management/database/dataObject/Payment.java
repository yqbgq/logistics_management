package com.bishe.logistics_management.database.dataObject;

/**
 * 支付数据类，包含支付方式ID以及支付金额
 * @author 黄伟
 */
public class Payment {
    int id;

    float num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNum() {
        return num;
    }

    public void setNum(float num) {
        this.num = num;
    }
}
