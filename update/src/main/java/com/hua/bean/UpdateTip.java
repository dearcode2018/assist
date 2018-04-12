/**
 * UpdateTip.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean;

import java.sql.Date;

/**
 * UpdateTip
 * 描述: 更新完成 - 提示信息
 * @author  qye.zheng
 */
public final class UpdateTip
{
	/* 项目类型，例如 java / web / javascript / perl ... */
	private String type;
	
	/* 更新数量 */
	private int updateCount;
	
	/* 新增数量 */
	private int newCount;
	
	/* 更新日期 */
	private Date date;
	
	/* 消耗时间 单位: 毫秒 */
	private int timeConsume;
	
	/* 备注信息 */
	private String remark;
	
	private long start;
	
	private long over;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public UpdateTip()
	{
	}

	/**
	 * @return the count
	 */
	public int getUpdateCount()
	{
		return updateCount;
	}

	/**
	 * @param count the count to set
	 */
	public void updateIncrease()
	{
		this.updateCount++;
	}

	/**
	 * @return the newCount
	 */
	public final int getNewCount()
	{
		return newCount;
	}

	/**
	 * @param count the count to set
	 */
	public void newIncrease()
	{
		this.newCount++;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
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
	 * 根据起止时间，计算消耗的时间 (毫秒数)
	 * @return the timeConsume
	 */
	public int getTimeConsume()
	{
		timeConsume = (int) (over - start);
		
		return timeConsume;
	}
	
	/**
	 * 
	 * 描述: 开始更新
	 * @author  qye.zheng
	 */
	public void start()
	{
		start = System.currentTimeMillis();
	}
	
	
	/**
	 * 
	 * 描述: 结束更新
	 * @author  qye.zheng
	 */
	public void over()
	{
		over = System.currentTimeMillis();
	}

	/**
	 * @return the type
	 */
	public final String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type)
	{
		this.type = type;
	}

}
