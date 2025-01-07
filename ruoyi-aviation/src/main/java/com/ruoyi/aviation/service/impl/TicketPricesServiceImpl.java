package com.ruoyi.aviation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.aviation.mapper.TicketPricesMapper;
import com.ruoyi.aviation.domain.TicketPrices;
import com.ruoyi.aviation.service.ITicketPricesService;

/**
 * 机票价格Service业务层处理
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@Service
public class TicketPricesServiceImpl implements ITicketPricesService 
{
    @Autowired
    private TicketPricesMapper ticketPricesMapper;

    /**
     * 查询机票价格
     * 
     * @param priceId 机票价格主键
     * @return 机票价格
     */
    @Override
    public TicketPrices selectTicketPricesByPriceId(Long priceId)
    {
        return ticketPricesMapper.selectTicketPricesByPriceId(priceId);
    }

    /**
     * 查询机票价格列表
     * 
     * @param ticketPrices 机票价格
     * @return 机票价格
     */
    @Override
    public List<TicketPrices> selectTicketPricesList(TicketPrices ticketPrices)
    {
        return ticketPricesMapper.selectTicketPricesList(ticketPrices);
    }

    /**
     * 新增机票价格
     * 
     * @param ticketPrices 机票价格
     * @return 结果
     */
    @Override
    public int insertTicketPrices(TicketPrices ticketPrices)
    {
        return ticketPricesMapper.insertTicketPrices(ticketPrices);
    }

    /**
     * 修改机票价格
     * 
     * @param ticketPrices 机票价格
     * @return 结果
     */
    @Override
    public int updateTicketPrices(TicketPrices ticketPrices)
    {
        return ticketPricesMapper.updateTicketPrices(ticketPrices);
    }

    /**
     * 批量删除机票价格
     * 
     * @param priceIds 需要删除的机票价格主键
     * @return 结果
     */
    @Override
    public int deleteTicketPricesByPriceIds(Long[] priceIds)
    {
        return ticketPricesMapper.deleteTicketPricesByPriceIds(priceIds);
    }

    /**
     * 删除机票价格信息
     * 
     * @param priceId 机票价格主键
     * @return 结果
     */
    @Override
    public int deleteTicketPricesByPriceId(Long priceId)
    {
        return ticketPricesMapper.deleteTicketPricesByPriceId(priceId);
    }
}
