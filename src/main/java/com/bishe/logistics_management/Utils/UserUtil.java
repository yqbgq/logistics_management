package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    /**
     * 为ModelAndView添加User类别
     * @param mv ModelAndView
     * @param request 请求类
     */
    public static void addUser(ModelAndView mv, HttpServletRequest request){
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        mv.addObject("user",u);
    }

    /**
     * 根据Cookie中的用户名和密码查找用户类
     * @param request 请求类
     * @return 返回用户类
     */
    public static UsersObject getUser(HttpServletRequest request){
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        return u;
    }

}
