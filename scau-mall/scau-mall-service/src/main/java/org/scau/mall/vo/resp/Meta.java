package org.scau.mall.vo.resp;


/**
 * 前后端交互响应
 * CommonRespone: CommonRespone.java.
 *
 * <br>==========================
 * <br> 公司：广州向日葵信息科技有限公司
 * <br> 开发：John@xiangrikui.com
 * <br> 创建时间：2022年2月2日
 * <br> 修改时间：2022年2月2日
 * <br> 版本：1.0
 * <br> JDK版本：1.8
 * <br>==========================
 */
public class Meta {

    private String msg;

    private Integer status;
    
    public Meta() {}

    public Meta(String msg, Integer status) {
        super();
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
