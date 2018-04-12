/**
  * @filename LoginController.java
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hua.bean.LoginBean;
import com.hua.bean.common.ResultBean;
import com.hua.service.UserService;

 /**
 * @type LoginController
 * @description 登录/注销-控制器
 * @author qianye.zheng
 */
@Controller(value = "/api/login")
public class LoginController extends BaseController
{

	@Resource
	private UserService userService;
	
	/**
	 * 
	 * @description 登录
	 * @param request
	 * @param response
	 * @param loginBean
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResultBean login(final HttpServletRequest request, final HttpServletResponse response, 
			final LoginBean loginBean)
	{
		return null;
	}
	
	/**
	 * 
	 * @description 注销
	 * @param request
	 * @param response
	 * @param loginBean
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public ResultBean logout(final HttpServletRequest request, final HttpServletResponse response, 
			final LoginBean loginBean)
	{
		return null;
	}
}
