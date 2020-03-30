package com.bishe.logistics_management.database.dataObject;

public class ManagementObject {
    int id;
    int orderid;
    int carid;
    String planuser;
    String manageuser;
    String away;

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

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    //Getter() and Setter()
}
