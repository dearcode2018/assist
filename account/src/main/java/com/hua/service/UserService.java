/**
  * @filename UserService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import com.hua.bean.LoginBean;
import com.hua.bean.common.ResultBean;

 /**
 * @type UserService
 * @description 用户-服务
 * @author qianye.zheng
 */
public interface UserService extends CoreService
{

	/**
	 * 
	 * @description 登录
	 * @param loginBean
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean login(final LoginBean loginBean);
	
	/**
	 * 
	 * @description 注销
	 * @param loginBean
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean logout(final LoginBean loginBean);
	
}
