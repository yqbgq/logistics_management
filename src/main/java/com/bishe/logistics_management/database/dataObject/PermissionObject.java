package com.bishe.logistics_management.database.dataObject;

import org.apache.ibatis.type.Alias;

/**
 * 权限数据对象
 * @author 黄伟
 */
@Alias("permissionObject")
public class PermissionObject {
    private int id;
    private int users;
    private int orders;
    private int warehouse;
    private int plan;
    private int affairs;

    //Getter() And Setter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) {
        this.plan = plan;
    }

    public int getAffairs() {
        return affairs;
    }

    public void setAffairs(int affairs) {
        this.affairs = affairs;
    }
    //Getter() And Setter()

}
