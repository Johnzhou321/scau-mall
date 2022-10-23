package org.scau.mall.vo;

import java.util.List;


public class Pagination<T> {

    private PageVo meta;
    private List<T> list;//记录列表

    public PageVo getMeta() {
        return meta;
    }

    public void setMeta(PageVo meta) {
        this.meta = meta;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
