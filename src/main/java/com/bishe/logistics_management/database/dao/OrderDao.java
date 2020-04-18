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
     * @return 返回符合要求的orderObject
     */
    ArrayList<OrderObject> getNeedManage();

    /**
     * 修改数据表信息，修改订单状态state为1
     * @param id 订单ID
     */
    void manageId(int id);

    /**
     * 获取所有在途运单信息
     * @return 在途运单列表
     */
    ArrayList<OrderObject> getAllOnRoad();

    /**
     * 获取到达仓库的订单信息
     * @return 订单列表
     */
    ArrayList<OrderObject> getToWarehouse();

    /**
     * 完成这个订单，修改订单的状态state
     * @param id 订单ID
     */
    void completeOrder(int id);

    /**
     * 获取所有需要付款的订单的列表
     * @return 返回订单列表
     */
    ArrayList<OrderObject> getNeedPay();

    /**
     * 支付订单
     * @param id 订单ID
     */
    void payOrder(int id);

    /**
     * 获取在途订单，且不是前往仓库
     * @return 返回订单列表
     */
    ArrayList<OrderObject> getToOther();

    /**
     * 获取所有订单的总数
     * @return 订单总数
     */
    int getTotalNum();

    /**
     * 获取当前月份订单数目
     * @param time 当前月份
     * @return 数目
     */
    int getMonthNum(String time);

    /**
     * 获取每天订单的数目
     * @param time 该天的表述
     * @return 数目
     */
    int getDayNum(String time);

    /**
     * 获取所有公司的列表
     * @return 公司列表
     */
    ArrayList<String> getAllCompanies();

    /**
     * 获取特定公司相关订单的数目
     * @param company 公司名称
     * @return 相关订单数目
     */
    int getCertainCompanyNum(String company);

}
