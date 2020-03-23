package com.bishe.logistics_management.Controller;

import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.PermissionUtil;
import com.bishe.logistics_management.database.dataObject.PermissionObject;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import com.bishe.logistics_management.database.service.PermissionService;
import com.bishe.logistics_management.database.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *该控制类用于拦截有关用户审核页面的请求
 * @author 黄伟
 */
//todo 需要注意，还需要添加权限审核
@Controller
public class ApproveController {

    /**
     * 该方法拦截approve页面，显示了审核用户的表单
     * @param request  请求变量
     * @return 当未登录时，重定向到登录界面
     */
    @RequestMapping("/approve")
    public ModelAndView approve(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            PermissionUtil.setPermission(mv,request);
            mv.setViewName("approve");
            return mv;
        }
        else{
            mv.setViewName("redirect:/log");
            return mv;
        }

    }

    /**
     * 对表单提交之后的处理方法 POST
     * @param approve 表示是否支持通过审核
     * @param user 表示用户名
     * @param orders 表示是否拥有订单审核的权限
     * @param warehouse 表示是否拥有仓库管理的权限
     * @param plan 表示是否需要有计划管理的权限
     * @param affairs 表示是否需要有财务管理的权限
     * @param request 表示请求变量
     * @return 表示重定向位置
     */
    @RequestMapping(value = "/approveuser",method = RequestMethod.POST)
    public ModelAndView approveUser(@RequestParam("approve") String approve,
                              @RequestParam("id") int id,
                              @RequestParam("users") int user,
                              @RequestParam("orders") int orders,
                              @RequestParam("warehouse") int warehouse,
                              @RequestParam("plan") int plan,
                              @RequestParam("affairs") int affairs,
                              HttpServletRequest request){
        //todo 在这里需要添加对用户审核时的数据库操作
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            if(approve.equals("on")){
                mv.setViewName("redirect:/approvelist");
                PermissionUtil.setPermission(mv,request);
                PermissionObject permission = new PermissionObject();
                permission.setId(id);
                permission.setUsers(user);
                permission.setOrders(orders);
                permission.setWarehouse(warehouse);
                permission.setPlan(plan);
                permission.setAffairs(affairs);
                PermissionService.insertPermission(permission);
                UserService.changeState(id);
                return mv;
            }else{
                mv.setViewName("redirect:/approve");
                return mv;
            }
        }
        else{
            mv.setViewName("redirect:/log");
            return mv;
        }
    }

    /**
     * 和某个确定ID的用户有关的审核
     * @param id 用户ID
     * @param request 请求类
     * @return 返回ModelAndView
     */
    @GetMapping("/approve/{id}")
    public ModelAndView approve(@PathVariable("id") int id,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            PermissionUtil.setPermission(mv,request);
            mv.setViewName("/approve");
            UsersObject user = UserService.getUser(id);
            mv.addObject("user",user);
            return mv;
        }
        else
            mv.setViewName("redirect:/log");
            return mv;
    }
}
