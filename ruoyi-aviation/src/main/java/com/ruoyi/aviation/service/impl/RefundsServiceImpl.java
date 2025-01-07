package com.ruoyi.aviation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.aviation.mapper.RefundsMapper;
import com.ruoyi.aviation.domain.Refunds;
import com.ruoyi.aviation.service.IRefundsService;

/**
 * 退票记录Service业务层处理
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@Service
public class RefundsServiceImpl implements IRefundsService 
{
    @Autowired
    private RefundsMapper refundsMapper;

    /**
     * 查询退票记录
     * 
     * @param refundId 退票记录主键
     * @return 退票记录
     */
    @Override
    public Refunds selectRefundsByRefundId(Long refundId)
    {
        return refundsMapper.selectRefundsByRefundId(refundId);
    }

    /**
     * 查询退票记录列表
     * 
     * @param refunds 退票记录
     * @return 退票记录
     */
    @Override
    public List<Refunds> selectRefundsList(Refunds refunds)
    {
        return refundsMapper.selectRefundsList(refunds);
    }

    /**
     * 新增退票记录
     * 
     * @param refunds 退票记录
     * @return 结果
     */
    @Override
    public int insertRefunds(Refunds refunds)
    {
        return refundsMapper.insertRefunds(refunds);
    }

    /**
     * 修改退票记录
     * 
     * @param refunds 退票记录
     * @return 结果
     */
    @Override
    public int updateRefunds(Refunds refunds)
    {
        return refundsMapper.updateRefunds(refunds);
    }

    /**
     * 批量删除退票记录
     * 
     * @param refundIds 需要删除的退票记录主键
     * @return 结果
     */
    @Override
    public int deleteRefundsByRefundIds(Long[] refundIds)
    {
        return refundsMapper.deleteRefundsByRefundIds(refundIds);
    }

    /**
     * 删除退票记录信息
     * 
     * @param refundId 退票记录主键
     * @return 结果
     */
    @Override
    public int deleteRefundsByRefundId(Long refundId)
    {
        return refundsMapper.deleteRefundsByRefundId(refundId);
    }
}
