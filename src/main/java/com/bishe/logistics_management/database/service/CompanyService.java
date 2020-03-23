package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.CompanyDao;
import com.bishe.logistics_management.database.dataObject.CompanyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private static CompanyDao companyDao;

    @Autowired
    public CompanyService(CompanyDao companyDao){
        CompanyService.companyDao = companyDao;
    }

    public static void insertCompany(CompanyObject companyObject){
        companyDao.insertCompany(companyObject);
    }
}
