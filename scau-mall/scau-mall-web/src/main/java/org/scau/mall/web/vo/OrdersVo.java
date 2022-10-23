package org.scau.mall.web.vo;

import java.io.Serializable;

public class OrdersVo implements Serializable{

    /**
    		*
    		*/
    	
    private static final long serialVersionUID = 1L;

    private String orderNo;
    
    private Integer clientId;
    
    /*
     * 姓名
     */
    private String name;
    
    private String idNumber;
    
    private String type;
    
    private String amount;
    
    private String actualAmount;
    
    private String status;
    
    private String createdAt;
    
    private String auditTime;
    
    private String approveTime;
    
    private String documentUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    @Override
    public String toString() {
        return "OrdersVo [orderNo=" + orderNo + ", clientId=" + clientId + ", name=" + name + ", idNumber=" + idNumber + ", type=" + type + ", amount=" + amount
                + ", actualAmount=" + actualAmount + ", status=" + status + ", createdAt=" + createdAt + ", auditTime=" + auditTime + ", approveTime="
                + approveTime + ", documentUrl=" + documentUrl + "]";
    }

    

}
