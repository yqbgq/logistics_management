package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.ManagementObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Management数据层的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface ManagementDao {
    /**
     * 插入Management数据表
     * @param managementObject Management数据类
     */
    void insertManagement(ManagementObject managementObject);

    /**
     * 按照ID获取Management
     * @param id ID
     * @return 返回Management
     */
    ManagementObject getByOrderId(int id);
}
