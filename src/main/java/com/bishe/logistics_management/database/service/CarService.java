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
     * @param awaydate 车辆离港日期
     * @return 返回车辆列表
     */
    public static ArrayList<CarObject> getEmptyCar(String awaydate){
        return CarService.carDao.getEmptyCar(awaydate);
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
}
