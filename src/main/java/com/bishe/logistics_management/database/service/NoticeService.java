package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.NoticeDao;
import com.bishe.logistics_management.database.dataObject.NoticeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * 通知服务类
 * @author 黄伟
 */
@Service
public class NoticeService {

    private static NoticeDao noticeDao;

    /**
     * 构造函数
     * @param noticeDao 通知的Dao层类
     */
    @Autowired
    public NoticeService(NoticeDao noticeDao){
        NoticeService.noticeDao = noticeDao;
    }

    /**
     * 插入通知数据表
     * @param noticeObject 通知对象类
     */
    public static void insertNotice(NoticeObject noticeObject){
        noticeDao.insertNotice(noticeObject);
    }

    /**
     * 按照部门分类获取通知
     * @param department 部门ID
     * @return 返回通知列表
     */
    public static ArrayList<NoticeObject> getNotice(int department){
        return noticeDao.getNotice(department);
    }
}
