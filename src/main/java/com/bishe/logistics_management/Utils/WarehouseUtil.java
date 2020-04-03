package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.WarehouseUnit;
import java.util.ArrayList;

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
            sb.append(e.getBelongPos());sb.append("$$");
            sb.append(e.getBelong());sb.append("$$");
            sb.append(e.getId());sb.append("$$");
            sb.append(e.getCapacity());sb.append("$$");
            sb.append(e.getName());sb.append("$$");
            sb.append(e.getSize());sb.append("||");
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
        sb.append(unit.getBelongPos());sb.append("$$");
        sb.append(unit.getBelong());sb.append("$$");
        sb.append(unit.getId());sb.append("$$");
        sb.append(unit.getCapacity());sb.append("$$");
        sb.append(unit.getName());sb.append("$$");
        sb.append(unit.getSize());sb.append("||");
        return sb.toString();
    }

    /**
     * 将字符串转换成数组，方便逻辑操作
     * @param raw 需要被转换的字符串
     * @return 返回数组
     */
    public static ArrayList<WarehouseUnit> StringToArray(String raw){
        String[] tuple = raw.split("||");
        ArrayList<WarehouseUnit> units = new ArrayList<>();
        if(tuple.length > 0){
            for(String s : tuple){
                String[] temp = s.split("$$");
                WarehouseUnit e = new WarehouseUnit();
                e.setBelongPos(temp[0]);
                e.setBelong(temp[1]);
                e.setId(Integer.valueOf(temp[2]));
                e.setCapacity(Integer.valueOf(temp[3]));
                e.setName(temp[4]);
                e.setSize(Integer.valueOf(temp[5]));
                units.add(e);
            }
        }
        return units;
    }
}
