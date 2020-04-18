package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.service.OrderService;
import org.springframework.web.servlet.ModelAndView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 订单数据类的工具类
 * @author 黄伟
 */
public class OrderUtil {

    /**
     * 获取还没有获得审核的订单
     * @return 未获得审核的订单
     */
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

    /**
     * 获得还没有得到安排的订单
     * @return 未安排订单
     */
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

    /**
     * 获取已经安排了的订单
     * @return 已安排订单
     */
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

    /**
     * 获取已经到达订单
     * @return 已经到达订单
     */
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

    /**
     * 获取已经支付订单的列表
     * @return 已支付订单列表
     */
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

    /**
     * 在首页添加订单总数信息
     * @param mv MV
     */
    public static void indexAddOrderNum(ModelAndView mv){
        int totalOrder = OrderService.getTotalNum();
        mv.addObject("totalOrder",totalOrder);
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String tempTime = "";
        tempTime += year + "-0" + month + "%";
        int monthNum = OrderService.getMonthNum(tempTime);
        mv.addObject("monthNum",monthNum);
    }

    /**
     * 在首页添加最近七天订单总数
     * @param mv MV
     */
    public static void indexAddSevenDayOrderNum(ModelAndView mv){
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> sevenDayOrderNum = new ArrayList<>();
        ArrayList<String> sevenDay = new ArrayList<>();
        for(int i=1;i<=7;i++){
            calendar.add(Calendar.DATE, -1); //得到前一天
            Date date = calendar.getTime();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            sevenDay.add(df.format(date));
            sevenDayOrderNum.add(OrderService.getDayNum(df.format(date)));
        }
        mv.addObject("sevenDayOrderNum",sevenDayOrderNum);
        mv.addObject("sevenDay",sevenDay);
    }

    /**
     * 在首页添加所有货源公司相关联订单的数目
     * @param mv MV
     */
    public static void indexAddFromCompanyNum(ModelAndView mv){
        ArrayList<String> companies = OrderService.getAllCompanies();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<companies.size();i++){
            sb.append("{value:");
            sb.append(OrderService.getCertainCompanyNum(companies.get(i)));
            sb.append(", name:'");
            sb.append(companies.get(i));
            sb.append("'}");
            if(i != companies.size()-1)sb.append(",");
        }
        mv.addObject("pieData",sb.toString());
    }
}
