/**
* Pager.java
* 
* @author qye.zheng
* 	version 1.0
 */
package com.hua.bean.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述: 分页 Bean
 * @author qye.zheng
 * Pager
 */
public final class Pager<T> implements Serializable {
	
	private static final long serialVersionUID = 1000L;
	
	/* 页_大小 */
	private Integer pageSize = 20;
	
	/* 当前页 */
	private Integer currentPage = 0;
	
	/* 记录总条数 */
	private Long dataSize = 0L;
	
	/*  */
	private boolean needPage = true;
	
	/* 分页数据 */
	private List<T> beanList = new ArrayList<T>();

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage()
	{
		if (0 == currentPage && null != beanList)
		{
			currentPage = 1;
		}
		
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the dataSize
	 */
	public Long getDataSize() {
		return dataSize;
	}

	/**
	 * @param dataSize the dataSize to set
	 */
	public void setDataSize(Long dataSize) {
		this.dataSize = dataSize;
	}

	/**
	 * @return the needPage
	 */
	public boolean getNeedPage() {
		return needPage;
	}

	/**
	 * @param needPage the needPage to set
	 */
	public void setNeedPage(boolean needPage) {
		this.needPage = needPage;
	}

	/**
	 * @return the beanList
	 */
	public List<T> getBeanList() {
		return beanList;
	}

	/**
	 * @param beanList the beanList to set
	 */
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	/**
	 * 
	 * @description  Mysql式分页
	 * @return
	 * @author qianye.zheng
	 */
	public int getOffset()
	{
		if (currentPage == 0)
			return 0;
		return (currentPage - 1) * pageSize;
	}
	
	/**
	 * 
	 * @description Oralce式分页
	 * @return
	 * @author qianye.zheng
	 */
	public long getStartIndex()
	{
		long sindex = (currentPage - 1) * pageSize + 1;
		if (sindex < 0)
		{
			sindex = 0;
		}
		return sindex;
	}

	/**
	 * 
	 * @description  Oralce式分页
	 * @return
	 * @author qianye.zheng
	 */
	public long getEndIndex()
	{

		long end = currentPage * pageSize;
		if (end <= 0)
			return pageSize;
		else
			return end;
	}
	
}
