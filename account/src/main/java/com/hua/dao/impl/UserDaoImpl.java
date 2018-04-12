/**
  * @filename UserDaoImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hua.dao.UserDao;
import com.hua.entity.Dict;
import com.hua.entity.User;
import com.hua.util.StringUtil;

 /**
 * @type UserDaoImpl
 * @description 
 * @author qianye.zheng
 */
@Repository
public class UserDaoImpl extends CoreDaoImpl<User> implements UserDao
{

	/**
	 * 
	 * @description 更新
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int update(final User entity)
	{
		int result = -1;
		try
		{
			if (null != entity)
			{
				StringBuilder jpql = StringUtil.getBuilder();
				jpql.append("update " + Dict.class.getName() + " as a set ");
				jpql.append(" a.id = :id ");
				if (StringUtil.isNotEmpty(entity.getUsername()))
				{
					jpql.append(", a.username = :username ");
				}
				if (null != entity.getStatus())
				{
					jpql.append(", a.status = :status ");
				}
				if (StringUtil.isNotEmpty(entity.getPassword()))
				{
					jpql.append(", a.password = :password ");
				}
				if (StringUtil.isNotEmpty(entity.getType()))
				{
					jpql.append(", a.type = :type ");
				}
				if (null != entity.getLocked())
				{
					jpql.append(", a.locked = :locked ");
				}
				if (null != entity.getLoginCount())
				{
					jpql.append(", a.loginCount = :loginCount ");
				}
				if (null != entity.getLastLoginDateTime())
				{
					jpql.append(", a.lastLoginDateTime = :lastLoginDateTime ");
				}
				if (StringUtil.isNotEmpty(entity.getRemark()))
				{
					jpql.append(", a.remark = :remark ");
				}
				jpql.append(" where a.id = :id");
				final Query query = getEntityManager().createQuery(jpql.toString());
				query.setParameter("id", entity.getId());
				if (StringUtil.isNotEmpty(entity.getUsername()))
				{
					query.setParameter("username", entity.getUsername());
				}
				if (null != entity.getStatus())
				{
					query.setParameter("status", entity.getStatus());
				}
				if (StringUtil.isNotEmpty(entity.getPassword()))
				{
					query.setParameter("password", entity.getPassword());
				}
				if (StringUtil.isNotEmpty(entity.getType()))
				{
					query.setParameter("type", entity.getType());
				}
				if (null != entity.getLocked())
				{
					query.setParameter("locked", entity.getLocked());
				}
				if (null != entity.getLoginCount())
				{
					query.setParameter("loginCount", entity.getLoginCount());
				}
				if (null != entity.getLastLoginDateTime())
				{
					query.setParameter("lastLoginDateTime", entity.getLastLoginDateTime());
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
	 * 
	 * @description 根据用户名获取用户对象
	 * @param username
	 * @return 用户对象
	 * @author qianye.zheng
	 */
	@Override
	public User getByUsername(final String username)
	{
		String jpql = "select a.id, a.name, a.title, a.path from "+ User.class.getName() +" as a ";
		jpql += " where a.username = :username";
		final Query query = getEntityManager().createNativeQuery(jpql, User.class);
		query.setParameter("username", username);
		User user = (User) query.getSingleResult();
		
		return user;
	}
}
