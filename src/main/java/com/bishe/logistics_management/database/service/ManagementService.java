package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.ManagementDao;
import com.bishe.logistics_management.database.dataObject.ManagementObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
