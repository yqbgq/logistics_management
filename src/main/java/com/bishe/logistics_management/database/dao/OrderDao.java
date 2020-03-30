package com.bishe.logistics_management.database.dao;


import com.bishe.logistics_management.database.dataObject.OrderObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

/**
 * 订单数据库的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface OrderDao {

    /**
     * 插入订单
     * @param orderObject 订单数据类
     */
    void insertOrder(OrderObject orderObject);

    /**
     * 按照ID获取订单
     * @param id 订单ID
     * @return 返回订单数据类
     */
    OrderObject getOrderById(int id);

    /**
     * 获取全部订单
     * @return 返回订单列表
     */
    ArrayList<OrderObject> getAllOrder();

    /**
     * 按照公司的名字获取所有相关的订单
     * @param company 公司名
     * @return 返回相关订单列表
     */
    ArrayList<OrderObject> getByCompany(String company);

    /**获取所有没有被确认的订单
     * @return 返回相关的订单列表
     */
    ArrayList<OrderObject> getNoCheck();

    /**获取某个日期之前的订单
     * @param date 时间
     * @return 时间之前的列表
     */
    ArrayList<OrderObject> getBeforeDate(String date);

    /**获取所有已经完成的订单
     * @return 订单列表
     */
    ArrayList<OrderObject> getCompleted();

    /**
     * 将订单审核通过，按照ID
     * @param id ID
     */
    void approveId(int id);

    /**
     * 获取已经审核通过但是还没有安排的订单
     * @param id ID
     * @return 返回符合要求的orderObject
     */
    OrderObject getNeedManage(int id);

    /**
     * 修改数据表信息，修改订单状态state为1
     * @param id 订单ID
     */
    void manageId(int id);
}
