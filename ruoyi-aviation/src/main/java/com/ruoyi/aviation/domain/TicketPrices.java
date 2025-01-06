package com.ruoyi.aviation.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机票价格对象 a_ticket_prices
 * 
 * @author Sleeping
 * @date 2025-01-06
 */
public class TicketPrices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 价格ID */
    private Long priceId;

    /** 航班号 */
    @Excel(name = "航班号")
    private String flightId;

    /** 舱位等级 */
    @Excel(name = "舱位等级")
    private String cabinClass;

    /** 票价 */
    @Excel(name = "票价")
    private BigDecimal price;

    /** 剩余座位数 */
    @Excel(name = "剩余座位数")
    private Long remainingSeats;

    /** 记录创建时间 */
    private Date createdTime;

    /** 记录更新时间 */
    private Date updatedTime;

    public void setPriceId(Long priceId) 
    {
        this.priceId = priceId;
    }

    public Long getPriceId() 
    {
        return priceId;
    }
    public void setFlightId(String flightId) 
    {
        this.flightId = flightId;
    }

    public String getFlightId() 
    {
        return flightId;
    }
    public void setCabinClass(String cabinClass) 
    {
        this.cabinClass = cabinClass;
    }

    public String getCabinClass() 
    {
        return cabinClass;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setRemainingSeats(Long remainingSeats) 
    {
        this.remainingSeats = remainingSeats;
    }

    public Long getRemainingSeats() 
    {
        return remainingSeats;
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
            .append("priceId", getPriceId())
            .append("flightId", getFlightId())
            .append("cabinClass", getCabinClass())
            .append("price", getPrice())
            .append("remainingSeats", getRemainingSeats())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
