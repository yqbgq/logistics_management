package com.bishe.logistics_management.database.dao;


import com.bishe.logistics_management.database.dataObject.PayRecordObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 支付记录数据类的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface PayRecordDao {

    /**
     * 插入数据库中的支付记录
     * @param payRecordObject 支付记录的数据类
     */
    void insertPayRecord(PayRecordObject payRecordObject);

    /**
     * 按照支付ID获取支付记录的数据类
     * @param id 支付记录的ID
     * @return 返回支付记录
     */
    PayRecordObject getPayRecordById(int id);

    /**
     * 按照订单的ID获取支付记录的数据类
     * @param orderId 订单ID
     * @return 返回支付记录
     */
    PayRecordObject getPayRecordByOrderId(int orderId);

    /**
     *指定月份收款总数
     * @param time 指定月份
     * @return 收款总数
     */
    int countMoneyMonth(String time);

    /**
     * 获取总共的收款数目
     * @return 总共收款数目
     */
    int countMoney();

    /**
     * 获取特定一天的收款数目
     * @param time 特定时间
     * @return 收款数
     */
    int getPayNumCertainDay(String time);

    /**
     * 获取特定一天的收款笔数
     * @param time 特定时间
     * @return 收款笔数
     */
    int getPayBillNumCertainDay(String time);
}
