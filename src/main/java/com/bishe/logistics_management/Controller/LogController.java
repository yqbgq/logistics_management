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


    /**
     * 默认的注册页面
     * @return 默认的注册页面
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * 这个好像我也忘了什么用处来着，但是又懒得删掉来测试是不是有影响了
     * @return 重定向到注册页面
     */
    @RequestMapping(value = "/registerin",method = RequestMethod.POST)
    public String registerIn(){
        return "register";
    }

    /**
     * 用于处理表单提交的注册信息，处理数据并且插入数据库
     * @param username 提交的用户名
     * @param phone 提交的电话号码
     * @param email 提交的邮箱
     * @param department 提交的部门信息
     * @param job 提交的岗位信息
     * @param pw1 提交的密码，在表单中pw1和pw2中进行了密码一致性确认，这里只需要提取pw1即可，因为都是一样的
     * @param addition 提交的附加信息，可以加快审核之类的
     * @return 返回重定向到登录页面
     */
    @RequestMapping(value = "/registerdata",method = RequestMethod.POST)
    public String registerData(@RequestParam("name") String username,
                               @RequestParam("phone") String phone,
                               @RequestParam("email") String email,
                               @RequestParam("department") String department,
                               @RequestParam("job") String job,
                               @RequestParam("pw1") String pw1,
                               @RequestParam("addition") String addition,
                               @RequestParam("sex") String sex
    ){

        UsersObject u = new UsersObject();
        switch(department){
            case "1": u.setDepartment("人事部");break;
            case "2": u.setDepartment("营销部");break;
            case "3": u.setDepartment("计划部");break;
            case "4": u.setDepartment("财务部");break;
            case "5": u.setDepartment("仓管部");break;
        }
        u.setEmail(email);
        u.setJob(job);
        u.setName(username);
        u.setPassword(pw1);
        u.setPhone(phone);
        u.setAvailable(0);
        u.setAddition(addition);
        u.setSex(sex);
        UserService.createUser(u);
        return "redirect:/log";
    }
}
