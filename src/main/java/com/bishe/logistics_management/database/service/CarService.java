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

    public static ArrayList<CarObject> getEmptyCar(String current,String awaydate){
        return CarService.carDao.getEmptyCar(current,awaydate);
    }
}
