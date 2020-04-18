package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.*;
import com.bishe.logistics_management.database.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 该控制类用于拦截首页请求
 * @author 黄伟
 */
@Controller
public class IndexController {

    /**
     * 该控制类用于拦截首页/index的请求，检查cookie
     * 如果已经登录，则允许进入首页
     * 如果还没有登录，则重定向到登录页面
     * @param request 请求变量
     * @return 返回mv
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            TodoListUtil.addTodoList(mv,request);
            MessageUtil.addMessage(mv,request);
            NoticeUtil.addNotice(mv,request);

            OrderUtil.indexAddOrderNum(mv);
            WarehouseUtil.indexAddWarehouseInformation(mv);
            CarUtil.indexAddCarInformation(mv);
            PayUtil.indexAddPayInformation(mv);
            mv.addObject("companies", CompanyService.getNum());
            OrderUtil.indexAddSevenDayOrderNum(mv);
            OrderUtil.indexAddFromCompanyNum(mv);
            PayUtil.indexAddPaySevenDayNum(mv);
            PayUtil.indexAddPaySevenDayBillNum(mv);
            mv.setViewName("index");
        }
        else {
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
