/**
 * 描述: 
 * CoreDao.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.hua.bean.common.Pager;
import com.hua.bean.common.SearchBean;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDao
 */
public interface CoreDao<T> {

	/**
	 * 
	 * @description 新增
	 * @param t
	 * @return
	 * @author qianye.zheng
	 */
	public int insert(final T t);

	/**
	 * 
	 * @description 删除
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	public int delete(final Integer id);
	
	/**
	 * 
	 * @description 更新
	 * @param t
	 * @return
	 * @author qianye.zheng
	 */
	public int update(final T t);
	
	/**
	 * 
	 * @description 查看
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	public T get(final Integer id);

	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public EntityManager getEntityManager();
	
	/**
	 * 
	 * @description 获取 SESSION
	 * @return
	 * @author qianye.zheng
	 */
	public Session getSession();
	
}
