package com.bishe.logistics_management.Utils;

import com.bishe.logistics_management.database.dataObject.TodoListObject;
import com.bishe.logistics_management.database.service.TodoListService;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 代办列表的工具类
 * @author 黄伟
 */
public class TodoListUtil {

    /**
     * 添加代办列表的方法
     * @param mv MV
     * @param request 请求类
     */
    public static void addTodoList(ModelAndView mv, HttpServletRequest request){
        ArrayList<TodoListObject> todolists = TodoListService.getTodoList(UserUtil.getUser(request).getId());
        mv.addObject("todolist",todolists);
    }
}
