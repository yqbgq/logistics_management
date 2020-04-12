package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.TodoListObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;


/**
 * 和Message有关的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface TodoListDao {

    /**
     * 插入代办列表的数据表
     * @param todoListObject 代办数据类
     */
    void insertTodoList(TodoListObject todoListObject);

    /**
     * 按照ID获取待办事项
     * @param id ID
     * @return 返回待办事项列表
     */
    ArrayList<TodoListObject> getTodoList(int id);
}
