package org.scau.mall.vo.resp;

/**
 * 响应错误码
 * ErrorStatus: ErrorStatus.java.
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
public enum ResponseStatus implements Status {

    SUCCESS(200, "成功"),
    CREATE_SUCCESS(201, "创建成功"),
    DELETE_SUCCESS(204, "删除成功"),
    SYSTEM_ERROR(500, "系统错误");

    private final Integer status;
    private final String msg;


    private ResponseStatus(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public String getStatusMsg() {
        return toString();
    }

    @Override
    public String toString() {
        return msg;
    }

    public String toString(Object... params) {
        if (params == null)
            return String.format(msg, "");
        return String.format(msg, params);
    }

    public static ResponseStatus valueOfCode(final String status) {
        for (ResponseStatus s : ResponseStatus.values()) {
            if (s.status.equals(status)) {
                return s;
            }
        }
        return null;
    }
}