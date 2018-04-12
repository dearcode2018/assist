/**
 * 描述: 
 * QueryAccountStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import javax.annotation.Resource;

import org.junit.Test;

import com.hua.dao.AccountDao;
import com.hua.entity.Account;
import com.hua.test.BaseDaoTest;

/**
 * 描述: 查询帐户 - 启动器
 * @author  qye.zheng
 * 
 * QueryAccountStarter
 */
public class QueryAccountStarter extends BaseDaoTest
{

	@Resource
	private AccountDao accountDao;
	

	// 启动器模板
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void startQueryPwd()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		Integer id = 1;
		Account entity = accountDao.get(id);
		
		System.out.println(entity.toString());
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}	

}
