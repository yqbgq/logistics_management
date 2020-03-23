package com.bishe.logistics_management.database.dao;


import com.bishe.logistics_management.database.dataObject.NoticeObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * 通知的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface NoticeDao {
    /**
     * 插入通知表的方法
     * @param noticeObject 通知类
     */
    void insertNotice(NoticeObject noticeObject);

    /**
     * 获取所有该部门的通知
     * @param department 通知ID
     * @return 返回通知的列表
     */
    ArrayList<NoticeObject> getNotice(int department);//获取某个部门的通知
}
