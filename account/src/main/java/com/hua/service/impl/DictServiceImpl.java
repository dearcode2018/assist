/**
  * @filename DictServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hua.bean.DictItem;
import com.hua.bean.common.Pager;
import com.hua.bean.common.ResultBean;
import com.hua.dao.DictDao;
import com.hua.service.DictService;

 /**
 * @type DictServiceImpl
 * @description 数据字典-服务
 * @author qianye.zheng
 */
@Service
public class DictServiceImpl extends CoreServiceImpl implements
		DictService
{

	@Resource
	private DictDao dictDao;
	
	/**
	 * 
	 * @description 字典列表
	 * @param code
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public ResultBean list(final String code)
	{
		final ResultBean resultBean = new ResultBean();
		DictItem searchBean = new DictItem();
		searchBean.setCode(code);
		Pager<DictItem> pager = new Pager<DictItem>();
		pager.setCurrentPage(1);
		pager.setPageSize(2);
		pager.setNeedPage(true);
		pager = dictDao.search(pager, searchBean);
		resultBean.setData(pager);
		
		return resultBean;
	}
}
