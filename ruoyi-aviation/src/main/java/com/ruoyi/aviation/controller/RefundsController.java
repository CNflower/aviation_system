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
import com.ruoyi.aviation.domain.Refunds;
import com.ruoyi.aviation.service.IRefundsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 退票记录Controller
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@RestController
@RequestMapping("/aviation/refunds")
public class RefundsController extends BaseController
{
    @Autowired
    private IRefundsService refundsService;

    /**
     * 查询退票记录列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:refunds:list')")
    @GetMapping("/list")
    public TableDataInfo list(Refunds refunds)
    {
        startPage();
        List<Refunds> list = refundsService.selectRefundsList(refunds);
        return getDataTable(list);
    }

    /**
     * 导出退票记录列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:refunds:export')")
    @Log(title = "退票记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Refunds refunds)
    {
        List<Refunds> list = refundsService.selectRefundsList(refunds);
        ExcelUtil<Refunds> util = new ExcelUtil<Refunds>(Refunds.class);
        util.exportExcel(response, list, "退票记录数据");
    }

    /**
     * 获取退票记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:refunds:query')")
    @GetMapping(value = "/{refundId}")
    public AjaxResult getInfo(@PathVariable("refundId") Long refundId)
    {
        return success(refundsService.selectRefundsByRefundId(refundId));
    }

    /**
     * 新增退票记录
     */
    @PreAuthorize("@ss.hasPermi('aviation:refunds:add')")
    @Log(title = "退票记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Refunds refunds)
    {
        return toAjax(refundsService.insertRefunds(refunds));
    }

    /**
     * 修改退票记录
     */
    @PreAuthorize("@ss.hasPermi('aviation:refunds:edit')")
    @Log(title = "退票记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Refunds refunds)
    {
        return toAjax(refundsService.updateRefunds(refunds));
    }

    /**
     * 删除退票记录
     */
    @PreAuthorize("@ss.hasPermi('aviation:refunds:remove')")
    @Log(title = "退票记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{refundIds}")
    public AjaxResult remove(@PathVariable Long[] refundIds)
    {
        return toAjax(refundsService.deleteRefundsByRefundIds(refundIds));
    }
}
