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

     //仓库的Dao层
    private static WarehouseDao warehouseDao;

    /**
     * 构造函数
     * @param warehouseDao 仓库的Dao层
     */
    @Autowired
    public WarehouseService(WarehouseDao warehouseDao){
        WarehouseService.warehouseDao = warehouseDao;
    }

    /**
     * 插入仓库数据表
     * @param warehouseObject 仓库类
     */
    public static void insertWarehouse(WarehouseObject warehouseObject){
        WarehouseService.warehouseDao.insertWarehouse(warehouseObject);
    }

    /**
     * 获取全部仓库的数据列表
     * @return 返回数据列表
     */
    public static ArrayList<WarehouseObject> getAllWarehouse(){
        return WarehouseService.warehouseDao.getAllWarehouse();
    }

    /**
     * 按照ID获取仓库数据类
     * @param id 仓库ID
     * @return 返回仓库数据类
     */
    public static WarehouseObject getById(int id){
        return WarehouseService.warehouseDao.getById(id);
    }

    /**
     * 更新仓库数据表
     * @param warehouseObject 数据类
     */
    public static void updateWarehouse(WarehouseObject warehouseObject){
        WarehouseService.warehouseDao.updateWarehouse(warehouseObject);
    }

}
