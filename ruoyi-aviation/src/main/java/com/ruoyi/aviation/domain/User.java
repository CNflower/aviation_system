package com.ruoyi.aviation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 乘客信息对象 a_user
 * 
 * @author Sleeping
 * @date 2025-01-07
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 乘客ID */
    private Long userId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 身份 */
    @Excel(name = "身份")
    private String status;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 记录创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 记录更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("name", getName())
            .append("status", getStatus())
            .append("sex", getSex())
            .append("idCard", getIdCard())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
