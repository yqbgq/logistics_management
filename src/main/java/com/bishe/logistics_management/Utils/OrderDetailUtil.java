package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.*;
import com.bishe.logistics_management.database.service.*;
import java.util.ArrayList;

/**
 * 处理订单详细信息的工具类，各种情况比较复杂
 * @author 黄伟
 */
public class OrderDetailUtil {

    /**
     * 总的处理类，考虑各种情况，进行处理并且向列表中填充各个订单详细类
     * @param orderObject 订单数据类
     * @return 订单详细类的数组列表
     */
    public static ArrayList<OrderDetailObject> generate(OrderObject orderObject){
        ArrayList<OrderDetailObject> array = new ArrayList<>();
        if(orderObject.getChecked()==0 && orderObject.getState()==0)array.add(OrderDetailUtil.generateOpen(orderObject));
        if(orderObject.getChecked()==1&&orderObject.getState()==0){
            array.add(OrderDetailUtil.generateOpen(orderObject));
            array.add(OrderDetailUtil.generateCheck(orderObject));
        }
        if(orderObject.getChecked()==1&&orderObject.getState()==1){
            array.add(OrderDetailUtil.generateOpen(orderObject));
            array.add(OrderDetailUtil.generateCheck(orderObject));
            array.add(OrderDetailUtil.generate1(orderObject));
            ManagementObject managementObject = ManagementService.getByOrderId(orderObject.getId());
            CarObject carObject = CarService.getById(managementObject.getCarid());
            if(carObject.getState()==1){
                array.add(OrderDetailUtil.generateStart(orderObject));
            }
        }
        if(orderObject.getChecked()==1&&orderObject.getState()==2){
            array.add(OrderDetailUtil.generateOpen(orderObject));
            array.add(OrderDetailUtil.generateCheck(orderObject));
            array.add(OrderDetailUtil.generate1(orderObject));
            array.add(OrderDetailUtil.generateStart(orderObject));
            array.add(OrderDetailUtil.generate2(orderObject));
        }
        if(orderObject.getChecked()==1&&orderObject.getState()==3){
            array.add(OrderDetailUtil.generateOpen(orderObject));
            array.add(OrderDetailUtil.generateCheck(orderObject));
            array.add(OrderDetailUtil.generate1(orderObject));
            ManagementObject managementObject = ManagementService.getByOrderId(orderObject.getId());
            CarObject carObject = CarService.getById(managementObject.getCarid());
            if(carObject.getState()==1){
                array.add(OrderDetailUtil.generateStart(orderObject));
            }
            array.add(OrderDetailUtil.generate2(orderObject));
            array.add(OrderDetailUtil.generate3(orderObject));
        }
        return array;
    }

    /**
     * 处理情形，当订单仅仅只是刚刚下达时
     * @param orderObject 订单数据类
     * @return 处理好之后的订单详细类
     */
    private static OrderDetailObject generateOpen(OrderObject orderObject){
        StringBuilder sb = new StringBuilder();
        String title = "";
        OrderDetailObject orderDetailObject = new OrderDetailObject();
        UsersObject usersObject = UserService.getUser(orderObject.getPlanuser());
        title += "订单于 " + usersObject.getName() + " 下达";
        orderDetailObject.setTitle(title);
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单由业务员 ");sb.append(usersObject.getName());sb.append(" 创建</br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单起点： ");sb.append(orderObject.getStartPos());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单终点： ");sb.append(orderObject.getEndPos());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单截止： ");sb.append(orderObject.getEndDate());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单尚未得到批复审核");sb.append(" </br>");
        orderDetailObject.setContent(sb.toString());
        return orderDetailObject;
    }

    /**
     * 订单审核通过之后，填充订单详细类
     * @param orderObject 订单数据类
     * @return 订单详情类
     */
    private static OrderDetailObject generateCheck(OrderObject orderObject){
        OrderDetailObject orderDetailObject = new OrderDetailObject();
        StringBuilder sb = new StringBuilder();
        String title = "";
        title += "订单已被主管审核通过";
        orderDetailObject.setTitle(title);
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单等待安排运力");sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("已经转入运力管理部门");sb.append(" </br>");
        orderDetailObject.setContent(sb.toString());
        return orderDetailObject;
    }

    /**
     * 生成订单详情类
     * @param orderObject 订单类
     * @return 返回订单详细类
     */
    private static OrderDetailObject generate1(OrderObject orderObject){
        OrderDetailObject orderDetailObject = new OrderDetailObject();
        ManagementObject managementObject = ManagementService.getByOrderId(orderObject.getId());
        CarObject carObject = CarService.getById(managementObject.getCarid());
        String title = "";
        StringBuilder sb = new StringBuilder();
        title += "订单经由 " + managementObject.getManageuser() + " 安排运力";
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("承运车辆： ");sb.append(carObject.getNumber());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("司机姓名： ");sb.append(carObject.getDriver());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("联系电话： ");sb.append(carObject.getPhone());sb.append(" </br>");
        orderDetailObject.setTitle(title);
        orderDetailObject.setContent(sb.toString());
        return orderDetailObject;
    }


    /**
     * 承运车辆已经出发之后，生成订单详情类
     * @param orderObject 订单类
     * @return 返回订单详细类
     */
    private static OrderDetailObject generateStart(OrderObject orderObject){
        OrderDetailObject orderDetailObject = new OrderDetailObject();
        ManagementObject managementObject = ManagementService.getByOrderId(orderObject.getId());
        CarObject carObject = CarService.getById(managementObject.getCarid());
        String title = "";
        StringBuilder sb = new StringBuilder();
        title += "订单已经发出";
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("承运车辆已经由运力部门安排发出 ");sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("发出日期： ");sb.append(carObject.getAwaydate());sb.append(" </br>");
        orderDetailObject.setTitle(title);
        orderDetailObject.setContent(sb.toString());
        return orderDetailObject;
    }


    /**
     * 生成订单详情类
     * @param orderObject 订单类
     * @return 返回订单详细类
     */
    private static OrderDetailObject generate2(OrderObject orderObject){
        OrderDetailObject orderDetailObject = new OrderDetailObject();
        ManagementObject managementObject = ManagementService.getByOrderId(orderObject.getId());
        String title = "订单已经送达";
        StringBuilder sb = new StringBuilder();
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单已于： ");sb.append(managementObject.getEndtime());sb.append("送达");sb.append(" </br>");
        orderDetailObject.setTitle(title);
        orderDetailObject.setContent(sb.toString());
        return orderDetailObject;
    }


    /**
     * 生成订单详情类
     * @param orderObject 订单类
     * @return 返回订单详细类
     */
    private static OrderDetailObject generate3(OrderObject orderObject){
        OrderDetailObject orderDetailObject = new OrderDetailObject();
        PayRecordObject payRecordObject = PayRecordService.getPayRecordByOrderId(orderObject.getId());
        PayMethodObject payMethodObject = PayMethodService.getById(payRecordObject.getPayId());
        String title = "订单已经收款";
        StringBuilder sb = new StringBuilder();
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("订单总价： ");sb.append(payRecordObject.getMoney());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("经手人员： ");sb.append(payRecordObject.getUser());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("支付方式： ");sb.append(payMethodObject.getMethod());sb.append(" </br>");
        sb.append("<i class=\"layui-icon layui-icon-template-1\" style=\"font-size: 18px;\"></i>&nbsp;");
        sb.append("收款日期： ");sb.append(payRecordObject.getDate());sb.append(" </br>");
        orderDetailObject.setTitle(title);
        orderDetailObject.setContent(sb.toString());
        return orderDetailObject;
    }

}
