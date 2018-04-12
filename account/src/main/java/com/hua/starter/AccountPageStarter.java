/**
 * 描述: 
 * AccountPageStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.util.FileUtil;
import org.junit.Test;

import com.hua.bean.AccountPublishPage;
import com.hua.dao.AccountDao;
import com.hua.test.BaseDaoTest;
import com.hua.util.MarkerUtil;
import com.hua.util.ProjectUtil;

/**
 * 描述: 启动器
 * @author  qye.zheng
 * 
 * AccountPageStarter
 */
public class AccountPageStarter extends BaseDaoTest
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
		AccountPublishPage page = new AccountPublishPage();
		page.setRecords(accountDao.searchAll());
		page.setTotalRecord(page.getRecords().size());
		page.setUpdateDt(new Date());
		
		final Map<String, AccountPublishPage> dataMap = new HashMap<String, AccountPublishPage>();
		dataMap.put("data", page);
		// 注意要加上
		String content = MarkerUtil.getTemplateContent("account.ftl", dataMap);
		
		File file = new File(ProjectUtil.getAbsolutePath("/doc/html/account.html", true));
		FileUtil.writeAsString(file, content);
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}

}
