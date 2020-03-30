package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.ManagementDao;
import com.bishe.logistics_management.database.dataObject.ManagementObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementService {
    private static ManagementDao managementDao;

    @Autowired
    public ManagementService(ManagementDao managementDao){
        ManagementService.managementDao = managementDao;
    }

    public static void insertManagement(ManagementObject managementObject){
        ManagementService.managementDao.insertManagement(managementObject);
    }
}
