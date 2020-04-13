package com.bishe.logistics_management.database.dataObject;

/**
 * Management的数据类
 * @author 黄伟
 */
public class ManagementObject {
    private int id;
    private int orderid;
    private int carid;
    private String planuser;
    private String manageuser;
    private int complete;
    private String endtime;

    //Getter() and Setter()

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getPlanuser() {
        return planuser;
    }

    public void setPlanuser(String planuser) {
        this.planuser = planuser;
    }

    public String getManageuser() {
        return manageuser;
    }

    public void setManageuser(String manageuser) {
        this.manageuser = manageuser;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    //Getter() and Setter()
}
