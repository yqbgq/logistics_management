package com.bishe.logistics_management.database.dataObject;

import org.apache.ibatis.type.Alias;

/**
 * 用户数据类
 * @author 黄伟
 */
@Alias("userObject")
public class UsersObject {
    private int id;
    private String name;
    private String password;
    private String department;
    private String job;
    private String phone;
    private String email;
    private int available;
    private String addition;
    private String sex;

    //Setter() And Getter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {return department;}

    public void setDepartment(String department) { this.department = department; }

    public String getJob() { return job; }

    public void setJob(String job) { this.job = job; }

    public String getPhone() {return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getAvailable() {return available; }

    public void setAvailable(int available) {this.available = available; }

    public String getAddition() {return addition; }

    public void setAddition(String addition) { this.addition = addition; }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }
    //Setter() And Getter()
}
