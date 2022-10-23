package org.scau.mall.web.vo;

/**
 * 审核表单
 * AuditFormBody: AuditFormBody.java.
 *
 * <br>==========================
 * <br> 公司：广州向日葵信息科技有限公司
 * <br> 开发：John@xiangrikui.com
 * <br> 创建时间：2022年3月15日
 * <br> 修改时间：2022年3月15日
 * <br> 版本：1.0
 * <br> JDK版本：1.8
 * <br>==========================
 */
public class AuditFormBody {
    /*
     * 订单号
     */
    private String orderNo;
    
    /*
     * 审核结果，2：审核通过，4：审核不通过
     */
    private String auditResult;
    
    /*
     * 审核备注
     */
    private String remarks;
    
    /*
     * 上传资料的路径
     */
    private String uploadPath;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Override
    public String toString() {
        return "AuditFormBody [orderNo=" + orderNo + ", auditResult=" + auditResult + ", remarks=" + remarks + ", uploadPath=" + uploadPath + "]";
    }
    
}
