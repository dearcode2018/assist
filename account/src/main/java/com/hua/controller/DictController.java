/**
  * @filename DictController.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.common.ResultBean;
import com.hua.service.DictService;

 /**
 * @type DictController
 * @description 数据字典-控制器
 * @author qianye.zheng
 */
@Controller(value = "/sys/dict")
public class DictController extends BaseController
{

	@Resource
	private DictService dictService;
	
	/**
	 * 
	 * @description 字典列表
	 * @param request
	 * @param response
	 * @param code
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/list")
	@ResponseBody
	public ResultBean list(final HttpServletRequest request, final HttpServletResponse response, 
			@RequestParam("code") final String code)
	{
		return null;
	}
}
