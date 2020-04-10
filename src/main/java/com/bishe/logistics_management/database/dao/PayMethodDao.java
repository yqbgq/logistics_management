package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.PayMethodObject;
import com.bishe.logistics_management.database.dataObject.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * 支付方式的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface PayMethodDao {

    /**
     * 插入新增的支付方式
     * @param payMethodObject 支付方式的数据对象
     */
    void insertPayMethod(PayMethodObject payMethodObject);

    /**
     * 获取所有支付方式的列表
     * @return 支付方式列表
     */
    ArrayList<PayMethodObject> getAllPay();

    /**
     * 支付订单的操作方法
     * @param payment payment数据类，包含支付方式以及支付金额
     */
    void payOrder(Payment payment);
}
