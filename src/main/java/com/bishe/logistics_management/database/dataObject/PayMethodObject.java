package com.bishe.logistics_management.database.dataObject;

/**
 * 支付方式的数据类
 * @author 黄伟
 */
public class PayMethodObject {

    private int id;
    private String method;
    private String account;
    private String bank;
    private String address;
    private int balance;

    //Getter() and Setter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    //Getter() and Setter()
}
