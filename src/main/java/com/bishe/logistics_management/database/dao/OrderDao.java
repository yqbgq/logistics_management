package com.bishe.logistics_management.database.dao;


import com.bishe.logistics_management.database.dataObject.OrderObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface OrderDao {

    //插入订单
    void insertOrder(OrderObject orderObject);

    //按照ID获取订单
    OrderObject getOrderById(int id);

    //获取全部订单
    ArrayList<OrderObject> getAllOrder();

    //按照公司名称获取订单
    ArrayList<OrderObject> getByCompany(String company);

    //获取所有没有被确认的订单
    ArrayList<OrderObject> getNoCheck();

    //获取某个日期之前的订单
    ArrayList<OrderObject> getBeforeDate(String date);

    //获取所有已经完成的订单
    ArrayList<OrderObject> getCompleted();
}
