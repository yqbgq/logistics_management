package com.bishe.logistics_management.database.dataObject;

import org.apache.ibatis.type.Alias;

/**
 * 公司数据类
 * @author 黄伟
 */
public class CompanyObject {
    int id;//公司ID
    int userid;//业务经理ID
    String person;//公司联系人姓名
    String name;//公司名称
    String phone;//公司联系电话
    String email;//公司联系邮箱
    String address;//公司地址
    String description;//公司描述

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //Getter and Setter
}
