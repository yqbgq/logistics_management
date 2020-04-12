package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.ManagementUtil;
import com.bishe.logistics_management.database.dataObject.CarObject;
import com.bishe.logistics_management.database.dataObject.ManagementObject;
import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.CarService;
import com.bishe.logistics_management.database.service.ManagementService;
import com.bishe.logistics_management.database.service.OrderService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 运力管理页面的拦截器
 * @author 黄伟
 */
@Controller
public class PowerController {
    /**
     * 页面拦截器，添加车辆信息
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("/addcar")
    public ModelAndView addCar(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addcar");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 处理addcar提交的信息，插入数据库
     * @param request 请求类
     * @param driver 司机信息
     * @param phone 电话号码
     * @param brand 车辆品牌
     * @param type 车辆类型
     * @param length 车辆长度
     * @param size 车辆的立方
     * @param times 车辆出厂时间
     * @param tags 车辆额外标签信息
     * @param number 车辆牌照
     * @return 返回MV
     */
    @RequestMapping("/addcarcheck")
    public ModelAndView addCarCheck(HttpServletRequest request,
                                    @RequestParam("driver") String driver,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("brand") String brand,
                                    @RequestParam("type") String type,
                                    @RequestParam("length") float length,
                                    @RequestParam("size") float size,
                                    @RequestParam("times") String times,
                                    @RequestParam("tags") String tags,
                                    @RequestParam("number") String number,
                                    @RequestParam("current") String current){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/carlist");
            CarObject carObject = new CarObject();
            carObject.setBrand(brand);
            carObject.setCapacity(size);
            carObject.setSize(size);
            carObject.setDriver(driver);
            carObject.setLength(length);
            carObject.setPhone(phone);
            carObject.setType(type);
            carObject.setTimes(times);
            carObject.setTags(tags);
            carObject.setNumber(number);
            carObject.setCurrents(current);
            carObject.setState(0);
            carObject.setAwaydate("0000-00-00");
            carObject.setTarget("");
            CarService.insertCar(carObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }





    /**
     * 修改车辆信息，并且插入数据库
     * @param request 请求类
     * @param driver 司机信息
     * @param phone 电话号码
     * @param tags 标签信息
     * @param number 牌照
     * @param id 车辆ID
     * @return 返回MV重定向
    @RequestMapping("/replacecar")
    public ModelAndView addCarCheck(HttpServletRequest request,
                                    @RequestParam("driver") String driver,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("tags") String tags,
                                    @RequestParam("number") String number,
                                    @RequestParam("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/carlist");
            CarObject carObject = new CarObject();
            carObject.setId(id);
            carObject.setDriver(driver);
            carObject.setPhone(phone);
            carObject.setTags(tags);
            carObject.setNumber(number);
            CarService.replaceCar(carObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
    **/


    /**
     * 拦截器，显示车辆的列表
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("/carlist")
    public ModelAndView carlist(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("carlist");
            ArrayList<CarObject> carList = CarService.getAllCars();
            mv.addObject("carList",carList);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }


    /**
     * 根据车辆ID，返回车辆的具体信息
     * @param request 请求类
     * @param id 车辆ID
     * @return 返回重定向ID
     */
    @RequestMapping("/cardetail/{id}")
    public ModelAndView cardetail(HttpServletRequest request,@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("cardetail");
            CarObject car = CarService.getById(id);
            mv.addObject("car",car);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }


    /**
     * 展示订单信息并且列出可以安排的车辆表，车辆表中修改部分信息
     * @param request 请求类
     * @param id 订单ID
     * @return 返回MV
     */
    @RequestMapping("manageplan/{id}")
    public ModelAndView managePlan(HttpServletRequest request,@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("manageplan");
            OrderObject orderObject = OrderService.getOrderById(id);
            if(orderObject==null){//防止读取错误的订单
                mv.setViewName("redirect:/orderlist");
                return mv;
            }
            ArrayList<CarObject> cars = CarService.getEmptyCar();
            for(int i=0;i<cars.size();i++)cars.get(i).setTags(ManagementUtil.combineCarAndManagement(cars.get(i).getId()));
            mv.addObject("cars",cars);
            mv.addObject("order",orderObject);
            if(orderObject.getMethod()==1)mv.addObject("method","按立方计数");
            else mv.addObject("method","按重量计数");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 关联订单和运力，建立Management类并插入数据库，修改订单状态state，修改车辆的离港信息以及车辆的剩余载货能力
     * @param request 请求类
     * @param orderid 订单ID
     * @param carid 车辆ID
     * @return 返回MV
     */
    @RequestMapping("associateorder/{orderid}/{carid}")
    public ModelAndView associateOrder(HttpServletRequest request,
                                       @PathVariable("orderid") int orderid,
                                       @PathVariable("carid") int carid){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/orderlist");
            OrderService.manageId(orderid);//修改订单的状态state为1
            CarObject car = CarService.getById(carid);
            OrderObject order = OrderService.getOrderById(orderid);
            CarService.subSize(carid,car.getSize()-order.getVolume());

            UsersObject user = UserService.getUser(Integer.valueOf(CookieUtil.getValue(request,"id")));
            ManagementObject managementObject = new ManagementObject();
            managementObject.setCarid(carid);
            managementObject.setOrderid(orderid);
            managementObject.setManageuser(user.getName());
            managementObject.setPlanuser(UserService.getUser(order.getPlanuser()).getName());
            ManagementService.insertManagement(managementObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 展示待安排运力的订单的列表
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("managelist")
    public ModelAndView manageList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("managelist");
            ArrayList<OrderObject> orders = OrderService.getNeedManage();
            mv.addObject("orders",orders);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 显示在途的但不是去仓库的订单
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("onroadtoother")
    public ModelAndView onRoadToOther(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("onroadtoother");
            ArrayList<OrderObject> o = OrderService.getToOther();
            ArrayList<OrderObject> orders = new ArrayList<>();
            for(int i=0;i<o.size();i++){
                ManagementObject m = ManagementService.getByOrderId(o.get(i).getId());
                CarObject c = CarService.getById(m.getCarid());
                if(c.getState()==1)orders.add(o.get(i));
            }
            mv.addObject("orders",orders);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 将在途的所有不是前往仓库的订单入库
     * @param request 请求类
     * @param id 订单ID
     * @return 返回MV
     */
    @RequestMapping("intoother/{id}")
    public ModelAndView intoOther(HttpServletRequest request,
                                  @PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/onroadtoother");
            ManagementService.completeOrder(id);//完成计划表
            ManagementObject managementObject = ManagementService.getByOrderId(id);
            ArrayList<ManagementObject> managementlist = ManagementService.getRunningCar(managementObject.getCarid());
            CarObject carObject = CarService.getById(managementObject.getCarid());
            if(managementlist.size()==0){
                OrderObject order = OrderService.getOrderById(managementObject.getOrderid());
                carObject.setCurrents(order.getEndPos());
                CarService.arriveTarget(carObject);
            }
            OrderService.completeOrder(id);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 将车辆发出，显示相关的信息
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("startcar")
    public ModelAndView StartCar(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("startcar");
            ArrayList<CarObject> cars = CarService.getUsed();
            for(int i=0;i<cars.size();i++){
                cars.get(i).setTags(ManagementUtil.combineCarAndManagement(cars.get(i).getId()));
            }
            mv.addObject("cars",cars);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 发出订单，确认并且插入数据库
     * @param request 请求类
     * @param id 订单ID
     * @return 返回MV
     */
    @RequestMapping("startcarcheck/{id}")
    public ModelAndView StartCarCheck(HttpServletRequest request,
                                      @PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/startcar");
            CarService.start(id);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
