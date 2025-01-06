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
import com.ruoyi.aviation.domain.Flights;
import com.ruoyi.aviation.service.IFlightsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 航班信息Controller
 *
 * @author sleeping
 * @date 2025-01-06
 */
@RestController
@RequestMapping("/aviation/flights")
public class FlightsController extends BaseController
{ 
    @Autowired
    private IFlightsService flightsService;

    /**
     * 查询航班信息列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:flights:list')")
    @GetMapping("/list")
    public TableDataInfo list(Flights flights)
    {
        startPage();
        List<Flights> list = flightsService.selectFlightsList(flights);
        return getDataTable(list);
    }

    /**
     * 导出航班信息列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:flights:export')")
    @Log(title = "航班信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Flights flights)
    {
        List<Flights> list = flightsService.selectFlightsList(flights);
        ExcelUtil<Flights> util = new ExcelUtil<Flights>(Flights.class);
        util.exportExcel(response, list, "航班信息数据");
    }

    /**
     * 获取航班信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:flights:query')")
    @GetMapping(value = "/{flightId}")
    public AjaxResult getInfo(@PathVariable("flightId") Long flightId)
    {
        return success(flightsService.selectFlightsByFlightId(flightId));
    }

    /**
     * 新增航班信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:flights:add')")
    @Log(title = "航班信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Flights flights)
    {
        return toAjax(flightsService.insertFlights(flights));
    }

    /**
     * 修改航班信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:flights:edit')")
    @Log(title = "航班信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Flights flights)
    {
        return toAjax(flightsService.updateFlights(flights));
    }

    /**
     * 删除航班信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:flights:remove')")
    @Log(title = "航班信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{flightIds}")
    public AjaxResult remove(@PathVariable Long[] flightIds)
    {
        return toAjax(flightsService.deleteFlightsByFlightIds(flightIds));
    }
}
