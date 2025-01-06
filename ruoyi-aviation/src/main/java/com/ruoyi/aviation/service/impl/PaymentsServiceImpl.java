package com.ruoyi.aviation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.aviation.mapper.PaymentsMapper;
import com.ruoyi.aviation.domain.Payments;
import com.ruoyi.aviation.service.IPaymentsService;

/**
 * 支付记录Service业务层处理
 * 
 * @author Sleeping
 * @date 2025-01-06
 */
@Service
public class PaymentsServiceImpl implements IPaymentsService 
{
    @Autowired
    private PaymentsMapper paymentsMapper;

    /**
     * 查询支付记录
     * 
     * @param paymentId 支付记录主键
     * @return 支付记录
     */
    @Override
    public Payments selectPaymentsByPaymentId(Long paymentId)
    {
        return paymentsMapper.selectPaymentsByPaymentId(paymentId);
    }

    /**
     * 查询支付记录列表
     * 
     * @param payments 支付记录
     * @return 支付记录
     */
    @Override
    public List<Payments> selectPaymentsList(Payments payments)
    {
        return paymentsMapper.selectPaymentsList(payments);
    }

    /**
     * 新增支付记录
     * 
     * @param payments 支付记录
     * @return 结果
     */
    @Override
    public int insertPayments(Payments payments)
    {
        return paymentsMapper.insertPayments(payments);
    }

    /**
     * 修改支付记录
     * 
     * @param payments 支付记录
     * @return 结果
     */
    @Override
    public int updatePayments(Payments payments)
    {
        return paymentsMapper.updatePayments(payments);
    }

    /**
     * 批量删除支付记录
     * 
     * @param paymentIds 需要删除的支付记录主键
     * @return 结果
     */
    @Override
    public int deletePaymentsByPaymentIds(Long[] paymentIds)
    {
        return paymentsMapper.deletePaymentsByPaymentIds(paymentIds);
    }

    /**
     * 删除支付记录信息
     * 
     * @param paymentId 支付记录主键
     * @return 结果
     */
    @Override
    public int deletePaymentsByPaymentId(Long paymentId)
    {
        return paymentsMapper.deletePaymentsByPaymentId(paymentId);
    }
}
