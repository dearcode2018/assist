/**
  * @filename UserServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.bean.LoginBean;
import com.hua.bean.common.ResultBean;
import com.hua.dao.UserDao;
import com.hua.entity.User;
import com.hua.service.UserService;

 /**
 * @type UserServiceImpl
 * @description 用户-服务
 * @author qianye.zheng
 */
@Service
public class UserServiceImpl extends CoreServiceImpl implements
		UserService
{
	@Resource
	private UserDao userDao;

	/**
	 * 
	 * @description 登录
	 * @param loginBean
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean login(final LoginBean loginBean)
	{
		User user = userDao.getByUsername(loginBean.getUsername());
		
		return null;
	}
	
	/**
	 * 
	 * @description 注销
	 * @param loginBean
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean logout(final LoginBean loginBean)
	{
		String username = loginBean.getUsername();
		
		return null;
	}
	
}
