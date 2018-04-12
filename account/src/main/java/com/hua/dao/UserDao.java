/**
  * @filename UserDao.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao;

import com.hua.entity.User;


 /**
 * @type UserDao
 * @description 
 * @author qianye.zheng
 */
public interface UserDao extends CoreDao<User>
{

	/**
	 * 
	 * @description 根据用户名获取用户对象
	 * @param username
	 * @return
	 * @author qianye.zheng
	 */
	public User getByUsername(final String username);
	
}
