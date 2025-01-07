package com.ruoyi.aviation.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 中转航班信息对象 a_transit_flights
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public class TransitFlights extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 中转ID */
    private Long transitId;

    /** 主航班ID */
    @Excel(name = "主航班ID")
    private Long flightId;

    /** 中转机场 */
    @Excel(name = "中转机场")
    private String transitAircom;

    /** 中转城市 */
    @Excel(name = "中转城市")
    private String transitCity;

    /** 中转起飞时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "中转起飞时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    /** 中转到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "中转到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 中转顺序（1表示第1段，依此类推） */
    @Excel(name = "中转顺序", readConverterExp = "1=表示第1段，依此类推")
    private Long transitOrder;

    /** 该段行程的座位数 */
    @Excel(name = "该段行程的座位数")
    private Long totalSeats;

    /** 该段行程的票价 */
    @Excel(name = "该段行程的票价")
    private BigDecimal price;

    /** 记录创建时间 */
    private Date createdTime;

    /** 记录更新时间 */
    private Date updatedTime;

    public void setTransitId(Long transitId) 
    {
        this.transitId = transitId;
    }

    public Long getTransitId() 
    {
        return transitId;
    }
    public void setFlightId(Long flightId) 
    {
        this.flightId = flightId;
    }

    public Long getFlightId() 
    {
        return flightId;
    }
    public void setTransitAircom(String transitAircom) 
    {
        this.transitAircom = transitAircom;
    }

    public String getTransitAircom() 
    {
        return transitAircom;
    }
    public void setTransitCity(String transitCity) 
    {
        this.transitCity = transitCity;
    }

    public String getTransitCity() 
    {
        return transitCity;
    }
    public void setDepartureTime(Date departureTime) 
    {
        this.departureTime = departureTime;
    }

    public Date getDepartureTime() 
    {
        return departureTime;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setTransitOrder(Long transitOrder) 
    {
        this.transitOrder = transitOrder;
    }

    public Long getTransitOrder() 
    {
        return transitOrder;
    }
    public void setTotalSeats(Long totalSeats) 
    {
        this.totalSeats = totalSeats;
    }

    public Long getTotalSeats() 
    {
        return totalSeats;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
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
            .append("transitId", getTransitId())
            .append("flightId", getFlightId())
            .append("transitAircom", getTransitAircom())
            .append("transitCity", getTransitCity())
            .append("departureTime", getDepartureTime())
            .append("arrivalTime", getArrivalTime())
            .append("transitOrder", getTransitOrder())
            .append("totalSeats", getTotalSeats())
            .append("price", getPrice())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
