/**
  * @filename SearchBean.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean.common;

import com.hua.constant.AccountConstant;

 /**
 * @type SearchBean
 * @description  
 * @author qianye.zheng
 */
public abstract class SearchBean
{

	/* 状态: 有效-1，无效-0 */
	private Integer status = AccountConstant.STATUS_VALID;

	/**
	 * @return the status
	 */
	public Integer getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	
}
