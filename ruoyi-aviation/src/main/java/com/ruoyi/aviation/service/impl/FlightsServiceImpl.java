package com.ruoyi.aviation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.aviation.mapper.FlightsMapper;
import com.ruoyi.aviation.domain.Flights;
import com.ruoyi.aviation.service.IFlightsService;

/**
 * 航班信息Service业务层处理
 * 
 * @author sleeping
 * @date 2025-01-06
 */
@Service
public class FlightsServiceImpl implements IFlightsService 
{
    @Autowired
    private FlightsMapper flightsMapper;

    /**
     * 查询航班信息
     * 
     * @param flightId 航班信息主键
     * @return 航班信息
     */
    @Override
    public Flights selectFlightsByFlightId(Long flightId)
    {
        return flightsMapper.selectFlightsByFlightId(flightId);
    }

    /**
     * 查询航班信息列表
     * 
     * @param flights 航班信息
     * @return 航班信息
     */
    @Override
    public List<Flights> selectFlightsList(Flights flights)
    {
        return flightsMapper.selectFlightsList(flights);
    }

    /**
     * 新增航班信息
     * 
     * @param flights 航班信息
     * @return 结果
     */
    @Override
    public int insertFlights(Flights flights)
    {
        return flightsMapper.insertFlights(flights);
    }

    /**
     * 修改航班信息
     * 
     * @param flights 航班信息
     * @return 结果
     */
    @Override
    public int updateFlights(Flights flights)
    {
        return flightsMapper.updateFlights(flights);
    }

    /**
     * 批量删除航班信息
     * 
     * @param flightIds 需要删除的航班信息主键
     * @return 结果
     */
    @Override
    public int deleteFlightsByFlightIds(Long[] flightIds)
    {
        return flightsMapper.deleteFlightsByFlightIds(flightIds);
    }

    /**
     * 删除航班信息信息
     * 
     * @param flightId 航班信息主键
     * @return 结果
     */
    @Override
    public int deleteFlightsByFlightId(Long flightId)
    {
        return flightsMapper.deleteFlightsByFlightId(flightId);
    }
}
