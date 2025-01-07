package com.ruoyi.aviation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.aviation.mapper.TransitFlightsMapper;
import com.ruoyi.aviation.domain.TransitFlights;
import com.ruoyi.aviation.service.ITransitFlightsService;

/**
 * 中转航班信息Service业务层处理
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@Service
public class TransitFlightsServiceImpl implements ITransitFlightsService 
{
    @Autowired
    private TransitFlightsMapper transitFlightsMapper;

    /**
     * 查询中转航班信息
     * 
     * @param transitId 中转航班信息主键
     * @return 中转航班信息
     */
    @Override
    public TransitFlights selectTransitFlightsByTransitId(Long transitId)
    {
        return transitFlightsMapper.selectTransitFlightsByTransitId(transitId);
    }

    /**
     * 查询中转航班信息列表
     * 
     * @param transitFlights 中转航班信息
     * @return 中转航班信息
     */
    @Override
    public List<TransitFlights> selectTransitFlightsList(TransitFlights transitFlights)
    {
        return transitFlightsMapper.selectTransitFlightsList(transitFlights);
    }

    /**
     * 新增中转航班信息
     * 
     * @param transitFlights 中转航班信息
     * @return 结果
     */
    @Override
    public int insertTransitFlights(TransitFlights transitFlights)
    {
        return transitFlightsMapper.insertTransitFlights(transitFlights);
    }

    /**
     * 修改中转航班信息
     * 
     * @param transitFlights 中转航班信息
     * @return 结果
     */
    @Override
    public int updateTransitFlights(TransitFlights transitFlights)
    {
        return transitFlightsMapper.updateTransitFlights(transitFlights);
    }

    /**
     * 批量删除中转航班信息
     * 
     * @param transitIds 需要删除的中转航班信息主键
     * @return 结果
     */
    @Override
    public int deleteTransitFlightsByTransitIds(Long[] transitIds)
    {
        return transitFlightsMapper.deleteTransitFlightsByTransitIds(transitIds);
    }

    /**
     * 删除中转航班信息信息
     * 
     * @param transitId 中转航班信息主键
     * @return 结果
     */
    @Override
    public int deleteTransitFlightsByTransitId(Long transitId)
    {
        return transitFlightsMapper.deleteTransitFlightsByTransitId(transitId);
    }
}
