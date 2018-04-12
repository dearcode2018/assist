/**
 * 描述: 
 * BackDriverTest.java
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

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.backup.driver.BackupDriver;
import com.hua.test.BaseTest;
import com.hua.util.BackupUtil;
import com.hua.util.ProjectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * BackDriverTest
 */
public final class BackDriverTest extends BaseTest {

	private String projectName;
	
	private String wsName;

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackDriver() {
		try {
			String projectName = "computer444";
			log.info("testBackDriver =====> " + BackupDriver.getWsName(projectName));
		} catch (Exception e) {
			log.error("testBackDriver =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGetZipFilename() {
		try {
			
			System.out.println(BackupDriver.getZipFilename("orm", "mybatis"));
			
		} catch (Exception e) {
			log.error("testGetZipFilename =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testProjectPath() {
		try {
			
			System.out.println(ProjectUtil.getAbsolutePath("/project", false));
			
			System.out.println(ProjectUtil.getWorkspacePath() + File.separator + "project");
			
		} catch (Exception e) {
			log.error("testProjectPath =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupCurrentProject() {
		try {
			
			BackupDriver.backupProject();
			
		} catch (Exception e) {
			log.error("testBackupCurrentProject =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupProject() {
		try {
			projectName = "temp";
			projectName = "spring-ioc-xml";
			BackupDriver.backupProject(projectName);
			
		} catch (Exception e) {
			log.error("testBackupProject =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupCurrentWorkingsets() {
		try {
			
			BackupDriver.backupWorkingsets();
			
		} catch (Exception e) {
			log.error("testBackupCurrentWorkingsets =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupWorkingsets() {
		try {
			wsName = "orm";
			
			BackupDriver.backupWorkingsets(wsName);
			
		} catch (Exception e) {
			log.error("testBackupWorkingsets =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupAllWs() {
		try {
			BackupDriver.backupAllWs();
			
		} catch (Exception e) {
			log.error("testBackupAllWs =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupAll() {
		try {
			
			BackupDriver.backupAll();
			
		} catch (Exception e) {
			log.error("testBackupAll =====> ", e);
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
