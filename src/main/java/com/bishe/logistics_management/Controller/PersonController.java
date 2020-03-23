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

@Controller
public class PersonController {

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
