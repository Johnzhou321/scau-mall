/*
 * /**
 * Project Name:xrk-mall-admin-api-
 * File Name:PageVo.java
 * Package Name:com.xiangrikui.mall.admin.vo
 * Date:2016年3月10日下午3:04:26
 * Copyright (c) 2016, zhouxiaolong@xiangrikui.com All Rights Reserved.
 */
package org.scau.mall.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @title:PageVo.java
 * @description:PageVo.java
 * @author zhouxiaolong
 * @date 2016年3月10日
 * @version
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PmsClientQueryVo extends BaseQueryVo{
    /**
    *
    */

    private static final long serialVersionUID = 1L;

    private String name;

    private String idNumber;

    private String telephone;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
