/**
  * @filename ResourceDaoImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hua.dao.ResourceDao;
import com.hua.entity.Dict;
import com.hua.entity.Resource;
import com.hua.util.StringUtil;

 /**
 * @type ResourceDaoImpl
 * @description 
 * @author qianye.zheng
 */
@Repository
public class ResourceDaoImpl extends CoreDaoImpl<Resource> implements
		ResourceDao
{

	/**
	 * 
	 * @description 更新
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int update(final Resource entity)
	{
		int result = -1;
		try
		{
			if (null != entity)
			{
				StringBuilder jpql = StringUtil.getBuilder();
				jpql.append("update " + Dict.class.getName() + " as a set ");
				jpql.append(" a.id = :id ");
				if (StringUtil.isNotEmpty(entity.getName()))
				{
					jpql.append(", a.name = :name ");
				}
				if (StringUtil.isNotEmpty(entity.getType()))
				{
					jpql.append(", a.type = :type ");
				}
				if (null != entity.getOwnerId())
				{
					jpql.append(", a.ownerId = :ownerId ");
				}
				if (StringUtil.isNotEmpty(entity.getTitle()))
				{
					jpql.append(", a.title = :title ");
				}
				if (StringUtil.isNotEmpty(entity.getPath()))
				{
					jpql.append(", a.path = :path ");
				}
				if (null != entity.getStatus())
				{
					jpql.append(", a.status = :status ");
				}
				if (StringUtil.isNotEmpty(entity.getRemark()))
				{
					jpql.append(", a.remark = :remark ");
				}
				jpql.append(" where a.id = :id");
				final Query query = getEntityManager().createQuery(jpql.toString());
				query.setParameter("id", entity.getId());
				if (StringUtil.isNotEmpty(entity.getName()))
				{
					query.setParameter("name", entity.getName());
				}
				if (StringUtil.isNotEmpty(entity.getType()))
				{
					query.setParameter("type", entity.getType());
				}
				if (null != entity.getOwnerId())
				{
					query.setParameter("ownerId", entity.getOwnerId());
				}
				if (StringUtil.isNotEmpty(entity.getTitle()))
				{
					jpql.append(", a.title = :title ");
				}
				if (StringUtil.isNotEmpty(entity.getPath()))
				{
					query.setParameter("path", entity.getPath());
				}
				if (null != entity.getStatus())
				{
					query.setParameter("status", entity.getStatus());
				}
				if (StringUtil.isNotEmpty(entity.getRemark()))
				{
					query.setParameter("remark", entity.getRemark());
				}				
				// 执行 更新
				result = query.executeUpdate();
			}
		} catch (Exception e)
		{
			throw e;
		}
		
		return result;
	}

	/**
	 * @description 获取所属id的所有资源
	 * @param ownerId
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public List<Resource> list(Integer ownerId)
	{
		String sql = "select a.id, a.name, a.title, a.path from t_resource as a ";
		sql += " where a.ownerId = :ownerId and a.status = 1 ";
		final Query query = getEntityManager().createNativeQuery(sql);
		// 
		query.setParameter("ownerId", ownerId);
		@SuppressWarnings({"unchecked"})
		List<Object[]> dataList = query.getResultList();
		List<Resource> items = new ArrayList<Resource>(dataList.size());
		Resource item = null;
		int i = 0;
		// 对象构造，类型转换
		for (Object[] obj : dataList)
		{
			i = 0;
			item = new Resource();
			item.setId((Integer) obj[i++]);
			item.setName((String) obj[i++]);
			item.setTitle((String) obj[i++]);
			item.setPath((String) obj[i++]);
			items.add(item);
		}
		
		return items;
	}
}
