/**
  * @filename DictService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import com.hua.bean.common.ResultBean;

 /**
 * @type DictService
 * @description 数据字典-服务
 * @author qianye.zheng
 */
public interface DictService extends CoreService
{

	/**
	 * 
	 * @description 字典列表
	 * @param code
	 * @return
	 * @author qianye.zheng
	 */
	public ResultBean list(final String code);
	
	
}
