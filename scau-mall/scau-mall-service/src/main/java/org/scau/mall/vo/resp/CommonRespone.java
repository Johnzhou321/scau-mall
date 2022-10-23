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
public class CommonRespone<T> {

    /**
     * 响应表头
     */
    private Meta meta;

    private T data;

    public CommonRespone() {
        super();
    }

    public CommonRespone(Meta meta, T data) {
        super();
        this.meta = meta;
        this.data = data;
    }
    
    public static Meta createMeta(String msg, Integer status) {
        Meta meta = new Meta(msg, status);
        return meta;
    }
    
    public static Meta createDefaultSuccessMeta() {
        Meta meta = new Meta(ResponseStatus.SUCCESS.getStatusMsg(), ResponseStatus.SUCCESS.getStatus());
        return meta;
    }
    
    public static Meta createSuccessMeta(String msg) {
        Meta meta = new Meta(msg, ResponseStatus.SUCCESS.getStatus());
        return meta;
    }
    
    public static Meta createDefaultFailMeta() {
        Meta meta = new Meta(ResponseStatus.SYSTEM_ERROR.getStatusMsg(), ResponseStatus.SYSTEM_ERROR.getStatus());
        return meta;
    }
    
    public static Meta createFailMeta(String msg) {
        Meta meta = new Meta(msg, ResponseStatus.SYSTEM_ERROR.getStatus());
        return meta;
    }
    
    public static Meta createFailMeta(String msg, Integer status) {
        Meta meta = new Meta(msg, status);
        return meta;
    }

    public static <T> CommonRespone<T> failed(String msg) {
        CommonRespone<T> responeData = new CommonRespone<>();
        responeData.setMeta(createFailMeta(msg));
        return responeData;
    }
    
    public static <T> CommonRespone<T> failed(String msg, Integer status) {
        CommonRespone<T> responeData = new CommonRespone<>();
        responeData.setMeta(createFailMeta(msg, status));
        return responeData;
    }

    public static <T> CommonRespone<T> success(String msg) {
        CommonRespone<T> responeData = new CommonRespone<>();
        responeData.setMeta(createSuccessMeta(msg));
        return responeData;
    }

    public static <T> CommonRespone<T> success() {
        CommonRespone<T> responeData = new CommonRespone<>();
        responeData.setMeta(createDefaultSuccessMeta());
        return responeData;
    }
    
    public static <T> CommonRespone<T> success(String msg, T data) {
        CommonRespone<T> responeData = new CommonRespone<>();
        responeData.setMeta(createSuccessMeta(msg));
        responeData.setData(data);
        return responeData;
    }
    
    public static <T> CommonRespone<T> success(T data) {
        CommonRespone<T> responeData = new CommonRespone<>();
        responeData.setMeta(createDefaultSuccessMeta());
        responeData.setData(data);
        return responeData;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonRespone [meta=" + meta + ", data=" + data +"]";
    }

}
