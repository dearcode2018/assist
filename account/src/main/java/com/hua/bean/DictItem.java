/**
  * @filename DictItem.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.bean;

import com.hua.bean.common.BaseBean;

 /**
 * @type DictItem
 * @description 
 * @author qianye.zheng
 */
public final class DictItem extends BaseBean
{
	private static final long serialVersionUID = 1L;

	/* 编码-划分模块 */
	private String code;
	
	/* 值 */
	private String value;
	
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
	
}
