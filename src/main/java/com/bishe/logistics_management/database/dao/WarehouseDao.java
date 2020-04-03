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

    void insertWarehouse(WarehouseObject warehouseObject);

    ArrayList<WarehouseObject> getAllWarehouse();

    WarehouseObject getById(int id);

    void updateWarehouse(WarehouseObject warehouseObject);
}
