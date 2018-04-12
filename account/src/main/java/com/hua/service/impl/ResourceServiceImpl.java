/**
  * @filename ResourceServiceImpl.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

import com.hua.service.ResourceService;
import com.hua.util.IOUtil;
import com.hua.util.StringUtil;

 /**
 * @type ResourceServiceImpl
 * @description 资源-服务
 * @author qianye.zheng
 */
@Service
public class ResourceServiceImpl extends CoreServiceImpl implements
		ResourceService
{

	/**
	 * 
	 * @description 加载 图片资源
	 * @param path 文件路径
	 * @param outputStream
	 * @author qianye.zheng
	 */
	@Override
	public void loadImage(final String path, final OutputStream outputStream)
	{
		InputStream inputStream = null;
		try
		{
			if (StringUtil.isNotEmpty(path))
			{
				inputStream = new FileInputStream(path);
				IOUtil.transport(inputStream, outputStream);
			}
		} catch (Exception e)
		{
			log.error("loadImage =====> ", e);
		} finally
		{
			IOUtil.close(outputStream);
			IOUtil.close(inputStream);
		}
	}
}
