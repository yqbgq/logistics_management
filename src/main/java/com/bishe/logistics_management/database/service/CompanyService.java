package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.CompanyDao;
import com.bishe.logistics_management.database.dataObject.CompanyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * 公司服务类
 * @author 黄伟
 */
@Service
public class CompanyService {
    private static CompanyDao companyDao;

    /**
     * 构造函数
     * @param companyDao 公司服务类dao层
     */
    @Autowired
    public CompanyService(CompanyDao companyDao){
        CompanyService.companyDao = companyDao;
    }

    /**
     * 插入数据库
     * @param companyObject 公司数据类
     */
    public static void insertCompany(CompanyObject companyObject){
        companyDao.insertCompany(companyObject);
    }

    /**
     * 获取所有的公司列表
     * @return 公司列表
     */
    public static ArrayList<CompanyObject> getAllCompany(){return companyDao.getAllCompany();}

    /**
     * 获取所有公司的总数
     * @return 公司总数
     */
    public static int getNum(){
        return companyDao.getNum();
    }
}
