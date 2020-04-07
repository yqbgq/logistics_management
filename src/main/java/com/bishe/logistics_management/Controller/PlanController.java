package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.*;
import com.bishe.logistics_management.database.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 营销页面拦截器
 * @author 黄伟
 */
@Controller
public class PlanController {
    /**
     * 增加货主公司的页面
     * @param request 请求类
     * @return 返回MV
     */
    @RequestMapping("/addcompany")
    public ModelAndView addcompany(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addcompany");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 审核提交公司信息并且插入数据库
     * @param request 请求类
     * @param name 表单公司名称
     * @param person 表单联系人
     * @param phone 表单电话
     * @param email 表单邮箱
     * @param address 表单联系地址
     * @param description 表单公司描述
     * @return 返回重定向MV
     */
    @RequestMapping("/addcompanycheck")
    public ModelAndView addcompanycheck(HttpServletRequest request,
                                        @RequestParam("name") String name,
                                        @RequestParam("person") String person,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("email") String email,
                                        @RequestParam("address") String address,
                                        @RequestParam("description") String description){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName(("redirect:/addcompany"));
            UsersObject u = UserUtil.getUser(request);
            CompanyObject companyObject = new CompanyObject();
            companyObject.setUserid(u.getId());
            companyObject.setName(name);
            companyObject.setAddress(address);
            companyObject.setDescription(description);
            companyObject.setEmail(email);
            companyObject.setPerson(person);
            companyObject.setPhone(phone);
            CompanyService.insertCompany(companyObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }


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
            carObject.setCurrent(current);
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
     */
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

    //todo 新增订单从仓库时候，需要增加下拉列表
    //todo 关联上订单和仓库信息
    /**
     * 添加订单，并且插入数据库
     * @param request 请求类
     * @return 返回MV重定向
     */
    @RequestMapping("/addorder")
    public ModelAndView addOrder(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addorder");
            ArrayList<CompanyObject> companies = CompanyService.getAllCompany();
            mv.addObject("companies",companies);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 处理添加订单页面提交的信息，插入数据库
     * @param request 请求类
     * @param company 公司
     * @param start 出发地点
     * @param end 目的地点
     * @param type 货物类别
     * @param volume 货物体积
     * @param weight 货物重量
     * @param endtime 订单截止时间
     * @param method 计价方法
     * @param price 单位价格
     * @param tags 额外标签信息
     * @return 返回MV重定向
     */
    @RequestMapping("/addordercheck")
    public ModelAndView addOrderCheck(HttpServletRequest request,
                                      @RequestParam("company") String company,
                                      @RequestParam("start") String start,
                                      @RequestParam("end") String end,
                                      @RequestParam("type") String type,
                                      @RequestParam("volume") int volume,
                                      @RequestParam("weight") int weight,
                                      @RequestParam("endtime") String endtime,
                                      @RequestParam("method") int method,
                                      @RequestParam("price") int price,
                                      @RequestParam("tags") String tags,
                                      @RequestParam("fromware") int fromware,
                                      @RequestParam("toware") int toware,
                                      @RequestParam("otherfee") int otherfee){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/addorder");//跳转到订单列表
            OrderObject orderObject = new OrderObject();
            if(fromware==1){
                orderObject.setFromware(0);
            }else{
                orderObject.setFromware(1);
            }
            if(toware==1){
                orderObject.setToware(0);
            }else{
                orderObject.setToware(1);
            }
            orderObject.setOtherfee(otherfee);
            orderObject.setCompany(company);
            start = start.replaceAll(","," ");
            end = end.replaceAll(","," ");
            orderObject.setStartPos(start);
            orderObject.setEndPos(end);
            orderObject.setType(type);
            orderObject.setVolume(volume);
            orderObject.setWeight(weight);
            orderObject.setEndDate(endtime);
            orderObject.setMethod(method);
            orderObject.setPrice(price);
            orderObject.setTags(tags);
            orderObject.setState(0);//状态为0表示还没有结束该订单
            orderObject.setChecked(0);//0表示该订单还没有被确认
            orderObject.setPlanuser(Integer.valueOf(CookieUtil.getValue(request,"id")));
            OrderService.insertOrder(orderObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 订单列表
     * @param request 请求类
     * @return 返回MV重定向
     */
    @RequestMapping("orderlist")
    public ModelAndView orderList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("orderlist");
            ArrayList<OrderObject> orders = OrderService.getAllOrder();
            mv.addObject("orders",orders);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 确认订单信息，审核
     * @param request 请求类
     * @param id 订单ID
     * @return 返回MV
     */
    @RequestMapping("ordercheck/{id}")
    public ModelAndView orderCheck(HttpServletRequest request,@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("ordercheck");
            OrderObject orderObject = OrderService.getOrderById(id);
            mv.addObject("order",orderObject);
            if(orderObject.getMethod()==1){
                mv.addObject("method","按立方计数");
            }else{
                mv.addObject("method","按重量计数");
            }
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 检验订单审核的信息，并且插入数据库
     * @param request 请求类
     * @param id 订单ID
     * @param approve 是否请求通过
     * @return 返回MV
     */
    @RequestMapping("orderchecks")
    public ModelAndView orderchecks(HttpServletRequest request,
                                    @RequestParam("id") int id,
                                    @RequestParam("approve") String approve){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/orderlist");
            if(approve.equals("on")){
                OrderService.approveId(id);
            }
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
            if(orderObject==null){
                mv.setViewName("redirect:/orderlist");
                return mv;
            }
            ArrayList<CarObject> cars = CarService.getEmptyCar(orderObject.getStartPos(),orderObject.getEndDate());
            for(int i=0;i<cars.size();i++){
                if(cars.get(i).getSize() <= orderObject.getVolume())cars.get(i).setId(-1);
                if(cars.get(i).getAwaydate().equals("0000-00-00"))cars.get(i).setAwaydate("尚未安排");
            }
            mv.addObject("cars",cars);
            mv.addObject("order",orderObject);
            if(orderObject.getMethod()==1){
                mv.addObject("method","按立方计数");
            }else{
                mv.addObject("method","按重量计数");
            }
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
     * @param date 预定离港信息
     * @return 返回MV
     */
    @RequestMapping("associateorder/{orderid}/{carid}")
    public ModelAndView associateOrder(HttpServletRequest request,
                                       @PathVariable("orderid") int orderid,
                                       @PathVariable("carid") int carid,
                                       @RequestParam("dates") String date){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/orderlist");
            OrderService.manageId(orderid);
            CarObject car = CarService.getById(carid);
            OrderObject order = OrderService.getOrderById(orderid);
            CarService.subSize(carid,car.getSize()-order.getVolume());
            car.setAwaydate(date);
            CarService.updateAway(car);
            ManagementObject managementObject = new ManagementObject();
            managementObject.setAway(date);
            managementObject.setCarid(carid);
            managementObject.setOrderid(orderid);
            managementObject.setManageuser(UserUtil.getUser(request).getName());
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
     * 显示营销部中在途订单的页面，这里还可以通往展示详细页面
     * @param request 请求类
     * @return 返回MV
     */
    //todo 订单列表页面要细化
    @RequestMapping("onroad")
    public ModelAndView onRoad(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("onroad");
            ArrayList<OrderObject> orders = OrderService.getAllOnRoad();
            mv.addObject("orders",orders);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 订单详细信息的映射
     * @param request 请求类
     * @param id 订单ID
     * @return 返回MV
     */
    @RequestMapping("orderdetail/{id}")
    public ModelAndView OrderDetail(HttpServletRequest request,
                                    @PathVariable("id") int id){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("orderdetail");
            OrderObject orderObject = OrderService.getOrderById(id);
            mv.addObject("order",orderObject);
            if(orderObject.getMethod()==1)mv.addObject("method","按照立方");
            else mv.addObject("method","按照重量");
            if(orderObject.getChecked()==0)mv.addObject("checked","暂未审核");
            else mv.addObject("checked","审核通过");
            ManagementObject managementObject = ManagementService.getByOrderId(id);
            mv.addObject("management",managementObject);
            CarObject carObject = CarService.getById(managementObject.getCarid());
            mv.addObject("car",carObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
