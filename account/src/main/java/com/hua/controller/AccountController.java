/**
  * @filename AccountController.java
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

import com.hua.bean.AccountList;
import com.hua.bean.AccountSearchBean;
import com.hua.bean.common.Pager;
import com.hua.bean.common.ResultBean;
import com.hua.entity.Account;
import com.hua.service.AccountService;

 /**
 * @type AccountController
 * @description 帐户-控制器
 * @author qianye.zheng
 */
@Controller(value = "/api/account")
public class AccountController extends BaseController
{
	@Resource
	private AccountService accountService;
	
	/**
	 * 
	 * @description 新增帐户
	 * @param request
	 * @param response
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultBean add(final HttpServletRequest request, final HttpServletResponse response, 
			final Account account)
	{
		return null;
	}
	
	/**
	 * 
	 * @description 删除帐户
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ResultBean delete(final HttpServletRequest request, final HttpServletResponse response, 
			@RequestParam("id") final Integer id)
	{
		return null;
	}
	
	/**
	 * 
	 * @description 更新帐户
	 * @param request
	 * @param response
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultBean update(final HttpServletRequest request, final HttpServletResponse response, 
			final Account account)
	{
		return null;
	}	
	
	/**
	 * 
	 * @description 修改帐户密码
	 * @param request
	 * @param response
	 * @param account
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/modifyPwd")
	@ResponseBody
	public ResultBean modifyPwd(final HttpServletRequest request, final HttpServletResponse response, 
			final Account account)
	{
		return null;
	}		
	
	/**
	 * 
	 * @description 查看帐户
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/view")
	@ResponseBody
	public ResultBean view(final HttpServletRequest request, final HttpServletResponse response, 
			@RequestParam("id") final Integer id)
	{
		return null;
	}		
	
	/**
	 * 
	 * @description 查看密码，生成图片流
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/viewPwd")
	public void viewPwd(final HttpServletRequest request, final HttpServletResponse response, 
			@RequestParam("id") final Integer id)
	{
	
	}	
	
	/**
	 * 
	 * @description 搜索帐户
	 * @param request
	 * @param response
	 * @param pager
	 * @param searchBean
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/search")
	@ResponseBody
	public ResultBean search(final HttpServletRequest request, final HttpServletResponse response, 
			final Pager<AccountList> pager, final AccountSearchBean searchBean)
	{
		return null;
	}	
}
