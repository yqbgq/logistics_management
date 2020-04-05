package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.LogRecordUtil;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该拦截器用于处理登录页面的访问请求
 * @author 黄伟
 */
@Controller
public class LogController {

    /**
     * 如果没有任何的参数，默认访问该页面
     * @return log页面JSP
     */
    @RequestMapping("/")
    public String log1(){
        return "log";
    }

    @RequestMapping("/log")
    public String log(){
        return "log";
    }
    /**
     * 用于处理登录表单提交的数据 POST ,在Cookie中添加了用户的姓名、密码以及ID
     * @param username 由表单提交的用户名
     * @param password 由表单提交的密码
     * @param response 响应变量
     * @return 返回重定向
     */
    @RequestMapping(value = "/logcheck",method = RequestMethod.POST)
    public ModelAndView log2(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       HttpServletResponse response, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(UserService.check(username,password) >= 1){
            CookieUtil.set(response,"username",username);
            CookieUtil.set(response,"password",password);
            UsersObject u = UserService.getUserByAll(username,password);
            CookieUtil.set(response,"id",String.valueOf(u.getId()));
            mv.setViewName("redirect:/tempredirect");
            return mv;
        }else{
            mv.setViewName("redirect:/log");
            return mv;
        }
    }

    @RequestMapping(value="/tempredirect")
    public ModelAndView tempre(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("redirect:/index");
            LogRecordUtil.updateLogTime(request);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 登出处理，当登出时删除所有的cookie
     * @param response 响应变量
     * @param request 请求变量
     * @return 返回重定向
     */
    @RequestMapping(value="/logout")
    public String logout(HttpServletResponse response, HttpServletRequest request){
        CookieUtil.destroy(request,response);
        return "redirect:/log";
    }
}
