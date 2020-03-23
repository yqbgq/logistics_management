package com.bishe.logistics_management.database.dataObject;

import org.apache.ibatis.type.Alias;

/**
 * 有关登录记录类
 * @author 黄伟
 */
@Alias("logRecordObject")
public class LogRecordObject {
    private int id;
    private String date;

    //Getter() and Setter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //Getter() and Setter()
}
