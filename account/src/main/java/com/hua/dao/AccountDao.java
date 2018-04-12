/**
  * @filename AccountDao.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao;

import java.util.List;

import com.hua.bean.AccountSearchBean;
import com.hua.bean.common.Pager;
import com.hua.entity.Account;

 /**
 * @type AccountDao
 * @description 
 * @author qianye.zheng
 */
public interface AccountDao extends CoreDao<Account>
{

	/**
	 * 
	 * @description 列表搜索
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	public Pager<Account> search(final Pager<Account> pager, final AccountSearchBean searchBean);
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public List<Account> searchAll();
}
