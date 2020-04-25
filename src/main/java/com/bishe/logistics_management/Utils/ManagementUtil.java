package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.ManagementObject;
import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.service.ManagementService;
import com.bishe.logistics_management.database.service.OrderService;
import java.util.ArrayList;

/**
 * 计划类的工具类
 * @author 黄伟
 */
public class ManagementUtil {

    /**
     * 绑定车辆和计划信息，在计划页面进行显示
     * @param carId 车辆ID
     * @return 返回绑定之后的字符串
     */
    public static String combineCarAndManagement(int carId){
        StringBuilder sb = new StringBuilder();
        ArrayList<ManagementObject> managements = ManagementService.getUncomplete();
        int count = 1;
        for(int i=0;i<managements.size();i++){
            if(managements.get(i).getCarid()==carId) {
                OrderObject order = OrderService.getOrderById(managements.get(i).getOrderid());
                sb.append(count ++);
                sb.append("-到达");
                sb.append(order.getEndPos());
                sb.append("-");
                sb.append("截止日期:");
                sb.append(order.getEndDate());
                sb.append("<br/>");
            }
        }
        return sb.toString();
    }
}
