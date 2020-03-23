package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.TodoListDao;
import com.bishe.logistics_management.database.dataObject.TodoListObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 代办列表的服务类
 * @author 黄伟
 */
@Service
public class TodoListService {
    private static TodoListDao todoListDao;

    /**
     * 构造函数
     * @param todoListDao 代办列表的Dao层
     */
    @Autowired
    public TodoListService(TodoListDao todoListDao){
        TodoListService.todoListDao = todoListDao;
    }

    /**
     * 插入代办列表的数据库
     * @param todoListObject 代办列表数据对象
     */
    public static void insertTodoList(TodoListObject todoListObject){
        todoListDao.insertTodoList(todoListObject);
    }

    /**
     * 按照ID 获取代办信息列表
     * @param id ID
     * @return 返回信息列表
     */
    public static ArrayList<TodoListObject> getTodoList(int id){
        return todoListDao.getTodoList(id);
    }
}
