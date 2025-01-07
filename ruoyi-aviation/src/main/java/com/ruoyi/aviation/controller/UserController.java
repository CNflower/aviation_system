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
import com.ruoyi.aviation.domain.User;
import com.ruoyi.aviation.service.IUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 乘客信息Controller
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
@RestController
@RequestMapping("/aviation/user")
public class UserController extends BaseController
{
    @Autowired
    private IUserService userService;

    /**
     * 查询乘客信息列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(User user)
    {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 导出乘客信息列表
     */
    @PreAuthorize("@ss.hasPermi('aviation:user:export')")
    @Log(title = "乘客信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, User user)
    {
        List<User> list = userService.selectUserList(user);
        ExcelUtil<User> util = new ExcelUtil<User>(User.class);
        util.exportExcel(response, list, "乘客信息数据");
    }

    /**
     * 获取乘客信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(userService.selectUserByUserId(userId));
    }

    /**
     * 新增乘客信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:user:add')")
    @Log(title = "乘客信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody User user)
    {
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改乘客信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:user:edit')")
    @Log(title = "乘客信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }

    /**
     * 删除乘客信息
     */
    @PreAuthorize("@ss.hasPermi('aviation:user:remove')")
    @Log(title = "乘客信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(userService.deleteUserByUserIds(userIds));
    }
}
