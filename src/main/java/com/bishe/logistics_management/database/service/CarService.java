package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.CarDao;
import com.bishe.logistics_management.database.dataObject.CarObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * 车辆信息服务类
 * @author 黄伟
 */
@Service
public class CarService {
    private static CarDao carDao;

    /**
     * 构造函数类
     * @param carDao 车辆的Dao层
     */
    @Autowired
    public CarService(CarDao carDao){
        CarService.carDao=carDao;
    }

    /**
     * 插入车辆信息表
     * @param carObject 车辆数据信息类
     */
    public static void insertCar(CarObject carObject){
        CarService.carDao.insertCar(carObject);
    }

    /**
     * 获取所有车辆信息
     * @return 返回车辆信息列表
     */
    public static ArrayList<CarObject> getAllCars(){
        return CarService.carDao.getAllCars();
    }

    /**
     * 按照ID获取车辆信息
     * @param id 车辆ID
     * @return 返回车辆信息
     */
    public static CarObject getById(int id){
        return CarService.carDao.getById(id);
    }

    /**
     * 修改车辆信息
     * @param carObject 车辆数据类
     */
    public static void replaceCar(CarObject carObject){CarService.carDao.replaceCar(carObject);}

    /**
     * 获取符合要求的空车
     * @return 返回车辆列表
     */
    public static ArrayList<CarObject> getEmptyCar(){
        return CarService.carDao.getEmptyCar();
    }

    /**
     * 修改车辆的剩余载荷空闲
     * @param id 车辆ID
     * @param size 车辆剩余载荷
     */
    public static void subSize(float id,float size){CarService.carDao.subSize(id,size);}

    /**
     * 修改车辆的离港时间
     * @param carObject 车辆数据类
     */
    public static void updateAway(CarObject carObject){CarService.carDao.updateAway(carObject);}

    /**
     * 车辆到达目的地店
     * @param carObject 车辆数据类
     */
    public static void arriveTarget(CarObject carObject){
        CarService.carDao.arriveTarget(carObject);
    }

    /**
     * 返回已经装载了货物但是没有出发的车辆列表
     * @return 车辆列表
     */
    public static ArrayList<CarObject> getUsed(){
        return CarService.carDao.getUsed();
    }

    /**
     * 车辆发出功能
     * @param id 车辆ID
     */
    public static void start(int id){
         CarService.carDao.start(id);
    }
}
