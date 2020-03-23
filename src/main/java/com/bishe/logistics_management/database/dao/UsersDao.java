package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.UsersObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

/**
 * 用户表的DAO层，涉及了关于用户数据表上的操作
 * @author 黄伟
 */
@Mapper
@Component("userDao")
@Repository
public interface UsersDao {

    /**
     * 通过查询用户ID来获得用户类
     * @param id 用户ID
     * @return 用户对象
     */
    UsersObject getUser(long id);

    /**
     * 通过姓名以及密码来获取对应的用户类
     * @param name 用户名
     * @param password 用户密码
     * @return 用户对象
     */
    UsersObject getUserByAll(String name,String password);

    /**
     * 通过用户名和密码以确定用户是否存在
     * @param username 用户名
     * @param password 用户密码
     * @return 是否存在
     */
    int check(String username, String password);

    /**
     * 通过UsersObject来插入用户表
     * @param u 用户对象
     */
    void createUser(UsersObject u);

    /**
     * 获取所有未获得审批的用户列表
     * @return 未获得审批的用户数组
     */
    ArrayList<UsersObject> findAllApprovement();

    /**
     * 修改用户状态为可用
     * @param id ID号
     */
    void changeState(int id);

    /**
     * 获取所有的用户除了自己
     * @param id 用户ID
     * @return 返回用户数组
     */
    ArrayList<UsersObject> findAllUserExceptMe(int id);

    void resubmit(UsersObject usersObject);
}
