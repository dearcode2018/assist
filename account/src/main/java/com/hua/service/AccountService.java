/**
 * AccountService.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.service;

import java.io.OutputStream;

import com.hua.bean.AccountSearchBean;
import com.hua.bean.common.Pager;
import com.hua.bean.common.ResultBean;
import com.hua.entity.Account;

/**
 * AccountService
 * 描述: ACCOUNT - 服务
 * @author  qye.zheng
 */
public interface AccountService extends CoreService
{

	/**
	 * 
	 * @description 新增帐户
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean add(final Account account);
	
	/**
	 * 
	 * @description 删除帐户
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean delete(final Integer id);
	
	/**
	 * 
	 * @description 更新帐户
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean update(final Account account);
	
	/**
	 * 
	 * @description 修改帐户密码
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean modifyPwd(final Account account);
	
	/**
	 * 
	 * @description 查看帐户
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean view(final Integer id);
	
	/**
	 * 
	 * @description 查看密码，生成图片流
	 * @param id
	 * @param outputStream
	 * @author qianye.zheng
	 */
	public void viewPwd( final Integer id, final OutputStream outputStream);
	
	/**
	 * 
	 * @description 搜索帐户
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean search(final Pager<Account> pager, final AccountSearchBean searchBean);
}
