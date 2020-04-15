package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.service.OrderService;

import java.util.ArrayList;

public class OrderUtil {

    public static ArrayList<OrderObject> getNoPermission(){
        ArrayList<OrderObject> raw = OrderService.getAllOrder();
        ArrayList<OrderObject> orders = new ArrayList<>();
        for(int i=0;i<raw.size();i++){
            OrderObject o = raw.get(i);
            if(o.getChecked()==0 && o.getState()==0){
                orders.add(o);
            }
        }
        return orders;
    }

    public static ArrayList<OrderObject> getNoManagement(){
        ArrayList<OrderObject> raw = OrderService.getAllOrder();
        ArrayList<OrderObject> orders = new ArrayList<>();
        for(int i=0;i<raw.size();i++){
            OrderObject o = raw.get(i);
            if(o.getChecked()==1 && o.getState()==0){
                orders.add(o);
            }
        }
        return orders;
    }

    public static ArrayList<OrderObject> getManaged(){
        ArrayList<OrderObject> raw = OrderService.getAllOrder();
        ArrayList<OrderObject> orders = new ArrayList<>();
        for(int i=0;i<raw.size();i++){
            OrderObject o = raw.get(i);
            if(o.getChecked()==1 && o.getState()==1){
                orders.add(o);
            }
        }
        return orders;
    }

    public static ArrayList<OrderObject> getArrived(){
        ArrayList<OrderObject> raw = OrderService.getAllOrder();
        ArrayList<OrderObject> orders = new ArrayList<>();
        for(int i=0;i<raw.size();i++){
            OrderObject o = raw.get(i);
            if(o.getChecked()==1 && o.getState()==2){
                orders.add(o);
            }
        }
        return orders;
    }

    public static ArrayList<OrderObject> getPaid(){
        ArrayList<OrderObject> raw = OrderService.getAllOrder();
        ArrayList<OrderObject> orders = new ArrayList<>();
        for(int i=0;i<raw.size();i++){
            OrderObject o = raw.get(i);
            if(o.getChecked()==1 && o.getState()==3){
                orders.add(o);
            }
        }
        return orders;
    }
}
