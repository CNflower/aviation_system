package com.ruoyi.aviation.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 退票记录对象 a_refunds
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public class Refunds extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 退票ID */
    private Long refundId;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderId;

    /** 退款金额 */
    @Excel(name = "退款金额")
    private BigDecimal refundAmount;

    /** 退票原因 */
    @Excel(name = "退票原因")
    private String refundReason;

    /** 退票状态 */
    @Excel(name = "退票状态")
    private String refundStatus;

    /** 退票时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date refundTime;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 记录更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setRefundId(Long refundId) 
    {
        this.refundId = refundId;
    }

    public Long getRefundId() 
    {
        return refundId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setRefundAmount(BigDecimal refundAmount) 
    {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRefundAmount() 
    {
        return refundAmount;
    }
    public void setRefundReason(String refundReason) 
    {
        this.refundReason = refundReason;
    }

    public String getRefundReason() 
    {
        return refundReason;
    }
    public void setRefundStatus(String refundStatus) 
    {
        this.refundStatus = refundStatus;
    }

    public String getRefundStatus() 
    {
        return refundStatus;
    }
    public void setRefundTime(Date refundTime) 
    {
        this.refundTime = refundTime;
    }

    public Date getRefundTime() 
    {
        return refundTime;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("refundId", getRefundId())
            .append("orderId", getOrderId())
            .append("refundAmount", getRefundAmount())
            .append("refundReason", getRefundReason())
            .append("refundStatus", getRefundStatus())
            .append("refundTime", getRefundTime())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
