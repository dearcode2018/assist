/**
  * @filename AccountDaoImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hua.bean.AccountSearchBean;
import com.hua.bean.common.Pager;
import com.hua.dao.AccountDao;
import com.hua.entity.Account;
import com.hua.entity.Dict;
import com.hua.util.SqlUtil;
import com.hua.util.StringUtil;

 /**
 * @type AccountDaoImpl
 * @description 
 * @author qianye.zheng
 */
@Repository
public class AccountDaoImpl extends CoreDaoImpl<Account> implements
		AccountDao
{

	/**
	 * 
	 * @description 更新
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int update(final Account entity)
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
				if (StringUtil.isNotEmpty(entity.getLevel()))
				{
					jpql.append(", a.level = :level ");
				}
				if (StringUtil.isNotEmpty(entity.getType()))
				{
					jpql.append(", a.type = :type ");
				}
				if (StringUtil.isNotEmpty(entity.getSource()))
				{
					jpql.append(", a.source = :source ");
				}
				if (StringUtil.isNotEmpty(entity.getUsage()))
				{
					jpql.append(", a.usage = :usage ");
				}
				if (StringUtil.isNotEmpty(entity.getRelationalAccounts()))
				{
					jpql.append(", a.relationalAccounts = :relationalAccounts ");
				}
				if (null != entity.getExpireDate())
				{
					jpql.append(", a.expireDate = :expireDate ");
				}
				if (StringUtil.isNotEmpty(entity.getMobilePhone()))
				{
					jpql.append(", a.mobilePhone = :mobilePhone ");
				}
				if (StringUtil.isNotEmpty(entity.getOfficialLink()))
				{
					jpql.append(", a.officialLink = :officialLink ");
				}
				if (StringUtil.isNotEmpty(entity.getLoginLink()))
				{
					jpql.append(", a.loginLink = :loginLink ");
				}
				if (StringUtil.isNotEmpty(entity.getLocation()))
				{
					jpql.append(", a.location = :location ");
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
				if (StringUtil.isNotEmpty(entity.getLevel()))
				{
					query.setParameter("level", entity.getLevel());
				}
				if (StringUtil.isNotEmpty(entity.getType()))
				{
					query.setParameter("type", entity.getType());
				}
				if (StringUtil.isNotEmpty(entity.getSource()))
				{
					query.setParameter("source", entity.getSource());
				}
				if (StringUtil.isNotEmpty(entity.getUsage()))
				{
					query.setParameter("usage", entity.getUsage());
				}
				if (StringUtil.isNotEmpty(entity.getRelationalAccounts()))
				{
					query.setParameter("relationalAccounts", entity.getRelationalAccounts());
				}
				if (null != entity.getExpireDate())
				{
					query.setParameter("expireDate", entity.getExpireDate());
				}
				if (StringUtil.isNotEmpty(entity.getMobilePhone()))
				{
					query.setParameter("mobilePhone", entity.getMobilePhone());
				}
				if (StringUtil.isNotEmpty(entity.getOfficialLink()))
				{
					query.setParameter("officialLink", entity.getOfficialLink());
				}
				if (StringUtil.isNotEmpty(entity.getLoginLink()))
				{
					query.setParameter("loginLink", entity.getLoginLink());
				}
				if (StringUtil.isNotEmpty(entity.getLocation()))
				{
					query.setParameter("location", entity.getLocation());
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
	 * @description 列表搜索
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Pager<Account> search(Pager<Account> pager,
			AccountSearchBean searchBean)
	{
		StringBuilder sql = StringUtil.getBuilder();
/*		sql.append("select a.id, a.username, a.status, a.level, a.type, a.source, a.expireDate, "
				+ "a.createDateTime, a.updateDateTime from t_account as a ");*/
		sql.append(" from t_account as a ");
		sql.append(" where 1 = 1 ");
		if (StringUtil.isNotEmpty(searchBean.getUsername()))
		{
			sql.append(" and a.username like :username ");
		}
		if (StringUtil.isNotEmpty(searchBean.getSource()))
		{
			sql.append(" and a.source like :source ");
		}
		if (null != searchBean.getStatus())
		{
			sql.append(" and a.status = :status ");
		}
		if (StringUtil.isNotEmpty(searchBean.getLevel()))
		{
			sql.append(" and a.level = :level ");
		}
		if (StringUtil.isNotEmpty(searchBean.getType()))
		{
			sql.append(" and a.type = type ");
		}
		
		final Query query = getEntityManager().createQuery(sql.toString());
		// 是否要分页
		if (pager.getNeedPage())
		{
			query.setFirstResult(pager.getOffset());
			query.setMaxResults(pager.getPageSize());
		}
		if (StringUtil.isNotEmpty(searchBean.getUsername()))
		{
			query.setParameter("username", SqlUtil.likeQuery(searchBean.getUsername(), true, true));
		}
		if (StringUtil.isNotEmpty(searchBean.getSource()))
		{
			query.setParameter("source", SqlUtil.likeQuery(searchBean.getSource(), true, true));
		}
		if (null != searchBean.getStatus())
		{
			query.setParameter("status", searchBean.getStatus());
		}
		if (StringUtil.isNotEmpty(searchBean.getLevel()))
		{
			query.setParameter("level", searchBean.getLevel());
		}
		if (StringUtil.isNotEmpty(searchBean.getType()))
		{
			query.setParameter("type", searchBean.getType());
		}
		@SuppressWarnings({"unchecked"})
		List<Account> dataList = query.getResultList();
		pager.setBeanList(dataList);
		
		StringBuilder countJpql = StringUtil.getBuilder();
		countJpql.append("select count(*) from t_account as a ");
		countJpql.append(" where 1 = 1 ");
		if (StringUtil.isNotEmpty(searchBean.getUsername()))
		{
			countJpql.append(" and a.username like :username ");
		}
		if (StringUtil.isNotEmpty(searchBean.getSource()))
		{
			countJpql.append(" and a.source like :source ");
		}
		if (null != searchBean.getStatus())
		{
			countJpql.append(" and a.status = :status ");
		}
		if (StringUtil.isNotEmpty(searchBean.getLevel()))
		{
			countJpql.append(" and a.level = :level ");
		}
		if (StringUtil.isNotEmpty(searchBean.getType()))
		{
			countJpql.append(" and a.type = type ");
		}		
		// 统计总记录数
		final Query countQuery = getEntityManager().createQuery(countJpql.toString());
		if (StringUtil.isNotEmpty(searchBean.getUsername()))
		{
			countQuery.setParameter("username", SqlUtil.likeQuery(searchBean.getUsername(), true, true));
		}
		if (StringUtil.isNotEmpty(searchBean.getSource()))
		{
			countQuery.setParameter("source", SqlUtil.likeQuery(searchBean.getSource(), true, true));
		}
		if (null != searchBean.getStatus())
		{
			countQuery.setParameter("status", searchBean.getStatus());
		}
		if (StringUtil.isNotEmpty(searchBean.getLevel()))
		{
			countQuery.setParameter("level", searchBean.getLevel());
		}
		if (StringUtil.isNotEmpty(searchBean.getType()))
		{
			countQuery.setParameter("type", searchBean.getType());
		}
		pager.setDataSize((Long) countQuery.getSingleResult());
		
		return pager;
	}
	
	/**
	 * @description 列表搜索
	 * @param pager
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public List<Account> searchAll()
	{
		final StringBuilder sql = StringUtil.getBuilder();
		sql.append(" from " + Account.class.getName() + " as a ");
		sql.append(" where a.status = 1");
		// 按照来源升序排序
		sql.append(" order by a.source asc ");
		final Query query = getEntityManager().createQuery(sql.toString());
		@SuppressWarnings({"unchecked"})
		final List<Account> dataList = query.getResultList();
		
		return dataList;
	}	
	
	
}
