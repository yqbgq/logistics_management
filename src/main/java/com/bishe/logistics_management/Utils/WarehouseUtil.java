package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.dataObject.WarehouseObject;
import com.bishe.logistics_management.database.dataObject.WarehouseUnit;
import com.bishe.logistics_management.database.service.OrderService;
import com.bishe.logistics_management.database.service.WarehouseService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 仓库数据类的工具类
 * @author 黄伟
 */
public class WarehouseUtil {
    /**
     * 将数组转换为字符串，方便插入数据库
     * @param units 需要被转换的仓库库位数组
     * @return 返回数组
     */
    public static String ArrayToString(ArrayList<WarehouseUnit> units){
        StringBuilder sb = new StringBuilder();
        for(WarehouseUnit e : units){
            sb.append(e.getBelongPos());sb.append("<>");
            sb.append(e.getBelong());sb.append("<>");
            sb.append(e.getId());sb.append("<>");
            sb.append(e.getCapacity());sb.append("<>");
            sb.append(e.getName());sb.append("<>");
            sb.append(e.getSize());sb.append("!!");
        }
        return sb.toString();
    }

    /**
     * 将库位类转换为字符串
     * @param unit 库位数据类
     * @return 返回字符串
     */
    public static String UnitToString(WarehouseUnit unit){
        StringBuilder sb = new StringBuilder();
        sb.append(unit.getBelongPos());sb.append("<>");
        sb.append(unit.getBelong());sb.append("<>");
        sb.append(unit.getId());sb.append("<>");
        sb.append(unit.getCapacity());sb.append("<>");
        sb.append(unit.getName());sb.append("<>");
        sb.append(unit.getSize());sb.append("!!");
        return sb.toString();
    }

    /**
     * 将字符串转换成数组，方便逻辑操作
     * @param raw 需要被转换的字符串
     * @return 返回数组
     */
    public static ArrayList<WarehouseUnit> StringToArray(String raw){
        String[] tuple = raw.split("!!");
        ArrayList<WarehouseUnit> units = new ArrayList<>();
        if(tuple.length > 0){
            for(String s : tuple){
                String[] temp = s.split("<>");
                WarehouseUnit e = new WarehouseUnit();
                e.setBelongPos(temp[0]);
                e.setBelong(temp[1]);
                e.setId(Integer.valueOf(temp[2]));
                e.setCapacity(Float.valueOf(temp[3]));
                e.setName(temp[4]);
                e.setSize(Float.valueOf(temp[5]));
                units.add(e);
            }
        }
        return units;
    }

    /**
     * 处理实例，为仓库仓库添加属性信息，仓库总容量以及剩余容量
     * @param warehouseObject 仓库数据类
     */
    public static void ProcessInstance(WarehouseObject warehouseObject){
        ArrayList<WarehouseUnit> units = WarehouseUtil.StringToArray(warehouseObject.getUnits());
        int capacity = 0;
        int size = 0;
        for(WarehouseUnit e : units){
            capacity += e.getCapacity();
            size += e.getSize();
        }
        warehouseObject.setSize(size);
        warehouseObject.setCapacity(capacity);
    }

    /**
    public static HashMap<String,ArrayList<WarehouseUnit>> getAllWarehouseUnitList(){
        HashMap<String,ArrayList<WarehouseUnit>> map = new HashMap<>();
        ArrayList<WarehouseObject> warehouses = WarehouseService.getAllWarehouse();
        for(int i=0;i<warehouses.size();i++){
            ArrayList<WarehouseUnit> e = StringToArray(warehouses.get(i).getUnits());
            map.put(warehouses.get(i).getName(),e);
        }
        return map;
    }
     **/


    /**
     * 订单入库，削减仓库库位容积
     * @param orderId 订单ID
     * @param unitId 库位ID
     */
    public static void subUnitSize(int orderId,int unitId){
        OrderObject orderObject = OrderService.getOrderById(orderId);
        WarehouseObject warehouseObject = WarehouseService.getByName(orderObject.getEndPos());
        ArrayList<WarehouseUnit> units = WarehouseUtil.StringToArray(warehouseObject.getUnits());
        units.get(unitId-1).setSize(units.get(unitId-1).getSize()-orderObject.getVolume());
        warehouseObject.setUnits(WarehouseUtil.ArrayToString(units));
        WarehouseService.subUnitSize(warehouseObject);
    }

    /**
     * 在首页添加仓库仓储信息，包括仓库总体积和剩余体积
     * @param mv MV
     */
    public static void indexAddWarehouseInformation(ModelAndView mv){
        ArrayList<WarehouseObject> warehouseObjects = WarehouseService.getAllWarehouse();
        int capacity = 0;
        int size = 0;
        for(int i=0;i<warehouseObjects.size();i++){
            WarehouseObject w = warehouseObjects.get(i);
            ArrayList<WarehouseUnit> units = WarehouseUtil.StringToArray(w.getUnits());
            for(int j=0;j<units.size();j++){
                capacity += units.get(j).getCapacity();
                size += units.get(j).getSize();
            }
        }
        mv.addObject("size",size);
        mv.addObject("capacity",capacity);
    }
}
