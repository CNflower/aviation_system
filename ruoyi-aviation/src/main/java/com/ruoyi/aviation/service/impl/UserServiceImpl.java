package com.ruoyi.aviation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.aviation.mapper.UserMapper;
import com.ruoyi.aviation.domain.User;
import com.ruoyi.aviation.service.IUserService;

/**
 * 乘客信息Service业务层处理
 * 
 * @author Sleeping
 * @date 2025-01-06
 */
@Service
public class UserServiceImpl implements IUserService 
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询乘客信息
     * 
     * @param userId 乘客信息主键
     * @return 乘客信息
     */
    @Override
    public User selectUserByUserId(Long userId)
    {
        return userMapper.selectUserByUserId(userId);
    }

    /**
     * 查询乘客信息列表
     * 
     * @param user 乘客信息
     * @return 乘客信息
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增乘客信息
     * 
     * @param user 乘客信息
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        return userMapper.insertUser(user);
    }

    /**
     * 修改乘客信息
     * 
     * @param user 乘客信息
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除乘客信息
     * 
     * @param userIds 需要删除的乘客信息主键
     * @return 结果
     */
    @Override
    public int deleteUserByUserIds(Long[] userIds)
    {
        return userMapper.deleteUserByUserIds(userIds);
    }

    /**
     * 删除乘客信息信息
     * 
     * @param userId 乘客信息主键
     * @return 结果
     */
    @Override
    public int deleteUserByUserId(Long userId)
    {
        return userMapper.deleteUserByUserId(userId);
    }
}
