package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.CompanyObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CompanyDao {
    void insertCompany(CompanyObject companyObject);
}
