package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.MessageObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.MessageService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 信息的工具类
 * @author  黄伟
 */
public class MessageUtil {
    /**
     * 为首页添加通知信息的工具类
     * @param mv MV
     * @param request 请求类
     */
    public static void addMessage(ModelAndView mv, HttpServletRequest request){
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        ArrayList<MessageObject> messages = MessageService.getMessage(u.getId());
        mv.addObject("messages",messages);
    }
}
