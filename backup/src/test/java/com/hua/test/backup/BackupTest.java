/**
 * 描述: 
 * BackupTest.java
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

import java.sql.Time;
import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.backup.driver.BackupDriver;
import com.hua.bean.backup.BackupTip;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;


/**
 * 描述: 备份 - 测试
 * 
 * @author qye.zheng
 * BackupTest
 */
public final class BackupTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBackupTip() {
		try {
			BackupTip tip = new BackupTip();
			
			tip.setDate(DateTimeUtil.getDate());
			tip.increase();
			
			tip.setRemark("备份备注");
			tip.start();
			int i = 0;
			int j = 0;
			while (i < 90000000 * 900000000)
			{
				j = 0;
				i++;
				while (j < 90000000 * 900000000)
				{
					j++;
				}
			}
			tip.over();
			
			BackupDriver.finishTip(tip);
			
			//log.info("testBackupTip =====> " + tip.getTimeConsume());
			
		} catch (Exception e) {
			log.error("testBackupTip =====> ", e);
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
	public void testBackup() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBackup =====> ", e);
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
			// 12075000
			final Calendar calendar = Calendar.getInstance();
			System.out.println(new Time(calendar.getTimeInMillis()).getTime());
			System.out.println(DateTimeUtil.parseTime("11:21:15").getTime());
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
