package org.scau.mall.service.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PmsOrders implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.order_no
     *
     * @mbggenerated
     */
    private String orderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.apply_amount
     *
     * @mbggenerated
     */
    private BigDecimal applyAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.actual_amount
     *
     * @mbggenerated
     */
    private BigDecimal actualAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.client_id
     *
     * @mbggenerated
     */
    private Integer clientId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.document_url
     *
     * @mbggenerated
     */
    private String documentUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.audit_remark
     *
     * @mbggenerated
     */
    private String auditRemark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.audit_time
     *
     * @mbggenerated
     */
    private Date auditTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.approve_time
     *
     * @mbggenerated
     */
    private Date approveTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.created_at
     *
     * @mbggenerated
     */
    private Date createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_orders.updated_at
     *
     * @mbggenerated
     */
    private Date updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pms_orders
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.order_no
     *
     * @return the value of pms_orders.order_no
     *
     * @mbggenerated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.order_no
     *
     * @param orderNo the value for pms_orders.order_no
     *
     * @mbggenerated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.type
     *
     * @return the value of pms_orders.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.type
     *
     * @param type the value for pms_orders.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.apply_amount
     *
     * @return the value of pms_orders.apply_amount
     *
     * @mbggenerated
     */
    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.apply_amount
     *
     * @param applyAmount the value for pms_orders.apply_amount
     *
     * @mbggenerated
     */
    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.actual_amount
     *
     * @return the value of pms_orders.actual_amount
     *
     * @mbggenerated
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.actual_amount
     *
     * @param actualAmount the value for pms_orders.actual_amount
     *
     * @mbggenerated
     */
    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.client_id
     *
     * @return the value of pms_orders.client_id
     *
     * @mbggenerated
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.client_id
     *
     * @param clientId the value for pms_orders.client_id
     *
     * @mbggenerated
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.status
     *
     * @return the value of pms_orders.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.status
     *
     * @param status the value for pms_orders.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.document_url
     *
     * @return the value of pms_orders.document_url
     *
     * @mbggenerated
     */
    public String getDocumentUrl() {
        return documentUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.document_url
     *
     * @param documentUrl the value for pms_orders.document_url
     *
     * @mbggenerated
     */
    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl == null ? null : documentUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.audit_remark
     *
     * @return the value of pms_orders.audit_remark
     *
     * @mbggenerated
     */
    public String getAuditRemark() {
        return auditRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.audit_remark
     *
     * @param auditRemark the value for pms_orders.audit_remark
     *
     * @mbggenerated
     */
    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.audit_time
     *
     * @return the value of pms_orders.audit_time
     *
     * @mbggenerated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.audit_time
     *
     * @param auditTime the value for pms_orders.audit_time
     *
     * @mbggenerated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.approve_time
     *
     * @return the value of pms_orders.approve_time
     *
     * @mbggenerated
     */
    public Date getApproveTime() {
        return approveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.approve_time
     *
     * @param approveTime the value for pms_orders.approve_time
     *
     * @mbggenerated
     */
    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.created_at
     *
     * @return the value of pms_orders.created_at
     *
     * @mbggenerated
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.created_at
     *
     * @param createdAt the value for pms_orders.created_at
     *
     * @mbggenerated
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_orders.updated_at
     *
     * @return the value of pms_orders.updated_at
     *
     * @mbggenerated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_orders.updated_at
     *
     * @param updatedAt the value for pms_orders.updated_at
     *
     * @mbggenerated
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_orders
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PmsOrders other = (PmsOrders) that;
        return (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getApplyAmount() == null ? other.getApplyAmount() == null : this.getApplyAmount().equals(other.getApplyAmount()))
            && (this.getActualAmount() == null ? other.getActualAmount() == null : this.getActualAmount().equals(other.getActualAmount()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDocumentUrl() == null ? other.getDocumentUrl() == null : this.getDocumentUrl().equals(other.getDocumentUrl()))
            && (this.getAuditRemark() == null ? other.getAuditRemark() == null : this.getAuditRemark().equals(other.getAuditRemark()))
            && (this.getAuditTime() == null ? other.getAuditTime() == null : this.getAuditTime().equals(other.getAuditTime()))
            && (this.getApproveTime() == null ? other.getApproveTime() == null : this.getApproveTime().equals(other.getApproveTime()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_orders
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getApplyAmount() == null) ? 0 : getApplyAmount().hashCode());
        result = prime * result + ((getActualAmount() == null) ? 0 : getActualAmount().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDocumentUrl() == null) ? 0 : getDocumentUrl().hashCode());
        result = prime * result + ((getAuditRemark() == null) ? 0 : getAuditRemark().hashCode());
        result = prime * result + ((getAuditTime() == null) ? 0 : getAuditTime().hashCode());
        result = prime * result + ((getApproveTime() == null) ? 0 : getApproveTime().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pms_orders
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderNo=").append(orderNo);
        sb.append(", type=").append(type);
        sb.append(", applyAmount=").append(applyAmount);
        sb.append(", actualAmount=").append(actualAmount);
        sb.append(", clientId=").append(clientId);
        sb.append(", status=").append(status);
        sb.append(", documentUrl=").append(documentUrl);
        sb.append(", auditRemark=").append(auditRemark);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", approveTime=").append(approveTime);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}