package com.bishe.logistics_management.database.service;

import com.bishe.logistics_management.database.dao.PermissionDao;
import com.bishe.logistics_management.database.dataObject.PermissionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Permission表的服务类
 * @author 黄伟
 */
@Service
public class PermissionService {
    private static PermissionDao permissionDao;

    /**
     * 初始化函数
     * @param permissionDao PermissionDao
     */
    @Autowired
    public PermissionService(PermissionDao permissionDao){
        PermissionService.permissionDao = permissionDao;
    }

    /**
     * 向Permission表中插入一行数据
     * @param permission Permission类
     */
    public static void insertPermission(PermissionObject permission){permissionDao.insertPermission(permission);}

    /**
     * 按照ID号获取权限类
     * @param id 用户ID
     * @return 返回权限类
     */
    public static PermissionObject getPermission(int id){return permissionDao.getPermission(id);}
}
