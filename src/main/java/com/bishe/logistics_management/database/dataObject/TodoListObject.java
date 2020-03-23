package com.bishe.logistics_management.database.dataObject;


import org.apache.ibatis.type.Alias;

/**
 * 代办事项数据对象
 * @author 黄伟
 */
@Alias("todoListObject")
public class TodoListObject {
    int id;
    int userid;
    String time;
    String content;

    //Getter() and Setter()
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //Getter() and Setter()
}
