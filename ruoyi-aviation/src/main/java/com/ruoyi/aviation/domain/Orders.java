package com.ruoyi.aviation.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 a_orders
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public class Orders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单号 */
    private Long orderId;

    /** 乘客ID */
    @Excel(name = "乘客ID")
    private Long passengerId;

    /** 航班号 */
    @Excel(name = "航班号")
    private Long flightId;

    /** 中转航班号 */
    @Excel(name = "中转航班号")
    private Long transitId;

    /** 价格ID */
    @Excel(name = "价格ID")
    private Long priceId;

    /** 座位号 */
    @Excel(name = "座位号")
    private String seatNumber;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentTime;

    /** 订单总额 */
    @Excel(name = "订单总额")
    private BigDecimal totalAmount;

    /** 支付宝交易号 */
    @Excel(name = "支付宝交易号")
    private String alino;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 记录更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setPassengerId(Long passengerId) 
    {
        this.passengerId = passengerId;
    }

    public Long getPassengerId() 
    {
        return passengerId;
    }
    public void setFlightId(Long flightId) 
    {
        this.flightId = flightId;
    }

    public Long getFlightId() 
    {
        return flightId;
    }
    public void setTransitId(Long transitId) 
    {
        this.transitId = transitId;
    }

    public Long getTransitId() 
    {
        return transitId;
    }
    public void setPriceId(Long priceId) 
    {
        this.priceId = priceId;
    }

    public Long getPriceId() 
    {
        return priceId;
    }
    public void setSeatNumber(String seatNumber) 
    {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() 
    {
        return seatNumber;
    }
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setPaymentTime(Date paymentTime) 
    {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentTime() 
    {
        return paymentTime;
    }
    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }
    public void setAlino(String alino) 
    {
        this.alino = alino;
    }

    public String getAlino() 
    {
        return alino;
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
            .append("orderId", getOrderId())
            .append("passengerId", getPassengerId())
            .append("flightId", getFlightId())
            .append("transitId", getTransitId())
            .append("priceId", getPriceId())
            .append("seatNumber", getSeatNumber())
            .append("orderStatus", getOrderStatus())
            .append("orderTime", getOrderTime())
            .append("paymentTime", getPaymentTime())
            .append("totalAmount", getTotalAmount())
            .append("alino", getAlino())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
