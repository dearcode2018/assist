/**
 * 描述: 
 * JdkConfigTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.project;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.Format.TextMode;
import org.jdom2.output.XMLOutputter;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.Constant;
import com.hua.test.BaseTest;
import com.hua.util.ReadProperties;
import com.hua.util.WriteProperties;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdkConfigTest
 */
public final class JdkConfigTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testJdkConfig() {
		try {
			path = "/ws/prefix/org.eclipse.jdt.launching.prefs";
			readProperties = new ReadProperties(path);
			result = readProperties.getProperty("org.eclipse.jdt.launching.PREF_VM_XML");
			
			System.out.println(result);
			
			
		} catch (Exception e) {
			log.error("testJdkConfig =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testJdkConfigResolve() {
		try {
			String key = "org.eclipse.jdt.launching.PREF_VM_XML";
			path = "/ws/prefix/org.eclipse.jdt.launching.prefs";
			readProperties = new ReadProperties(path);
			result = readProperties.getProperty(key);
/*			result = result.replace("standalone=\"no\"", "");
			result = result.replace("http://", "");*/
			//System.out.println(result);
			
			byte[] btArr = result.getBytes(Constant.CHART_SET_UTF_8);
			InputStream inputStream = new ByteArrayInputStream(btArr);
			// 建立构造器  
			final SAXBuilder saxBuilder = new SAXBuilder();
			// 读入指定文件  
			final Document doc = saxBuilder.build(inputStream);
			
			// 获得根节点  
			final Element root = doc.getRootElement();
			// 所有子节点放入List中  
			final List<Element> elements = root.getChild("vmType").getChild("vm").getChild("libraryLocations").getChildren();
			Element element = null;
			org.jdom2.Attribute attribute = null;
			String value = "new value";
			for (int i = 0; i < elements.size(); i++) {
				element = elements.get(i);
				attribute = new org.jdom2.Attribute("jreSrc", value);
				element.setAttribute(attribute);
			}
			
			// 将 doc 输出到 .classpath 文件
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
			String resultXml = out.outputString(doc);
			
			System.out.println(resultXml);
			
			WriteProperties writeProps = new WriteProperties(path, false);
			writeProps.setProperty(key, resultXml);
			// 存储，设置注释为空
			writeProps.store("");
		} catch (Exception e) {
			log.error("testJdkConfigResolve =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
