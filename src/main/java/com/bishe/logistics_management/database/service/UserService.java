package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.UsersDao;
import com.bishe.logistics_management.database.dataObject.UsersObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 有关用户数据表的服务类
 * @author 黄伟
 */
@Service
public class UserService {


    private static UsersDao usersDao;

    /**
     * 初始化函数
     * @param usersDao UserDao
     */
    @Autowired
    public UserService(UsersDao usersDao){
        UserService.usersDao = usersDao;
    }

    /**
     * 通过用户ID获取用户类
     * @param id 用户ID
     * @return 返回用户数据类
     */
    public static UsersObject getUser(long id){
        return usersDao.getUser(id);
    }

    /**
     * 检查用户名以及密码
     * @param username 用户名
     * @param password 密码
     * @return 返回验证结果
     */
    public static int check(String username, String password){
        return usersDao.check(username,password);
    }

    /**
     * 向用户表中插入数据
     * @param u 一个用户类
     */
    public static void createUser(UsersObject u){
        usersDao.createUser(u);
    }

    /**
     * 插入所有等待审批的用户列表
     * @return 用户列表
     */
    public static ArrayList<UsersObject> findAllApprovement(){
        return usersDao.findAllApprovement();
    }

    /**
     * 修改审批过后的用户的状态
     * @param id 用户ID
     */
    public static void changeState(int id){usersDao.changeState(id);}

    /**
     * 通过用户名以及密码获取用户类
     * @param name 用户名
     * @param password 密码
     * @return 返回用户类
     */
    public static UsersObject getUserByAll(String name,String password){return usersDao.getUserByAll(name,password);}

    /**
     * 返回除自己之外的所有审核通过的用户列表
     * @param id 用户ID，表示自己的ID
     * @return 返回用户列表
     */
    public static ArrayList<UsersObject> findAllUserExceptMe(int id){return usersDao.findAllUserExceptMe(id);}

    /**
     * 重新提交用户信息
     * @param usersObject 用户数据信息
     */
    public static void resubmit(UsersObject usersObject){usersDao.resubmit(usersObject);}
}
