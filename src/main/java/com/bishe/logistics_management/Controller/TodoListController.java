package com.bishe.logistics_management.Controller;


import com.bishe.logistics_management.Utils.CookieUtil;
import com.bishe.logistics_management.Utils.UserUtil;
import com.bishe.logistics_management.database.dataObject.TodoListObject;
import com.bishe.logistics_management.database.service.TodoListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * 代办列表的拦截控制器
 * @author 黄伟
 */
@Controller
public class TodoListController {
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
}
