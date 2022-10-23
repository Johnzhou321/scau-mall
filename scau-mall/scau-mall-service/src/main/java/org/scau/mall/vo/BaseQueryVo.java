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
 * 页面查询basevo
 * 分页参数
 * BaseQueryVo: BaseQueryVo.java.
 *
 * <br>==========================
 * <br> 公司：广州向日葵信息科技有限公司
 * <br> 开发：John@xiangrikui.com
 * <br> 创建时间：2022年1月15日
 * <br> 修改时间：2022年1月15日
 * <br> 版本：1.0
 * <br> JDK版本：1.8
 * <br>==========================
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseQueryVo {

    private Integer page = 1;//当前页数
    @JsonProperty("limit")
    private Integer limit = 20;//每页记录数
    
    private Integer offSet;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    public Integer getOffSet() {
        return (this.page - 1) * this.limit;
    }
}
