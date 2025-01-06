package com.ruoyi.aviation.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.aviation.domain.Payments;
import com.ruoyi.aviation.service.IPaymentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 支付记录Controller
 * 
 * @author Sleeping
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/aviation/payments")
public class PaymentsController extends BaseController
{
    @Autowired
    private IPaymentsService paymentsService;

    /**
     * 查询支付记录列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:payments:list')")
    @GetMapping("/list")
    public TableDataInfo list(Payments payments)
    {
        startPage();
        List<Payments> list = paymentsService.selectPaymentsList(payments);
        return getDataTable(list);
    }

    /**
     * 导出支付记录列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:payments:export')")
    @Log(title = "支付记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Payments payments)
    {
        List<Payments> list = paymentsService.selectPaymentsList(payments);
        ExcelUtil<Payments> util = new ExcelUtil<Payments>(Payments.class);
        util.exportExcel(response, list, "支付记录数据");
    }

    /**
     * 获取支付记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:payments:query')")
    @GetMapping(value = "/{paymentId}")
    public AjaxResult getInfo(@PathVariable("paymentId") Long paymentId)
    {
        return success(paymentsService.selectPaymentsByPaymentId(paymentId));
    }

    /**
     * 新增支付记录
     */
    @PreAuthorize("@ss.hasPermi('aviation:payments:add')")
    @Log(title = "支付记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Payments payments)
    {
        return toAjax(paymentsService.insertPayments(payments));
    }

    /**
     * 修改支付记录
     */
    @PreAuthorize("@ss.hasPermi('aviation:payments:edit')")
    @Log(title = "支付记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Payments payments)
    {
        return toAjax(paymentsService.updatePayments(payments));
    }

    /**
     * 删除支付记录
     */
    @PreAuthorize("@ss.hasPermi('aviation:payments:remove')")
    @Log(title = "支付记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{paymentIds}")
    public AjaxResult remove(@PathVariable Long[] paymentIds)
    {
        return toAjax(paymentsService.deletePaymentsByPaymentIds(paymentIds));
    }
}
