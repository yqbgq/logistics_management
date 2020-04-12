package com.bishe.logistics_management.database.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 增加LogRecordDao层
 * @author  黄伟
 */
@Mapper
@Repository
public interface LogRecordDao {
    /**
     * 更新当前时间
     * @param id 用户ID
     */
    void updateTime(int id);

    /**
     * 获取上次登录时间
     * @param id 用户ID
     * @return 返回上次登录时间
     */
    String getLastTime(int id);
}
