/**
 * 描述: 
 * ReadWorkingsetsTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.backup;

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

import java.io.FileInputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.backup.driver.BackupDriver;
import com.hua.constant.ProjectConstant;
import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ReadWorkingsetsTest
 */
public final class ReadWorkingsetsTest extends BaseTest {

	private String classPathFile;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReadWorkingsets() {
		try {
			final boolean project = false;
			classPathFile = ClassPathUtil.getClassSubpath("/conf/xml/ws/workingsets.xml", true);
			classPathFile = ProjectUtil.getAbsolutePath(ProjectConstant.WORKING_SET_OUTPUT_RELATIVE_PATH 
					+ ProjectConstant.WORKING_SET_WORKING_SET, project);
			// 建立构造器  
			final SAXBuilder saxBuilder = new SAXBuilder();
			// 读入指定文件  
			final Document doc = saxBuilder.build(new FileInputStream(classPathFile));
			
			// 获得根节点  
			final Element root = doc.getRootElement();
			
			// 子节点集合
			List<Element> children = root.getChildren();
			List<Element> nextChildren = null;
			for (Element e : children)
			{
				System.out.println("workingSet name = " + e.getAttributeValue("name"));
				nextChildren = e.getChildren();
				for (Element nextE : nextChildren)
				{
					System.out.println("item path = " + nextE.getAttributeValue("path"));
				}
				System.out.println("==========================");
			}
			
			log.info("testReadWorkingsets =====> " + root.getName());
			
			
		} catch (Exception e) {
			log.error("testReadWorkingsets =====> ", e);
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
			BackupDriver.backupAll();
			
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
