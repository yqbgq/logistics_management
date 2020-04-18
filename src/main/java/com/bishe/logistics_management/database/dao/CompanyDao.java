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

    /**
     * 获取所有的公司信息
     * @return 公司列表
     */
    ArrayList<CompanyObject> getAllCompany();

    /**
     * 获取所有公司的总数目
     * @return 公司总数
     */
    int getNum();
}
