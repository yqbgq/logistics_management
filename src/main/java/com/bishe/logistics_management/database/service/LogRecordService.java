package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.LogRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * LogRecord数据表的服务处
 * @author 黄伟
 */
@Service
public class LogRecordService {

    private static LogRecordDao logRecordDao;

    /**
     * 构造函数，传入LogRecordDao
     * @param logRecordDao logRecordDao
     */
    @Autowired
    public LogRecordService(LogRecordDao logRecordDao){
        LogRecordService.logRecordDao = logRecordDao;
    }

    /**
     * 更新当前登录时间
     * @param id 用户ID
     */
    public static void updateTime(int id){logRecordDao.updateTime(id);}

    /**
     * 获取上次登录时间
     * @param id 用户ID
     * @return 返回上次登录时间
     */
    public static String getLastTime(int id){return logRecordDao.getLastTime(id);}
}
