package com.ruoyi.aviation.mapper;

import java.util.List;
import com.ruoyi.aviation.domain.TicketPrices;

/**
 * 机票价格Mapper接口
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public interface TicketPricesMapper 
{
    /**
     * 查询机票价格
     * 
     * @param priceId 机票价格主键
     * @return 机票价格
     */
    public TicketPrices selectTicketPricesByPriceId(Long priceId);

    /**
     * 查询机票价格列表
     * 
     * @param ticketPrices 机票价格
     * @return 机票价格集合
     */
    public List<TicketPrices> selectTicketPricesList(TicketPrices ticketPrices);

    /**
     * 新增机票价格
     * 
     * @param ticketPrices 机票价格
     * @return 结果
     */
    public int insertTicketPrices(TicketPrices ticketPrices);

    /**
     * 修改机票价格
     * 
     * @param ticketPrices 机票价格
     * @return 结果
     */
    public int updateTicketPrices(TicketPrices ticketPrices);

    /**
     * 删除机票价格
     * 
     * @param priceId 机票价格主键
     * @return 结果
     */
    public int deleteTicketPricesByPriceId(Long priceId);

    /**
     * 批量删除机票价格
     * 
     * @param priceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTicketPricesByPriceIds(Long[] priceIds);
}
