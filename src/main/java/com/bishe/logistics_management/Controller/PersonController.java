package com.bishe.logistics_management.Controller;


import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.LogRecordUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 人员管理，显示个人信息以及修改页面
 * @author 黄伟
 */
@Controller
public class PersonController {

    /**
     * person页面，展示个人信息以及修改页面
     * @param request 请求类
     * @return 返回mv
     */
    @RequestMapping("/person")
    public ModelAndView person(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            mv.setViewName("person");
            LogRecordUtil.addLastTime(mv,request);//lastTime
            UserUtil.addUser(mv,request);//u
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    /**
     * 提交人员修改信息的审核以及插入数据库
     * @param request 请求类
     * @param name 表单姓名
     * @param phone 表单电话
     * @param email 表单邮箱
     * @param password 表单密码
     * @param addition 表单额外信息
     * @return 返回MV
     */
    @RequestMapping("/resubmit")
    public ModelAndView resubmit(HttpServletRequest request,
                                 @RequestParam("name") String name,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("email") String email,
                                 @RequestParam("pw1") String password,
                                 @RequestParam("addition") String addition){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            mv.setViewName("redirect:/person");
            UsersObject u = UserUtil.getUser(request);
            u.setAddition(addition);
            u.setPassword(password);
            u.setEmail(email);
            u.setName(name);
            u.setPhone(phone);
            UserService.resubmit(u);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
