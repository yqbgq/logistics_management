package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.CompanyObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PlanController {
    @RequestMapping("/addcompany")
    public ModelAndView addcompany(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName("addcompany");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

    @RequestMapping("/addcompanycheck")
    public ModelAndView addcompanycheck(HttpServletRequest request,
                                        @RequestParam("name") String name,
                                        @RequestParam("person") String person,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("email") String email,
                                        @RequestParam("address") String address,
                                        @RequestParam("description") String description){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)){
            mv.setViewName(("redirect:/addcompany"));
            UsersObject u = UserUtil.getUser(request);
            CompanyObject companyObject = new CompanyObject();
            companyObject.setUserid(u.getId());
            companyObject.setName(name);
            companyObject.setAddress(address);
            companyObject.setDescription(description);
            companyObject.setEmail(email);
            companyObject.setPerson(person);
            companyObject.setPhone(phone);
            CompanyService.insertCompany(companyObject);
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }
}
