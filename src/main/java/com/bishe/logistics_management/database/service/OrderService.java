package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.OrderDao;
import com.bishe.logistics_management.database.dataObject.OrderObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class OrderService {

    private static OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao){
        OrderService.orderDao = orderDao;
    }

    public static void insertOrder(OrderObject orderObject){
        OrderService.orderDao.insertOrder(orderObject);
    }

    public static OrderObject getOrderById(int id){
        return OrderService.orderDao.getOrderById(id);
    }

    public static ArrayList<OrderObject> getAllOrder(){
        return OrderService.orderDao.getAllOrder();
    }

    public static ArrayList<OrderObject> getByCompany(String company){
        return OrderService.orderDao.getByCompany(company);
    }

    public static ArrayList<OrderObject> getNoCheck(){
        return OrderService.orderDao.getNoCheck();
    }

    public static ArrayList<OrderObject> getBeforeDate(String date){
        return OrderService.orderDao.getBeforeDate(date);
    }

    public static ArrayList<OrderObject> getCompleted(){
        return OrderService.orderDao.getCompleted();
    }
}
