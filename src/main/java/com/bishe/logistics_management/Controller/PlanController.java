package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.CarObject;
import com.bishe.logistics_management.database.dataObject.CompanyObject;
import com.bishe.logistics_management.database.dataObject.OrderObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.CarService;
import com.bishe.logistics_management.database.service.CompanyService;
import com.bishe.logistics_management.database.service.OrderService;
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

    @RequestMapping("/addcarcheck")
    public ModelAndView addCarCheck(HttpServletRequest request,
                                    @RequestParam("driver") String driver,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("brand") String brand,
                                    @RequestParam("type") String type,
                                    @RequestParam("length") int length,
                                    @RequestParam("size") int size,
                                    @RequestParam("times") String times,
                                    @RequestParam("tags") String tags,
                                    @RequestParam("number") String number){
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
            CarService.insertCar(carObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

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
                                      @RequestParam("tags") String tags){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/addorder");//跳转到订单列表
            OrderObject orderObject = new OrderObject();
            orderObject.setCompany(company);
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
            OrderService.insertOrder(orderObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
