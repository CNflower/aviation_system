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
import com.ruoyi.aviation.domain.TicketPrices;
import com.ruoyi.aviation.service.ITicketPricesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 机票价格Controller
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@RestController
@RequestMapping("/aviation/prices")
public class TicketPricesController extends BaseController
{
    @Autowired
    private ITicketPricesService ticketPricesService;

    /**
     * 查询机票价格列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:prices:list')")
    @GetMapping("/list")
    public TableDataInfo list(TicketPrices ticketPrices)
    {
        startPage();
        List<TicketPrices> list = ticketPricesService.selectTicketPricesList(ticketPrices);
        return getDataTable(list);
    }

    /**
     * 导出机票价格列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:prices:export')")
    @Log(title = "机票价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TicketPrices ticketPrices)
    {
        List<TicketPrices> list = ticketPricesService.selectTicketPricesList(ticketPrices);
        ExcelUtil<TicketPrices> util = new ExcelUtil<TicketPrices>(TicketPrices.class);
        util.exportExcel(response, list, "机票价格数据");
    }

    /**
     * 获取机票价格详细信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:prices:query')")
    @GetMapping(value = "/{priceId}")
    public AjaxResult getInfo(@PathVariable("priceId") Long priceId)
    {
        return success(ticketPricesService.selectTicketPricesByPriceId(priceId));
    }

    /**
     * 新增机票价格
     */
    @PreAuthorize("@ss.hasPermi('aviation:prices:add')")
    @Log(title = "机票价格", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketPrices ticketPrices)
    {
        return toAjax(ticketPricesService.insertTicketPrices(ticketPrices));
    }

    /**
     * 修改机票价格
     */
    @PreAuthorize("@ss.hasPermi('aviation:prices:edit')")
    @Log(title = "机票价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketPrices ticketPrices)
    {
        return toAjax(ticketPricesService.updateTicketPrices(ticketPrices));
    }

    /**
     * 删除机票价格
     */
    @PreAuthorize("@ss.hasPermi('aviation:prices:remove')")
    @Log(title = "机票价格", businessType = BusinessType.DELETE)
	@DeleteMapping("/{priceIds}")
    public AjaxResult remove(@PathVariable Long[] priceIds)
    {
        return toAjax(ticketPricesService.deleteTicketPricesByPriceIds(priceIds));
    }
}
