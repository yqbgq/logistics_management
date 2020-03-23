package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.PermissionObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Permission表的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface PermissionDao {
    /**
     * 通过ID获取权限类别
     * @param id 用户ID
     * @return 返回权限类
     */
    PermissionObject getPermission(int id);

    /**
     * 将权限类插入数据库中
     * @param permission 权限类
     */
    void insertPermission(PermissionObject permission);
}
