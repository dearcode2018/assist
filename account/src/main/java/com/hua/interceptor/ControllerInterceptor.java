/**
  * @filename ControllerInterceptor.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

 /**
 * @type ControllerInterceptor
 * @description 控制器-拦截器
 * @author qianye.zheng
 */
public class ControllerInterceptor implements HandlerInterceptor
{

	/**
	 * @description 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception
	{
		return false;
	}

	/**
	 * @description 
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{
	}

	/**
	 * @description 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @author qianye.zheng
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
	}

}
