/**
  * @filename ResourceController.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hua.service.ResourceService;

 /**
 * @type ResourceController
 * @description 资源-控制器
 * @author qianye.zheng
 */
@Controller(value = "/resource")
public class ResourceController extends BaseController
{
	@Resource
	private ResourceService resourceService;
	
	/**
	 * 
	 * @description 加载 图片资源
	 * @param request
	 * @param response
	 * @param path1
	 * @param path2
	 * @param filename
	 * @return
	 * @author qianye.zheng
	 */
	@RequestMapping("/{path1}/{path2}/{filename:\\S+\\.?\\S*}")
	public void loadImage(final HttpServletRequest request, final HttpServletResponse response, 
			final @PathVariable("path1") String path1, 
			final @PathVariable("path2") String path2, 
			final @PathVariable("filename") String filename)
	{
		
	}
}
