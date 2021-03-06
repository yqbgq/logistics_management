package com.bishe.logistics_management.database.dataObject;

/**
 * 订单类数据信息类
 * @author 黄伟
 */
public class OrderObject {
    private int id;
    private int planuser;
    private String company;
    private String startPos;
    private String endPos;
    private String type;
    private String openDate;
    private String endDate;
    private String tags;
    private float weight;
    private float volume;
    private int method;
    private float price;
    private int state;
    private int checked;
    private int fromware;
    private int toware;
    private int otherfee;

    //Getter() and Setter()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlanuser() {
        return planuser;
    }

    public void setPlanuser(int planuser) {
        this.planuser = planuser;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStartPos() {
        return startPos;
    }

    public void setStartPos(String startPos) {
        this.startPos = startPos;
    }

    public String getEndPos() {
        return endPos;
    }

    public void setEndPos(String endPos) {
        this.endPos = endPos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getFromware() {
        return fromware;
    }

    public void setFromware(int fromware) {
        this.fromware = fromware;
    }

    public int getToware() {
        return toware;
    }

    public void setToware(int toware) {
        this.toware = toware;
    }

    public int getOtherfee() {
        return otherfee;
    }

    public void setOtherfee(int otherfee) {
        this.otherfee = otherfee;
    }

    //Getter() and Setter()
}
