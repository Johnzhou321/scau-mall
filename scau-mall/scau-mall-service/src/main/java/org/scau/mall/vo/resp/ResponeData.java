package org.scau.mall.vo.resp;

import java.util.List;


/**
 * 创建时间：2017年8月31日
 * <p>修改时间：2017年8月31日
 * <p>类说明：TODO
 * 
 * @author huangxingwei
 * @version 1.0
 */
public class ResponeData<T> {

    /**
     * 0--成功 1--失败
     */
    private int code;

    private String msg;

    private long count;

    private List<T> data;
    
    private Object obj;

    public ResponeData() {
        super();
    }

    public ResponeData(int code, String msg, long count, List<T> data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public ResponeData(long count, List<T> data) {
        super();
        this.code = 0;
        this.count = count;
        this.data = data;
    }

    public ResponeData(List<T> data) {
        super();
        this.code = 0;
        if (data != null) {
            this.count = data.size();
            this.data = data;
        }
    }

    public static <T> ResponeData<T> failed(String msg) {
        ResponeData<T> responeData = new ResponeData<>();
        responeData.setCode(-1);
        responeData.setMsg(msg);
        return responeData;
    }
    
    public static <T> ResponeData<T> failed(String msg, int code) {
        ResponeData<T> responeData = new ResponeData<>();
        responeData.setCode(code);
        responeData.setMsg(msg);
        return responeData;
    }

    public static <T> ResponeData<T> success(String msg) {
        ResponeData<T> responeData = new ResponeData<>();
        responeData.setCode(0);
        responeData.setMsg(msg);
        return responeData;
    }

    public static <T> ResponeData<T> success() {
        ResponeData<T> responeData = new ResponeData<>();
        responeData.setCode(0);
        return responeData;
    }

    public static <T> ResponeData<T> Empty() {
        ResponeData<T> responeData = new ResponeData<>();
        responeData.setCode(0);
        return responeData;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * @return the data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<T> data) {
        this.data = data;
    }
    
    
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResponeData [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + ", obj=" + obj + "]";
    }

}
