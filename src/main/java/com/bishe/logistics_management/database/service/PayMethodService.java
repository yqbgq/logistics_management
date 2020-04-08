package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.PayMethodDao;
import com.bishe.logistics_management.database.dataObject.PayMethodObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付方式的服务类
 * @author 黄伟
 */
@Service
public class PayMethodService {
    private static PayMethodDao payMethodDao;

    /**
     * 构造函数
     * @param payMethodDao 支付方式的Dao层
     */
    @Autowired
    public PayMethodService(PayMethodDao payMethodDao){
        PayMethodService.payMethodDao = payMethodDao;
    }

    /**
     * 插入新增的支付方式
     * @param payMethodObject 支付方式数据类
     */
    public static void insertPayMethod(PayMethodObject payMethodObject){
        PayMethodService.payMethodDao.insertPayMethod(payMethodObject);
    }
}
