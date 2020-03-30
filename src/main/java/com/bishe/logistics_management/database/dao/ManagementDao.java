package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.ManagementObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagementDao {
    void insertManagement(ManagementObject managementObject);
}
