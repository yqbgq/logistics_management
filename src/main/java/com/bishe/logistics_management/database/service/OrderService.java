package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.OrderDao;
import com.bishe.logistics_management.database.dataObject.OrderObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * 订单的服务类
 * @author 黄伟
 */
@Service
public class OrderService {

    private static OrderDao orderDao;

    /**
     * 构造函数类
     * @param orderDao 订单的Dao层
     */
    @Autowired
    public OrderService(OrderDao orderDao){
        OrderService.orderDao = orderDao;
    }

    /**
     * 插入订单信息
     * @param orderObject 订单数据信息
     */
    public static void insertOrder(OrderObject orderObject){
        OrderService.orderDao.insertOrder(orderObject);
    }

    /**
     * 通过ID获取订单信息
     * @param id 订单ID
     * @return 返回订单数据类
     */
    public static OrderObject getOrderById(int id){
        return OrderService.orderDao.getOrderById(id);
    }

    /**
     * 获取全部订单
     * @return 订单列表
     */
    public static ArrayList<OrderObject> getAllOrder(){
        return OrderService.orderDao.getAllOrder();
    }

    /**
     * 通过公司名获取订单列表
     * @param company 公司名称
     * @return 订单列表
     */
    public static ArrayList<OrderObject> getByCompany(String company){
        return OrderService.orderDao.getByCompany(company);
    }

    /**
     * 获取未确认的订单
     * @return 订单列表
     */
    public static ArrayList<OrderObject> getNoCheck(){
        return OrderService.orderDao.getNoCheck();
    }

    /**
     * 获取未到达截止日期的订单
     * @param date 截止日期信息
     * @return 返回订单列表
     */
    public static ArrayList<OrderObject> getBeforeDate(String date){
        return OrderService.orderDao.getBeforeDate(date);
    }

    /**
     * 获取所有已经完成的订单
     * @return 返回订单列表
     */
    public static ArrayList<OrderObject> getCompleted(){
        return OrderService.orderDao.getCompleted();
    }

    public static void approveId(int id){OrderService.orderDao.approveId(id);}
}
