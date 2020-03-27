package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.CarObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
@Component("carDao")
public interface CarDao {
    void insertCar(CarObject carObject);

    ArrayList<CarObject> getAllCars();

    CarObject getById(int id);

    void replaceCar(CarObject carObject);
}
