package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.PermissionObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.PermissionService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 工具包中，有关权限操作的工具类
 * @author 黄伟
 */
public class PermissionUtil {

    /**
     * 静态方法，设定权限相关信息，用于在显示页面时将权限相关的权限变量传入JSP
     * @param mv ModelAndView
     * @param request 请求类
     */
    public static void setPermission(ModelAndView mv, HttpServletRequest request){
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        PermissionObject p = PermissionService.getPermission(u.getId());
        mv.addObject("permission",p);
    }
}
