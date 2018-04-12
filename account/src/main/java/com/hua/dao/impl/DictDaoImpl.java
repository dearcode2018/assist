/**
  * @filename DictDaoImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hua.bean.DictItem;
import com.hua.bean.common.Pager;
import com.hua.dao.DictDao;
import com.hua.entity.Dict;
import com.hua.util.StringUtil;

 /**
 * @type DictDaoImpl
 * @description 
 * @author qianye.zheng
 */
@Repository
public class DictDaoImpl extends CoreDaoImpl<Dict> implements DictDao
{

	/**
	 * 
	 * @description 更新
	 * @param entity
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int update(final Dict entity)
	{
		int result = -1;
		try
		{
			if (null != entity)
			{
				StringBuilder jpql = StringUtil.getBuilder();
				jpql.append("update " + Dict.class.getName() + " as a set ");
				jpql.append(" a.id = :id ");
				if (StringUtil.isNotEmpty(entity.getCode()))
				{
					jpql.append(", a.code = :code ");
				}
				if (StringUtil.isNotEmpty(entity.getValue()))
				{
					jpql.append(", a.value = :value ");
				}
				if (StringUtil.isNotEmpty(entity.getText()))
				{
					jpql.append(", a.text = :text ");
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
				if (StringUtil.isNotEmpty(entity.getCode()))
				{
					query.setParameter("code", entity.getCode());
				}
				if (StringUtil.isNotEmpty(entity.getValue()))
				{
					query.setParameter("value", entity.getValue());
				}
				if (StringUtil.isNotEmpty(entity.getText()))
				{
					query.setParameter("text", entity.getText());
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
	 * 
	 * @description 分页搜索
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Pager<DictItem> search(final Pager<DictItem> pager, final DictItem searchBean)
	{
		String sql = "select a.id, a.status, a.code, a.value, a.text from t_dict as a ";
		sql += " where 1= 1 ";
		sql += " and a.code = :code ";
		sql += " and a.status = :status ";
		final Query query = getEntityManager().createNativeQuery(sql);
		query.setParameter("code", searchBean.getCode());
		query.setParameter("status", searchBean.getStatus());
		// 是否要分页
		if (pager.getNeedPage())
		{
			query.setFirstResult(pager.getOffset());
			query.setMaxResults(pager.getPageSize());
		}
		@SuppressWarnings({"unchecked"})
		List<Object[]> dataList = query.getResultList();
		List<DictItem> items = new ArrayList<DictItem>(dataList.size());
		DictItem item = null;
		int i = 0;
		// 对象构造，类型转换
		for (Object[] obj : dataList)
		{
			i = 0;
			item = new DictItem();
			item.setId((Integer) obj[i++]);
			item.setStatus(((Byte) obj[i++]).intValue());
			item.setCode((String) obj[i++]);
			item.setValue((String) obj[i++]);
			item.setText((String) obj[i++]);
			items.add(item);
		}
		pager.setBeanList(items);
		// 统计总记录数
		String countJpql = "select count(*) from t_dict as a ";
		countJpql += " where 1= 1 ";
		countJpql += " and a.code = :code ";
		countJpql += " and a.status = :status ";
		final Query countQuery = getEntityManager().createQuery(countJpql);
		countQuery.setParameter("code", searchBean.getCode());
		countQuery.setParameter("status", searchBean.getStatus());
		pager.setDataSize((Long) countQuery.getSingleResult());
		
		return pager;
	}	
	
	/**
	 * 
	 * @description 分页搜索
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	public Pager<DictItem> searchBak(final Pager<DictItem> pager, final DictItem searchBean)
	{
		String jpql = "select a.id, a.status, a.code, a.value, a.text from " + Dict.class.getName() + " as a ";
		jpql += " where a.code = :code and a.status = :status ";
		final Query query = getEntityManager().createQuery(jpql);
		query.setParameter("code", searchBean.getCode());
		query.setParameter("status", searchBean.getStatus());
		// 是否要分页
		if (pager.getNeedPage())
		{
			query.setFirstResult(pager.getOffset());
			query.setMaxResults(pager.getPageSize());
		}
		List<Dict> dicts = query.getResultList();
		List<DictItem> dictItems = new ArrayList<DictItem>(dicts.size());
		DictItem dictItem = null;
		for (Dict dict : dicts)
		{
			dictItem = new DictItem();
			dictItem.setCode(dict.getCode());
			dictItem.setValue(dict.getValue());
			dictItem.setText(dict.getText());
			dictItems.add(dictItem);
		}
		pager.setBeanList(dictItems);
		// 统计总记录数
		String countJpql = "select count(*) from " + Dict.class.getName() + " as a ";
		countJpql += " where a.code = :code and a.status = :status ";
		final Query countQuery = getEntityManager().createQuery(countJpql);
		BigDecimal digDecimal = (BigDecimal) countQuery.getSingleResult();
		
		return pager;
	}	
}
