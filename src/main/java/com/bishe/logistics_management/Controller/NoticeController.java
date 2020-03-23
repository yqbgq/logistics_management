package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.database.dataObject.NoticeObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.NoticeService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


/**
 * 通知页面以及提交审核的拦截器
 * @author 黄伟
 */

@Controller
public class NoticeController {
    /**
     * 处理通知页面
     * @param request 请求类
     * @return 返回mv
     */
    @RequestMapping("/announce")
    public ModelAndView announce(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("announce");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 处理提交通知的方法
     * @param request 请求类
     * @param department 提交的部门ID
     * @param addition 提交的通知内容
     * @param time 提交的截止时间
     * @return 返回mv
     */
    @RequestMapping("/submitannounce")
    public ModelAndView announce(HttpServletRequest request,
                                 @RequestParam("department") int department,
                                 @RequestParam("addition") String addition,
                                 @RequestParam("date") String time){
        ModelAndView mv = new ModelAndView();
        String username = CookieUtil.getValue(request,"username");
        String password = CookieUtil.getValue(request,"password");
        UsersObject u = UserService.getUserByAll(username,password);
        NoticeObject noticeObject = new NoticeObject();
        noticeObject.setContent(addition);
        noticeObject.setDepartment(department);
        noticeObject.setFromid(u.getId());
        noticeObject.setTime(time);
        NoticeService.insertNotice(noticeObject);
        mv.setViewName("redirect:/announce");
        return mv;
    }
}
