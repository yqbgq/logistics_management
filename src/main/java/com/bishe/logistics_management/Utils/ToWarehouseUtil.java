package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.dataObject.ToWarehouseObject;
import com.bishe.logistics_management.database.dataObject.WarehouseObject;
import com.bishe.logistics_management.database.dataObject.WarehouseUnit;
import com.bishe.logistics_management.database.service.WarehouseService;
import java.util.ArrayList;

/**
 * 到达仓库订单的数据类的工具类
 * @author 黄伟
 */
public class ToWarehouseUtil {


    /**
     * 将仓库信息以及订单信息捆绑在一起
     * @param orders 订单信息
     * @return 返回捆绑结束后的到达仓库订单列表
     */
    public static ArrayList<ToWarehouseObject> combine(ArrayList<OrderObject> orders){
        ArrayList<ToWarehouseObject> toes = new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            OrderObject order = orders.get(i);
            ToWarehouseObject to = new ToWarehouseObject();
            to.setOrder(order);
            WarehouseObject warehouse = WarehouseService.getByName(order.getEndPos());
            ArrayList<WarehouseUnit> unit = WarehouseUtil.StringToArray(warehouse.getUnits());
            to.setUnits(unit);
            toes.add(to);
        }
        return toes;
    }
}
