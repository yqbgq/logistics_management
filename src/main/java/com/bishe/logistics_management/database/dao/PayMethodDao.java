package com.bishe.logistics_management.database.dao;

import com.bishe.logistics_management.database.dataObject.PayMethodObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 支付方式的Dao层
 * @author 黄伟
 */
@Mapper
@Repository
public interface PayMethodDao {

    /**
     * 插入新增的支付方式
     * @param payMethodObject 支付方式的数据对象
     */
    void insertPayMethod(PayMethodObject payMethodObject);
}
