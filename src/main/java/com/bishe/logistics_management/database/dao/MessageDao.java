package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.MessageObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


/**
 * 和Message有关的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface MessageDao {
    /**
     * 插入信息表
     * @param message 要求信息类
     */
    void insertMessage(MessageObject message);

    /**
     * 通过ID获取信息
     * @param id 信息的ID
     * @return 返回信息列表
     */
    ArrayList<MessageObject> getMessage(int id);
}
