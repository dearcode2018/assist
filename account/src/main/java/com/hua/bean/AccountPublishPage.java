/**
  * @filename AccountPublishPage.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hua.entity.Account;
import com.hua.serializer.DateSerializer;

 /**
 * @type AccountPublishPage
 * @description  
 * @author qianye.zheng
 */
public final class AccountPublishPage
{
	
	/* 记录集合 */
	private List<Account> records;
	
	/* 总记录数 */
	private Integer totalRecord;
	
	private Date updateDt;

	/**
	 * @return the records
	 */
	public final List<Account> getRecords()
	{
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public final void setRecords(List<Account> records)
	{
		this.records = records;
	}

	/**
	 * @return the totalRecord
	 */
	public final Integer getTotalRecord()
	{
		return totalRecord;
	}

	/**
	 * @param totalRecord the totalRecord to set
	 */
	public final void setTotalRecord(Integer totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the updateDt
	 */
	 @JsonSerialize(using = DateSerializer.class)
	public final Date getUpdateDt()
	{
		return updateDt;
	}

	/**
	 * @param updateDt the updateDt to set
	 */
	public final void setUpdateDt(Date updateDt)
	{
		this.updateDt = updateDt;
	}
	
	
}
