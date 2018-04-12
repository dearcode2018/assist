/**
  * @filename Dict.java
  * @description 数据字典
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.hua.constant.AccountConstant;

 /**
 * @type Dict
 * @description 数据字典
 * @author qianye.zheng
 */
@Entity(name = "t_dict")
//@Table(name = "t_dict")
public class Dict
{
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", insertable = true, 
			updatable = false,
			nullable = false, unique = true)
	@Id
	/* 对象唯一id，使用自增长 */
	private Integer id;

	@Column(name = "status", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 状态: 有效-1，无效-0 */
	private Integer status = AccountConstant.STATUS_VALID;
	
	@Column(name = "remark", insertable = true, 
			updatable = true, length = 1024, 
			nullable = true, unique = false)
	/* 备注 */
	private String remark;
	
	@Column(name = "createDateTime", insertable = true, 
			updatable = false,
			nullable = true, unique = false)
	/* 创建时间 */
	private Date createDateTime;
	
	@Column(name = "updateDateTime", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 更新时间 */
	private Date updateDateTime;
	
	@Column(name = "code", insertable = true, 
			updatable = true, length = 64, 
			nullable = true, unique = false)
	/* 编码-划分模块 */
	private String code;
	
	@Column(name = "value", insertable = true, 
			updatable = true, length = 12, 
			nullable = true, unique = false)
	/* 值 */
	private String value;
	
	@Column(name = "text", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 显示名称(中/英文) */
	private String text;

	/**
	 * @return the code
	 */
	public final String getCode()
	{
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public final void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * @return the value
	 */
	public final String getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public final void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * @return the text
	 */
	public final String getText()
	{
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public final void setText(String text)
	{
		this.text = text;
	}
	
	/**
	 * @return the id
	 */
	public final Integer getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public final Integer getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(Integer status)
	{
		this.status = status;
	}

	/**
	 * @return the remark
	 */
	public String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * @return the createDateTime
	 */
	public final Date getCreateDateTime()
	{
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public final void setCreateDateTime(Date createDateTime)
	{
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the updateDateTime
	 */
	public final Date getUpdateDateTime()
	{
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public final void setUpdateDateTime(Date updateDateTime)
	{
		this.updateDateTime = updateDateTime;
	}	
	
}
