package org.scau.mall.web.vo;

import java.util.List;

public class PageShowVo<T>{

    private long total;//总数
    private Integer pagenum;//当前页数
    private List<T> list;//记录列表
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public Integer getPagenum() {
        return pagenum;
    }
    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }

}
