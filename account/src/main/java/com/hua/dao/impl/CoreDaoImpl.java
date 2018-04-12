/**
 * 描述: 
 * CoreDaoImpl.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.hua.dao.CoreDao;
import com.hua.log.BaseLog;
import com.hua.util.ReflectUtil;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDaoImpl
 */
@Repository
public abstract class CoreDaoImpl<T> extends BaseLog implements CoreDao<T> {
	
	/* apache commons log */
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	/**
	 * 获取实体工厂管理对象
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 实体类类型(由构造方法自动赋值)
	 */
	private Class<T> entityClass;

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public CoreDaoImpl()
	{
		entityClass = (Class<T>) ReflectUtil.getClassGenricType(getClass());
	}

	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public final EntityManager getEntityManager()
	{
		return entityManager;
	}
	
	/**
	 * 
	 * @description 获取 SESSION
	 * @return
	 * @author qianye.zheng
	 */
	public Session getSession(){  
	  return (Session) getEntityManager().getDelegate();
	}

	/**
	 * 
	 * @description 清除緩存
	 * @author qianye.zheng
	 */
	public void clear(){  
		getSession().clear();
	}
	
	/**
	 * 
	 * @description 新增
	 * @param t
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int insert(final T t)
	{
		int result = -1;
		try
		{
			if (null != t)
			{
				entityManager.persist(t);
				
				return result;
			}
		} catch (Exception e)
		{
			throw e;
		}
		
		return result;
	}	

	/**
	 * 
	 * @description 删除
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int delete(final Integer id)
	{
		int result = -1;
		try
		{
			// 获取实体
			final T t = entityManager.find(entityClass, id);
			if (null != id)
			{
				entityManager.remove(t);
				
				return result;
			}
		} catch (Exception e)
		{
			throw e;
		}
		
		return result;
	}	
	
	/**
	 * 
	 * @description 更新
	 * @param t
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int update(final T t)
	{
		int result = -1;
		try
		{
			if (null != t)
			{ 
				/**
				 * 暂时无法解决，采用子类执行jpql的方式
				 * TODO 适应 JPA标准没有到位的情况，更新所有字段，
				 * 导致没有值的字段，将被清空，因此使用解决方法，
				 * 先查出所有字段，然后将非空的复制到 
				 */
				entityManager.merge(t);
				
				return result;
			}
		} catch (Exception e)
		{
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 
	 * @description 查看
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public T get(final Integer id)
	{
		final T t = entityManager.find(entityClass, id);
		
		return t;
	}
	
	
}
