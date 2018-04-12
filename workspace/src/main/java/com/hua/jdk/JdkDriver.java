/**
 * JdkDriver.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.jdk;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.hua.constant.Constant;
import com.hua.util.ProjectUtil;
import com.hua.util.ReadProperties;
import com.hua.util.StringUtil;
import com.hua.util.WriteProperties;

/**
 * JdkDriver
 * 描述: 
 * @author  qye.zheng
 */
public final class JdkDriver
{

	private static final String JDT_LAUNCHING_CONFIG_LOCATION = 
			ProjectUtil.getAbsolutePath("/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.jdt.launching.prefs", false);
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private JdkDriver()
	{
	}

	/**
	 * 
	 * 描述: jdt 发射器 - 库位置修改
	 * @author  qye.zheng
	 * @param libraryLocation 将需要修改的参数封装在该对象中
	 * @return
	 */
	public static boolean launcherLibraryLocationModify(final LibraryLocation libraryLocation)
	{
		System.out.println(JDT_LAUNCHING_CONFIG_LOCATION);
		boolean flag = true;
		String value = null;
		String result = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try
		{
			inputStream = new FileInputStream(JDT_LAUNCHING_CONFIG_LOCATION);
			//final ReadProperties readProperties = new ReadProperties(inputStream);
			final ReadProperties readProperties = new ReadProperties(JDT_LAUNCHING_CONFIG_LOCATION);
			value = readProperties.getProperty(JdkConfigConstant.JDT_PREF_VM_XML_KEY);
			
			//System.out.println(value);
			
			/**
			 将字符串转成二进制字节数组输入流，saxBuilder 才能接受
			 而不能直接接收xml字符串
			 */
			final byte[] btArr = value.getBytes(Constant.CHART_SET_UTF_8);
			final InputStream stream = new ByteArrayInputStream(btArr);
			// 建立构造器  
			final SAXBuilder saxBuilder = new SAXBuilder();
			// 读入指定文件  
			final Document doc = saxBuilder.build(stream);
			
			// 获得根节点  
			final Element root = doc.getRootElement();
			// 所有子节点放入List中  
			final List<Element> elements = root.getChild("vmType").getChild("vm").getChild("libraryLocations").getChildren();
			Element element = null;
			org.jdom2.Attribute attribute = null;
			int jreJavaDocCount = 0 ;
			int jreSrcCount = 0;
			for (int i = 0; i < elements.size(); i++) {
				element = elements.get(i);
				if (!StringUtil.isEmpty(libraryLocation.getJreJavadoc()))
				{
					attribute = new org.jdom2.Attribute(JdkConfigConstant.JDT_LIBRARY_LOCATION_ATTRIBUTE_JRE_DOC, libraryLocation.getJreSrc());
					element.setAttribute(attribute);
					jreJavaDocCount++;
				}
				if (!StringUtil.isEmpty(libraryLocation.getJreSrc()))
				{
					attribute = new org.jdom2.Attribute(JdkConfigConstant.JDT_LIBRARY_LOCATION_ATTRIBUTE_JRE_SRC, libraryLocation.getJreSrc());
					element.setAttribute(attribute);
					jreSrcCount++;
				}
			}
			System.out.println("修改jreJavadoc值[ " + jreJavaDocCount + " ]次");
			System.out.println("修改jreSrc值[ " + jreSrcCount + " ]次");
			
			// 将 doc 输出到 目标配置文件
			// XMLOutput
			final XMLOutputter out = new XMLOutputter();
			// 获取格式对象
			//final Format format = out.getFormat();
			final Format format = Format.getPrettyFormat();
			// 设置编码 - 中文
			format.setEncoding(Constant.CHART_SET_UTF_8);
			// format 为 PreetyFormat 对象时，设置该属性，Pretty输出将失效
			//format.setTextMode(TextMode.PRESERVE);
			//format.setTextMode(TextMode.NORMALIZE);
			// 设置输出格式
			out.setFormat(format);
			// 输出为字符串
			result = out.outputString(doc);
			inputStream.close();
			//outputStream = new FileOutputStream(JDT_LAUNCHING_CONFIG_LOCATION);
			
			//System.out.println(result);
			
			final WriteProperties writeProps = new WriteProperties(JDT_LAUNCHING_CONFIG_LOCATION, true);
			
			// 输出到配置文件
			writeProps.setProperty(JdkConfigConstant.JDT_PREF_VM_XML_KEY, result);
			// 存储，设置注释为空
			writeProps.store(null);
		} catch (Exception e)
		{
			flag = false;
			e.printStackTrace();
		} finally {
			try
			{
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e2)
			{
				e2.printStackTrace();
			}
		}
		
		return flag;
	}
	
}
