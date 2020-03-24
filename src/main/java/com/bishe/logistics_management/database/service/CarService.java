package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.CarDao;
import com.bishe.logistics_management.database.dataObject.CarObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    private static CarDao carDao;

    @Autowired
    public CarService(CarDao carDao){
        CarService.carDao=carDao;
    }

    public static void insertCar(CarObject carObject){
        CarService.carDao.insertCar(carObject);
    }

    public static ArrayList<CarObject> getAllCars(){
        return CarService.carDao.getAllCars();
    }

    public static CarObject getById(int id){
        return CarService.carDao.getById(id);
    }
}
