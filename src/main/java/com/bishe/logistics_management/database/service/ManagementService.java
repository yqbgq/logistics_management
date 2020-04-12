package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.ManagementDao;
import com.bishe.logistics_management.database.dataObject.ManagementObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Management的服务层
 * @author 黄伟
 */
@Service
public class ManagementService {
    private static ManagementDao managementDao;

    /**
     * 构造函数
     * @param managementDao Management 的Dao层类
     */
    @Autowired
    public ManagementService(ManagementDao managementDao){
        ManagementService.managementDao = managementDao;
    }

    /**
     * 插入数据表的Management
     * @param managementObject Management数据类安排类
     */
    public static void insertManagement(ManagementObject managementObject){
        ManagementService.managementDao.insertManagement(managementObject);
    }

    /**
     * 按照订单获取Management
     * @param id 计划ID
     * @return 返回Management
     */
    public static ManagementObject getByOrderId(int id){
        return ManagementService.managementDao.getByOrderId(id);
    }

    /**
     * 完成某个订单的安排
     * @param orderId 订单ID
     */
    public static void completeOrder(int orderId){
        ManagementService.managementDao.completeOrder(orderId);
    }

    /**
     * 获取承运了这票订单的车辆的其余承运计划
     * @param carId 车辆ID
     * @return 返回车辆计划表
     */
    public static ArrayList<ManagementObject> getRunningCar(int carId){
        return ManagementService.managementDao.getRunningCar(carId);
    }

    /**
     * 获取所有没有完成的计划的列表
     * @return 计划列表
     */
    public static ArrayList<ManagementObject> getUncomplete(){
        return ManagementService.managementDao.getUncomplete();
    }
}
