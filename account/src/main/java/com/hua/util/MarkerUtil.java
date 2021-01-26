/**
 * MarkerUtil.java
 * @author  zhengqy
 * @date  2014年4月15日
 * 	version 1.0
 */
package com.hua.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import com.hua.constant.Constant;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.Version;

/**
 * MarkerUtil
 * 描述: 
 * @author  zhengqy
 * @date  2014年4月15日
 */
public final class MarkerUtil 
{
	
	/* ftl : */
	public static final String PATH = "/conf/ftl";
	
	public static Configuration config;
	
	// 模板对象
	public static Template template;
	
	// 创建 Configuration 对象
	static {
		// 2.3.x以上，当前使用的freemarker版本
		final Version version = new Version("2.3.23");
		final File file = new File(ClassPathUtil.getClassPath(PATH));
		config = new Configuration(version);
		// 设置默认编码 (至关重要 - 解决中文乱码问题)
		config.setDefaultEncoding(Constant.CHART_SET_UTF_8);
		// 对象包装器
		final ObjectWrapper objectWrapper = new DefaultObjectWrapper(version);
		try {
			// 设置模板的目录
			config.setDirectoryForTemplateLoading(file);
			// 设置对象包装器
			config.setObjectWrapper(objectWrapper);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author zhengqy
	 * @date	2014-4-15
	 */
	private MarkerUtil() {}
	
	/**
	 * 
	 * 描述: 获取ftl模板的内容
	 * @author  zhengqy
	 * @date  2014年4月16日
	 * @param filename
	 * @param data
	 * @return
	 */
	public static <T> String getTemplateContent(final String filename, final Map<String, T> dataMap) 
	{
		// 返回结果
		String result = null;
		try
		{
			// 从模板目录下获取指定 ftl 模板文件
			template = config.getTemplate(filename);
			// 设置文件编码
			//template.setEncoding(Constant.CHART_SET_UTF_8);
			// 字符串 字符输出流
			final StringWriter stringWriter = new StringWriter();
			final BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
			// 合并 数据模型 与 模板
			template.process(dataMap, bufferedWriter);
			
			// 获取输出的字符串 (调用其 toString方法)
			result = stringWriter.toString();
			// 刷新
			bufferedWriter.flush();
			// 关闭输出流
			bufferedWriter.close();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
