/**
 * BaseTag.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.jdk;

/**
 * BaseTag
 * 描述: 
 * @author  qye.zheng
 */
public class BaseTag
{

	private String id;
	
	private String name;
	
	private String value;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public BaseTag()
	{
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value)
	{
		this.value = value;
	}
	
}
