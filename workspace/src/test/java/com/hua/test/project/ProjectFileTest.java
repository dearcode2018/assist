/**
 * 描述: 
 * ProjectFileTest.java
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ProjectFileTest
 */
public final class ProjectFileTest extends BaseTest {
	
	// 含有.的路径(目录中以.开头)
	private String testDir = "D:/Workspace/.metadata";
	
	// 文件名以.开头
	private String testPath = "D:/Workspace/.metadata/.log";
	
	private File dirFile = new File(testDir);
	
	private File pathFile = new File(testPath);

	private String path;
	
	private InputStream inputStream;
	
	private OutputStream outputStream;
	
	
	/*
	 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testProjectFile() {
		try {
			
			/*
				在项目工作空间(workspace)中，有些配置文件的名称是以点开头
				或者文件名中包含有点的，访问这些文件的时候需要注意，有些
				资源是无法识别这种敏感路径的
			 */
			log.info("testProjectFile =====> " + dirFile.getAbsolutePath());
			log.info("testProjectFile =====> " + pathFile.getAbsolutePath());
			
		
			
			
		} catch (Exception e) {
			log.error("testProjectFile =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCoverCopy() {
		try {
			path = ClassPathUtil.getClassSubpath("/conf/xml/ws/workbench.xml");
			File file = new File(path);
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream("D:/workbench.xml");
			byte[] data = new byte[1024];
			int actualCount = -1;
			while (-1 != (actualCount = inputStream.read(data)))
			{
				outputStream.write(data, 0, actualCount);
			}
			
			outputStream.flush();
			
		} catch (Exception e) {
			log.error("testCoverCopy =====> ", e);
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
			} catch (IOException e)
			{
				log.error("testCoverCopy =====> ", e);
			}
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
			
			String path = System.getProperty("user.dir");
			//log.info("testTemp =====> " + path);
			File file = new File(path);
			
			File parent = file.getParentFile();
			
			//log.info("testTemp =====> " + parent.getAbsolutePath());
			
			log.info("testTemp =====> " + ProjectUtil.getProjectRootPath());
			log.info("testTemp =====> " + ProjectUtil.getWorkspacePath());
			
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
