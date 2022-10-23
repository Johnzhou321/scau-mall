package org.scau.mall.web.enums;


/**
 * 
 *
 * ==========================
 * 公司：广州向日葵信息科技有限公司
 * 开发：xiexinhe@xiangrikui.com
 * 创建时间：2018年5月22日
 * 版本： 1.0
 * JDK版本：1.8
 * ==========================
 */
public enum LoanStatus{

    NONE_AUDIT("0", "待审核"), 
    AUDITING("1", "审核中"), 
    ALREDY_AUDIT("2", "审核通过"), 
    LOAN("3", "已放款"); 
    
    private String code;
    private String desc;
    
    LoanStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
   
    public static String getDescByCode(String code) {
        for(LoanStatus status : LoanStatus.values()) {
            if(status.getCode().equals(code)) {
                return status.getDesc();
            }
        }
        return null;
    }
}
