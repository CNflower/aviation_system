package com.ruoyi.aviation.mapper;

import java.util.List;
import com.ruoyi.aviation.domain.Refunds;

/**
 * 退票记录Mapper接口
 * 
 * @author Sleeping
 * @date 2025-01-06
 */
public interface RefundsMapper 
{
    /**
     * 查询退票记录
     * 
     * @param refundId 退票记录主键
     * @return 退票记录
     */
    public Refunds selectRefundsByRefundId(Long refundId);

    /**
     * 查询退票记录列表
     * 
     * @param refunds 退票记录
     * @return 退票记录集合
     */
    public List<Refunds> selectRefundsList(Refunds refunds);

    /**
     * 新增退票记录
     * 
     * @param refunds 退票记录
     * @return 结果
     */
    public int insertRefunds(Refunds refunds);

    /**
     * 修改退票记录
     * 
     * @param refunds 退票记录
     * @return 结果
     */
    public int updateRefunds(Refunds refunds);

    /**
     * 删除退票记录
     * 
     * @param refundId 退票记录主键
     * @return 结果
     */
    public int deleteRefundsByRefundId(Long refundId);

    /**
     * 批量删除退票记录
     * 
     * @param refundIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRefundsByRefundIds(Long[] refundIds);
}
