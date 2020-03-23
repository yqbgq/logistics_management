package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.LogRecordService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * LogRecord数据表的工具类
 * @author 黄伟
 */
public class LogRecordUtil {
    /**
     * 更新当前登录时间
     * @param request 请求类
     */
    public static void updateLogTime(HttpServletRequest request){
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        LogRecordService.updateTime(u.getId());
    }

    /**
     * 为MV添加lastTime对象
     * @param mv 模型和视图类
     * @param request 请求类
     */
    public static void addLastTime(ModelAndView mv,HttpServletRequest request){
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        mv.addObject("lastTime",LogRecordService.getLastTime(u.getId()));
    }
}
