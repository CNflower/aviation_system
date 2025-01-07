package com.ruoyi.aviation.service;

import java.util.List;
import com.ruoyi.aviation.domain.TransitFlights;

/**
 * 中转航班信息Service接口
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public interface ITransitFlightsService 
{
    /**
     * 查询中转航班信息
     * 
     * @param transitId 中转航班信息主键
     * @return 中转航班信息
     */
    public TransitFlights selectTransitFlightsByTransitId(Long transitId);

    /**
     * 查询中转航班信息列表
     * 
     * @param transitFlights 中转航班信息
     * @return 中转航班信息集合
     */
    public List<TransitFlights> selectTransitFlightsList(TransitFlights transitFlights);

    /**
     * 新增中转航班信息
     * 
     * @param transitFlights 中转航班信息
     * @return 结果
     */
    public int insertTransitFlights(TransitFlights transitFlights);

    /**
     * 修改中转航班信息
     * 
     * @param transitFlights 中转航班信息
     * @return 结果
     */
    public int updateTransitFlights(TransitFlights transitFlights);

    /**
     * 批量删除中转航班信息
     * 
     * @param transitIds 需要删除的中转航班信息主键集合
     * @return 结果
     */
    public int deleteTransitFlightsByTransitIds(Long[] transitIds);

    /**
     * 删除中转航班信息信息
     * 
     * @param transitId 中转航班信息主键
     * @return 结果
     */
    public int deleteTransitFlightsByTransitId(Long transitId);
}
