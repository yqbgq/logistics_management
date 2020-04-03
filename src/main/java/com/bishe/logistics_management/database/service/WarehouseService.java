package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.WarehouseDao;
import com.bishe.logistics_management.database.dataObject.WarehouseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 车辆信息服务类
 * @author 黄伟
 */
@Service
public class WarehouseService {

    private static WarehouseDao warehouseDao;

    @Autowired
    public WarehouseService(WarehouseDao warehouseDao){
        WarehouseService.warehouseDao = warehouseDao;
    }

    public static void insertWarehouse(WarehouseObject warehouseObject){
        WarehouseService.warehouseDao.insertWarehouse(warehouseObject);
    }

    public static ArrayList<WarehouseObject> getAllWarehouse(){
        return WarehouseService.warehouseDao.getAllWarehouse();
    }

    public static WarehouseObject getById(int id){
        return WarehouseService.warehouseDao.getById(id);
    }

    public static void updateWarehouse(WarehouseObject warehouseObject){
        WarehouseService.warehouseDao.updateWarehouse(warehouseObject);
    }

}
