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
     * @param awaydate 离港日期
     * @return 返回满足条件的车辆的列表
     */
    ArrayList<CarObject> getEmptyCar(String awaydate);

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
}
