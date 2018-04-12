/**
  * @filename ResourceDao.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.dao;

import java.util.List;

import com.hua.entity.Resource;

 /**
 * @type ResourceDao
 * @description 
 * @author qianye.zheng
 */
public interface ResourceDao extends CoreDao<Resource>
{

	/**
	 * 
	 * @description 获取所属id的所有资源
	 * @param ownerId
	 * @return
	 * @author qianye.zheng
	 */
	public List<Resource> list(final Integer ownerId);
}
