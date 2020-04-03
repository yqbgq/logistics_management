package com.bishe.logistics_management.database.dao;


import com.bishe.logistics_management.database.dataObject.WarehouseObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * 公司数据表的Dao
 * @author 黄伟
 */
@Mapper
@Repository
public interface WarehouseDao {

    /**
     * 插入数据库，插入一个仓库类
     * @param warehouseObject 仓库类
     */
    void insertWarehouse(WarehouseObject warehouseObject);

    /**
     * 获取全部仓库列表
     * @return 仓库列表
     */
    ArrayList<WarehouseObject> getAllWarehouse();

    /**
     * 按照ID获取仓库信息
     * @param id 仓库ID
     * @return 返回仓库
     */
    WarehouseObject getById(int id);

    /**
     * 更新仓库信息
     * @param warehouseObject 仓库类
     */
    void updateWarehouse(WarehouseObject warehouseObject);
}
