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
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @title:PageVo.java
 * @description:PageVo.java
 * @author zhouxiaolong
 * @date 2016年3月10日
 * @version
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageVo {

    private long total;//总数
    private Integer page;//当前页数
    @JsonProperty("per_page")
    private Integer perPage;//每页记录数
    @JsonProperty("total_page")
    private Integer totalPage;//总页数

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}
