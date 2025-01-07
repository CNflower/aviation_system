package com.ruoyi.aviation.mapper;

import java.util.List;
import com.ruoyi.aviation.domain.User;

/**
 * 乘客信息Mapper接口
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public interface UserMapper 
{
    /**
     * 查询乘客信息
     * 
     * @param userId 乘客信息主键
     * @return 乘客信息
     */
    public User selectUserByUserId(Long userId);

    /**
     * 查询乘客信息列表
     * 
     * @param user 乘客信息
     * @return 乘客信息集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增乘客信息
     * 
     * @param user 乘客信息
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改乘客信息
     * 
     * @param user 乘客信息
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除乘客信息
     * 
     * @param userId 乘客信息主键
     * @return 结果
     */
    public int deleteUserByUserId(Long userId);

    /**
     * 批量删除乘客信息
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByUserIds(Long[] userIds);
}
