package com.ruoyi.aviation.mapper;

import java.util.List;
import com.ruoyi.aviation.domain.Payments;

/**
 * 支付记录Mapper接口
 * 
 * @author Sleeping
 * @date 2025-01-06
 */
public interface PaymentsMapper 
{
    /**
     * 查询支付记录
     * 
     * @param paymentId 支付记录主键
     * @return 支付记录
     */
    public Payments selectPaymentsByPaymentId(Long paymentId);

    /**
     * 查询支付记录列表
     * 
     * @param payments 支付记录
     * @return 支付记录集合
     */
    public List<Payments> selectPaymentsList(Payments payments);

    /**
     * 新增支付记录
     * 
     * @param payments 支付记录
     * @return 结果
     */
    public int insertPayments(Payments payments);

    /**
     * 修改支付记录
     * 
     * @param payments 支付记录
     * @return 结果
     */
    public int updatePayments(Payments payments);

    /**
     * 删除支付记录
     * 
     * @param paymentId 支付记录主键
     * @return 结果
     */
    public int deletePaymentsByPaymentId(Long paymentId);

    /**
     * 批量删除支付记录
     * 
     * @param paymentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePaymentsByPaymentIds(Long[] paymentIds);
}
