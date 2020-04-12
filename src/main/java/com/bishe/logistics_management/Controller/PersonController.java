package com.bishe.logistics_management.Controller;


import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.LogRecordUtil;
import com.bishe.logistics_management.Utils.PermissionUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.*;
import com.bishe.logistics_management.database.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

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

    /**
     * 处理提交代办列表的方法
     * @param request 请求类
     * @param date 截止日期
     * @param content 代办内容
     * @return 返回 mv
     */
    @RequestMapping("/submittodolist")
    public ModelAndView todolist(HttpServletRequest request,
                                 @RequestParam("date") String date,
                                 @RequestParam("content") String content){
        ModelAndView mv = new ModelAndView();
        TodoListObject t = new TodoListObject();
        t.setUserid(UserUtil.getUser(request).getId());
        t.setTime(date);
        t.setContent(content);
        TodoListService.insertTodoList(t);
        mv.setViewName("redirect:/todolist");
        return mv;
    }

    /**
     * 代办事项页面拦截器
     * @param request 请求方法
     * @return 返回 mv
     */
    @RequestMapping("/todolist")
    public ModelAndView todolist(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        if(CookieUtil.checkLogIn(mv,request)) {
            mv.setViewName("todolist");
        }else{
            mv.setViewName("redirect:/log");
        }
        return mv;
    }

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
    public ModelAndView approve(@PathVariable("id") int id, HttpServletRequest request){
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
