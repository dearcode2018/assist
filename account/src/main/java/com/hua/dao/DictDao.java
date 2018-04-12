/**
  * @filename DictDao.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao;

import com.hua.bean.DictItem;
import com.hua.bean.common.Pager;
import com.hua.entity.Dict;

 /**
 * @type DictDao
 * @description 
 * @author qianye.zheng
 */
public interface DictDao extends CoreDao<Dict>
{
	
	/**
	 * 
	 * @description 列表搜索
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	public Pager<DictItem> search(final Pager<DictItem> pager, final DictItem searchBean);

}
