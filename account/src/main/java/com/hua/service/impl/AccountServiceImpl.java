/**
 * AccountServiceImpl.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.service.impl;

import java.io.OutputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.bean.AccountSearchBean;
import com.hua.bean.common.Pager;
import com.hua.bean.common.ResultBean;
import com.hua.dao.AccountDao;
import com.hua.dao.DictDao;
import com.hua.dao.ResourceDao;
import com.hua.entity.Account;
import com.hua.service.AccountService;

/**
 * AccountServiceImpl
 * 描述: ACCOUNT - 服务
 * @author  qye.zheng
 */
@Service
public class AccountServiceImpl extends CoreServiceImpl implements
		AccountService
{

	@Resource
	private DictDao dictDao;
	
	@Resource
	private ResourceDao resourceDao;
	
	@Resource
	private AccountDao accountDao;
	
	/**
	 * 
	 * @description 新增帐户
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean add(final Account account)
	{
		final ResultBean resultBean = new ResultBean();
		int result = accountDao.insert(account);
		if (result > 0)
		{
			resultBean.setMessage("操作成功");
		} else
		{
			resultBean.setMessage("操作失败");
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 删除帐户
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean delete(final Integer id)
	{
		final ResultBean resultBean = new ResultBean();
		int result = accountDao.delete(id);
		if (result > 0)
		{
			resultBean.setMessage("操作成功");
		} else
		{
			resultBean.setMessage("操作失败");
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 更新帐户
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean update(final Account account)
	{
		final ResultBean resultBean = new ResultBean();
		int result = accountDao.update(account);
		if (result > 0)
		{
			resultBean.setMessage("操作成功");
		} else
		{
			resultBean.setMessage("操作失败");
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 修改帐户密码
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean modifyPwd(final Account account)
	{
		final ResultBean resultBean = new ResultBean();
		int result = accountDao.update(account);
		if (result > 0)
		{
			resultBean.setMessage("操作成功");
		} else
		{
			resultBean.setMessage("操作失败");
		}
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 查看帐户
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean view(final Integer id)
	{
		final ResultBean resultBean = new ResultBean();
		Account entity = accountDao.get(id);
		resultBean.setData(entity);
		
		return resultBean;
	}
	
	/**
	 * 
	 * @description 查看密码，生成图片流
	 * @param id
	 * @param outputStream
	 * @author qianye.zheng
	 */
	@Override
	public void viewPwd(final Integer id, final OutputStream outputStream)
	{
		final ResultBean resultBean = new ResultBean();
		
	}
	
	/**
	 * 
	 * @description 搜索帐户
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean search(Pager<Account> pager, final AccountSearchBean searchBean)
	{
		final ResultBean resultBean = new ResultBean();
		pager = accountDao.search(pager, searchBean);
		resultBean.setData(pager);
		
		return resultBean;
	}
}
