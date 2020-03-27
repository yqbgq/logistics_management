package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.CompanyObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * 公司数据表的Dao
 * @author 黄伟
 */
@Mapper
@Repository
public interface CompanyDao {
    /**
     * 插入数据表
     * @param companyObject 公司数据类
     */
    void insertCompany(CompanyObject companyObject);

    ArrayList<CompanyObject> getAllCompany();
}
