package com.bishe.logistics_management.database.dataObject;

import java.util.ArrayList;

/**
 * 到达仓库的数据类，将订单信息以及订单即将到达的仓库库位信息结合在一起
 * @author  黄伟
 */
public class ToWarehouseObject {
    private OrderObject order;

    private ArrayList<WarehouseUnit> units;

    public OrderObject getOrder() {
        return order;
    }

    public void setOrder(OrderObject order) {
        this.order = order;
    }

    public ArrayList<WarehouseUnit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<WarehouseUnit> units) {
        this.units = units;
    }
}
