package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.CarObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

/**
 * 车辆的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface CarDao {
    /**
     * 插入车辆数据库
     * @param carObject 车辆数据类
     */
    void insertCar(CarObject carObject);

    /**
     * 获取所有的车辆列表
     * @return 车辆列表
     */
    ArrayList<CarObject> getAllCars();

    /**
     * 通过ID获取车辆信息
     * @param id 车辆ID
     * @return 返回车辆数据类
     */
    CarObject getById(int id);

    /**
     * 修改车辆信息
     * @param carObject 车辆数据类
     */
    void replaceCar(CarObject carObject);

    /**
     * 获取满足条件的车辆
     * @return 返回满足条件的车辆的列表
     */
    ArrayList<CarObject> getEmptyCar();

    /**
     * 修改车辆信息，减去载货空间
     * @param id 车辆ID
     * @param size 修改之后的载货空间
     */
    void subSize(float id,float size);

    /**
     * 修改车辆的离港信息
     * @param carObject 车辆类
     */
    void updateAway(CarObject carObject);

    /**
     * 设置车辆到达
     * @param carObject 车辆数据类
     */
    void arriveTarget(CarObject carObject);

    /**
     * 获取所有已经有货物装载并且没有发出的车辆
     * @return 车辆列表
     */
    ArrayList<CarObject> getUsed();

    /**
     * 将车辆设置为发出状态
     * @param id 车辆ID
     */
    void start(int id);

    /**
     * 获取车辆的综述
     * @return 数目
     */
    int getCarNum();

    /**
     * 获取在途车辆数目
     * @return 数目
     */
    int getCarNumInRoad();
}
