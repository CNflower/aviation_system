package com.ruoyi.aviation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 航班信息对象 a_flights
 * 
 * @author sleeping
 * @date 2025-01-06
 */
public class Flights extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 航班号 */
    private Long flightId;

    /** 航空公司 */
    @Excel(name = "航空公司")
    private String airlineCompany;

    /** 出发城市 */
    @Excel(name = "出发城市")
    private String departureCity;

    /** 到达城市 */
    @Excel(name = "到达城市")
    private String arrivalCity;

    /** 出发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departureTime;

    /** 到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 飞机型号 */
    @Excel(name = "飞机型号")
    private String aircraftType;

    /** 总座位数 */
    @Excel(name = "总座位数")
    private Long totalSeats;

    /** 航班状态 */
    @Excel(name = "航班状态")
    private String status;

    /** 记录创建时间 */
    private Date createdTime;

    /** 记录更新时间 */
    private Date updatedTime;

    public void setFlightId(Long flightId) 
    {
        this.flightId = flightId;
    }

    public Long getFlightId() 
    {
        return flightId;
    }
    public void setAirlineCompany(String airlineCompany) 
    {
        this.airlineCompany = airlineCompany;
    }

    public String getAirlineCompany() 
    {
        return airlineCompany;
    }
    public void setDepartureCity(String departureCity) 
    {
        this.departureCity = departureCity;
    }

    public String getDepartureCity() 
    {
        return departureCity;
    }
    public void setArrivalCity(String arrivalCity) 
    {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalCity() 
    {
        return arrivalCity;
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
    public void setAircraftType(String aircraftType) 
    {
        this.aircraftType = aircraftType;
    }

    public String getAircraftType() 
    {
        return aircraftType;
    }
    public void setTotalSeats(Long totalSeats) 
    {
        this.totalSeats = totalSeats;
    }

    public Long getTotalSeats() 
    {
        return totalSeats;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("flightId", getFlightId())
            .append("airlineCompany", getAirlineCompany())
            .append("departureCity", getDepartureCity())
            .append("arrivalCity", getArrivalCity())
            .append("departureTime", getDepartureTime())
            .append("arrivalTime", getArrivalTime())
            .append("aircraftType", getAircraftType())
            .append("totalSeats", getTotalSeats())
            .append("status", getStatus())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
