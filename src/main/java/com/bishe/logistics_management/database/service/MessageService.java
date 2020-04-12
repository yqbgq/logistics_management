package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.MessageDao;
import com.bishe.logistics_management.database.dataObject.MessageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * 信息相关的服务层
 * @author 黄伟
 */
@Service
public class MessageService {

    private static MessageDao messageDao;

    /**
     * 构造函数，用于注入需要的massageDao
     * @param messageDao messageDao
     */
    @Autowired
    public MessageService(MessageDao messageDao){
        MessageService.messageDao = messageDao;
    }

    /**
     * 插入信息表
     * @param message 要求的信息类
     */
    public static void insertMessage(MessageObject message){messageDao.insertMessage(message);}

    /**
     * 按照ID获取信息类
     * @param id ID
     * @return 返回信息列表
     */
    public static ArrayList<MessageObject> getMessage(int id){return messageDao.getMessage(id);}
}
