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
import com.ruoyi.aviation.domain.TransitFlights;
import com.ruoyi.aviation.service.ITransitFlightsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 中转航班信息Controller
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@RestController
@RequestMapping("/aviation/transit_flights")
public class TransitFlightsController extends BaseController
{
    @Autowired
    private ITransitFlightsService transitFlightsService;

    /**
     * 查询中转航班信息列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:transit_flights:list')")
    @GetMapping("/list")
    public TableDataInfo list(TransitFlights transitFlights)
    {
        startPage();
        List<TransitFlights> list = transitFlightsService.selectTransitFlightsList(transitFlights);
        return getDataTable(list);
    }

    /**
     * 导出中转航班信息列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:transit_flights:export')")
    @Log(title = "中转航班信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TransitFlights transitFlights)
    {
        List<TransitFlights> list = transitFlightsService.selectTransitFlightsList(transitFlights);
        ExcelUtil<TransitFlights> util = new ExcelUtil<TransitFlights>(TransitFlights.class);
        util.exportExcel(response, list, "中转航班信息数据");
    }

    /**
     * 获取中转航班信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:transit_flights:query')")
    @GetMapping(value = "/{transitId}")
    public AjaxResult getInfo(@PathVariable("transitId") Long transitId)
    {
        return success(transitFlightsService.selectTransitFlightsByTransitId(transitId));
    }

    /**
     * 新增中转航班信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:transit_flights:add')")
    @Log(title = "中转航班信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TransitFlights transitFlights)
    {
        return toAjax(transitFlightsService.insertTransitFlights(transitFlights));
    }

    /**
     * 修改中转航班信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:transit_flights:edit')")
    @Log(title = "中转航班信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TransitFlights transitFlights)
    {
        return toAjax(transitFlightsService.updateTransitFlights(transitFlights));
    }

    /**
     * 删除中转航班信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:transit_flights:remove')")
    @Log(title = "中转航班信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transitIds}")
    public AjaxResult remove(@PathVariable Long[] transitIds)
    {
        return toAjax(transitFlightsService.deleteTransitFlightsByTransitIds(transitIds));
    }
}
