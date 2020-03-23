package com.bishe.logistics_management.Controller;


import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.MessageObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.MessageService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 和发送信息相关的拦截器
 * @author 黄伟
 */
@Controller
public class MessageController {

    /**
     * 发送信息页面相关的拦截器
     * @param request 请求类
     * @return 返回 ModelAndView 类
     */
    @RequestMapping("/send")
    public ModelAndView send(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            mv.setViewName("message");
            ArrayList<UsersObject> array = UserService.findAllUserExceptMe(UserUtil.getUser(request).getId());
            mv.addObject("array",array);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 对提交的信息进行审核
     * @param to 交由目的ID
     * @param content 交由的内容
     * @param request 请求类
     * @return 返回 ModelAndView 类
     */
    @RequestMapping(value = "/sendmessage",method = RequestMethod.POST)
    public ModelAndView sendMessage(@RequestParam("users") int to,
                                    @RequestParam("content") String content,
                                    HttpServletRequest request
                                    ){
        ModelAndView mv = new ModelAndView();
        UsersObject user = UserUtil.getUser(request);
        MessageObject message = new MessageObject();
        message.setFromer(user.getId());
        message.setToer(to);
        message.setMessage(content);
        MessageService.insertMessage(message);
        mv.setViewName("redirect:/index");
        return mv;
    }
}
