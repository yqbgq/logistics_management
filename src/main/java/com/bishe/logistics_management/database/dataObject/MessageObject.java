package com.bishe.logistics_management.database.dataObject;

/**
 * 用户交流的数据类
 * @author 黄伟
 */
public class MessageObject {
    int id;
    int fromer;
    int toer;
    String message;
    String fromuser;

    //Getter() And Setter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromer() {
        return fromer;
    }

    public void setFromer(int fromer) {
        this.fromer = fromer;
    }

    public int getToer() {
        return toer;
    }

    public void setToer(int toer) {
        this.toer = toer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromuser() {
        return fromuser;
    }

    public void setFromuser(String fromuser) {
        this.fromuser = fromuser;
    }

    //Getter() And Setter()

}
