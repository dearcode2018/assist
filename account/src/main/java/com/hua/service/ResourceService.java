/**
  * @filename ResourceService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import java.io.OutputStream;

 /**
 * @type ResourceService
 * @description 资源-服务
 * @author qianye.zheng
 */
public interface ResourceService extends CoreService
{

	/**
	 * 
	 * @description 加载 图片资源
	 * @param path 文件路径
	 * @param outputStream
	 * @author qianye.zheng
	 */
	public void loadImage(final String path, final OutputStream outputStream);
	
}
