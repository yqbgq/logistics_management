package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.NoticeObject;
import com.bishe.logistics_management.database.dataObject.PermissionObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.NoticeService;
import com.bishe.logistics_management.database.service.PermissionService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 通知工具类
 * @author  黄伟
 */
public class NoticeUtil {

    /**
     * 为首页添加通知列表
     * @param mv MV
     * @param request 请求列表
     */
    public static void addNotice(ModelAndView mv, HttpServletRequest request){
        ArrayList<NoticeObject> result = new ArrayList<>();
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        PermissionObject p = PermissionService.getPermission(u.getId());
        if(p.getUsers()!=0)result.addAll(NoticeService.getNotice(1));
        if(p.getOrders()!=0)result.addAll(NoticeService.getNotice(2));
        if(p.getPlan()!=0)result.addAll(NoticeService.getNotice(3));
        if(p.getAffairs()!=0)result.addAll(NoticeService.getNotice(4));
        if(p.getWarehouse()!=0)result.addAll(NoticeService.getNotice(5));
        mv.addObject("notices",result);
    }
}
