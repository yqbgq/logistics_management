package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.PermissionUtil;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 该控制类用于拦截有关于审核列表的请求
 * @author 黄伟
 */
@Controller
public class ApproveListController {
    /**
     * 该方法拦截approvelist 页面的请求 ，该页面用于显示待审核用户列表
     * @param request 请求变量
     * @return 返回重定向位置
     */
    @RequestMapping("/approvelist")
    public ModelAndView approveList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            PermissionUtil.setPermission(mv,request);
            ArrayList<UsersObject> approveList = UserService.findAllApprovement();
            mv.addObject("list",approveList);
            mv.setViewName("approvelist");
            return mv;
        }
        else {
            mv.setViewName("redirect:/log");
            return mv;
        }
    }
}
