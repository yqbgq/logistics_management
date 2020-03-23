package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.MessageObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


/**
 * 和Message有关的Dao层
 */
@Mapper
@Repository
public interface MessageDao {
    /**
     * 插入信息表
     * @param message 要求信息类
     */
    void insertMessage(MessageObject message);

    ArrayList<MessageObject> getMessage(int id);
}
