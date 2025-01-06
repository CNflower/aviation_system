package com.ruoyi.aviation.service;

import java.util.List;
import com.ruoyi.aviation.domain.Flights;

/**
 * 航班信息Service接口
 * 
 * @author sleeping
 * @date 2025-01-06
 */
public interface IFlightsService 
{
    /**
     * 查询航班信息
     * 
     * @param flightId 航班信息主键
     * @return 航班信息
     */
    public Flights selectFlightsByFlightId(Long flightId);

    /**
     * 查询航班信息列表
     * 
     * @param flights 航班信息
     * @return 航班信息集合
     */
    public List<Flights> selectFlightsList(Flights flights);

    /**
     * 新增航班信息
     * 
     * @param flights 航班信息
     * @return 结果
     */
    public int insertFlights(Flights flights);

    /**
     * 修改航班信息
     * 
     * @param flights 航班信息
     * @return 结果
     */
    public int updateFlights(Flights flights);

    /**
     * 批量删除航班信息
     * 
     * @param flightIds 需要删除的航班信息主键集合
     * @return 结果
     */
    public int deleteFlightsByFlightIds(Long[] flightIds);

    /**
     * 删除航班信息信息
     * 
     * @param flightId 航班信息主键
     * @return 结果
     */
    public int deleteFlightsByFlightId(Long flightId);
}
