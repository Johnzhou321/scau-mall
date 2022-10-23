package org.scau.mall.web.vo;

/**
 * 放款表单
 * ApproveFormBody: ApproveFormBody.java.
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
public class ApproveFormBody {
    /*
     * 订单号
     */
    private String orderNo;
    
    /*
     * 申请金额
     */
    private String applyAmount;
    
    /*
     * 实际放款金额
     */
    private String actualAmount;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(String applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(String actualAmount) {
        this.actualAmount = actualAmount;
    }

    @Override
    public String toString() {
        return "ApproveFormBody [orderNo=" + orderNo + ", applyAmount=" + applyAmount + ", actualAmount=" + actualAmount + "]";
    }

}
