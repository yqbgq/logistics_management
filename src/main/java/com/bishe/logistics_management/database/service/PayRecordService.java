package com.bishe.logistics_management.database.service;


import com.bishe.logistics_management.database.dao.PayRecordDao;
import com.bishe.logistics_management.database.dataObject.PayRecordObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付记录数据库的服务层
 * @author 黄伟
 */
@Service
public class PayRecordService {

    private static PayRecordDao payRecordDao;

    /**
     * 构造函数
     * @param payRecordDao Dao层
     */
    @Autowired
    public PayRecordService(PayRecordDao payRecordDao){
        PayRecordService.payRecordDao = payRecordDao;
    }

    /**
     * 插入支付记录
     * @param payRecordObject 支付记录数据类
     */
    public static void insertPayRecord(PayRecordObject payRecordObject){
        PayRecordService.payRecordDao.insertPayRecord(payRecordObject);
    }

    /**
     * 按照支付记录ID获取支付记录
     * @param id 支付记录ID
     * @return 返回支付记录
     */
    public static PayRecordObject getPayRecordById(int id){
        return PayRecordService.payRecordDao.getPayRecordById(id);
    }

    /**
     * 按照订单ID获取支付记录
     * @param orderId 订单ID
     * @return 支付记录
     */
    public static PayRecordObject getPayRecordByOrderId(int orderId){
        return PayRecordService.payRecordDao.getPayRecordByOrderId(orderId);
    }

    /**
     * 获取指定月份的收款数
     * @param time 指定月份
     * @return 收款数
     */
    public static int countMoneyMonth(String time){
        return PayRecordService.payRecordDao.countMoneyMonth(time);
    }

    /**
     * 获取总共收款数
     * @return 总共收款数
     */
    public static int countMoney(){
        return PayRecordService.payRecordDao.countMoney();
    }

    /**
     * 获取特定某天的收款数目
     * @param time 特定某天
     * @return 收款数目
     */
    public static int getPayNumCertainDay(String time){
        return PayRecordService.payRecordDao.getPayNumCertainDay(time);
    }

    /**
     * 获取特定某天的收款笔数
     * @param time 特定某天
     * @return 收款笔数
     */
    public static int getPayBillNumCertainDay(String time){
        return PayRecordService.payRecordDao.getPayBillNumCertainDay(time);
    }
}
