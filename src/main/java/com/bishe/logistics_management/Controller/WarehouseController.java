package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.ToWarehouseUtil;
import com.bishe.logistics_management.Utils.WarehouseUtil;
import com.bishe.logistics_management.database.dataObject.*;
import com.bishe.logistics_management.database.service.CarService;
import com.bishe.logistics_management.database.service.ManagementService;
import com.bishe.logistics_management.database.service.OrderService;
import com.bishe.logistics_management.database.service.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 仓库页面拦截器
 * @author 黄伟
 */
@Controller
public class WarehouseController {

    /**
     * 新增加仓库的页面
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("addwarehouse")
    public ModelAndView addWarehouse(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addwarehouse");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 添加仓库页面的审核
     * @param request 请求类
     * @param name 仓库名
     * @param pos 仓库位置
     * @return 返回MV
     */
    @RequestMapping("addwarehousecheck")
    public ModelAndView addWarehouseCheck(HttpServletRequest request,
                                         @RequestParam("name") String name,
                                         @RequestParam("pos") String pos){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/addwarehouseunit");
            WarehouseObject warehouseObject = new WarehouseObject();
            warehouseObject.setName(name);
            warehouseObject.setPos(pos);
            warehouseObject.setNum(0);
            warehouseObject.setUnits("");
            WarehouseService.insertWarehouse(warehouseObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 添加仓库库位页面的拦截器
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("addwarehouseunit")
    public ModelAndView addWarehouseUnit(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addwarehouseunit");
            ArrayList<WarehouseObject> warehouses = WarehouseService.getAllWarehouse();
            mv.addObject("warehouses",warehouses);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 审核添加仓库库位的信息并且插入数据库
     * @param request 请求类
     * @param warehouseID 仓库ID
     * @param name 库位名字
     * @param size 仓库容量
     * @return 返回MV
     */
    @RequestMapping("addwarehouseunitcheck")
    public ModelAndView addWarehouseUnitCheck(HttpServletRequest request,
                                              @RequestParam("warehouse") int warehouseID,
                                              @RequestParam("name") String name,
                                              @RequestParam("size") int size){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/addwarehouseunit");
            WarehouseObject warehouseObject = WarehouseService.getById(warehouseID);
            WarehouseUnit unit = new WarehouseUnit();
            unit.setId(warehouseObject.getNum()+1);
            unit.setName(name);
            unit.setSize(size);
            unit.setCapacity(size);
            unit.setBelong(warehouseObject.getName());
            unit.setBelongPos(warehouseObject.getPos());
            String s = WarehouseUtil.UnitToString(unit);
            warehouseObject.setUnits(warehouseObject.getUnits()+s);
            warehouseObject.setNum(warehouseObject.getNum()+1);
            WarehouseService.updateWarehouse(warehouseObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 仓库列表拦截器
     * @param request 请求类
     * @return MV
     */
    @RequestMapping("warehouselist")
    public ModelAndView WarehouseList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("warehouselist");
            ArrayList<WarehouseObject> warehouses = WarehouseService.getAllWarehouse();
            for(WarehouseObject o : warehouses){
                WarehouseUtil.ProcessInstance(o);
            }
            mv.addObject("warehouses",warehouses);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 仓库详细信息页面拦截器
     * @param request 请求类
     * @param id ID
     * @return MV
     */
    @RequestMapping("warehousedetail/{id}")
    public ModelAndView WarehouseDetail(HttpServletRequest request,
                                        @PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("warehousedetail");
            WarehouseObject warehouseObject = WarehouseService.getById(id);
            mv.addObject("warehouse",warehouseObject);
            mv.addObject("units",WarehouseUtil.StringToArray(warehouseObject.getUnits()));
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 到达仓库页面信息
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("towarehouse")
    public ModelAndView ToWarehouse(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("towarehouse");
            ArrayList<OrderObject> orders = OrderService.getToWarehouse();
            ArrayList<ToWarehouseObject> toes = ToWarehouseUtil.combine(orders);
            mv.addObject("toes",toes);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 将仓库在途订单入库审核拦截器
     * @param request 请求类
     * @param id 订单ID
     * @param unit 入库的库位ID
     * @return 返回MV
     */
    @RequestMapping("intowarehouse/{id}")
    public ModelAndView IntoWarehouse(HttpServletRequest request,
                                      @PathVariable("id") int id,
                                      @RequestParam("unit") int unit){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/towarehouse");
            ManagementService.completeOrder(id);//完成计划表
            ManagementObject managementObject = ManagementService.getByOrderId(id);
            ArrayList<ManagementObject> managementlist = ManagementService.getRunningCar(managementObject.getCarid());
            if(managementlist.size()==0){
                CarService.arriveTarget(managementObject.getCarid());
            }
            WarehouseUtil.subUnitSize(id,unit);
            OrderService.completeOrder(id);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

}
