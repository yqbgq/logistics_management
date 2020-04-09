package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.ManagementObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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


    /**
     * 完成一个订单的安排
     * @param orderId 订单ID
     */
    void completeOrder(int orderId);

    /**
     * 获取是否承运了这票订单的车辆已经空了
     * @param carId 车辆ID
     * @return 返回车辆负责的安排表
     */
    ArrayList<ManagementObject> getRunningCar(int carId);
}
