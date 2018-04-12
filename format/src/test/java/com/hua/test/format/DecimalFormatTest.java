/**
 * 描述: 
 * DecimalFormatTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.format;

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

import java.text.DecimalFormat;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;
import com.hua.util.FormatUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * DecimalFormatTest
 */
public final class DecimalFormatTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDecimalFormat() {
		try {
			DecimalFormat decimalFormat = new DecimalFormat("#");
			
			String stNumber = "212583212";
			log.info("testDecimalFormat =====> " + decimalFormat.format(stNumber));
			
			long lnNumber = 1216545L;
			log.info("testDecimalFormat =====> " + decimalFormat.format(lnNumber));
			
			double dNumber = 1252.3255;
			log.info("testDecimalFormat =====> " + decimalFormat.format(dNumber));
			
			float fNumber = 12.334F;
			log.info("testDecimalFormat =====> " + decimalFormat.format(fNumber));
			
			int iNumber = 123;
			log.info("testDecimalFormat =====> " + decimalFormat.format(iNumber));
			
			short sNumber = 12;
			log.info("testDecimalFormat =====> " + decimalFormat.format(sNumber));
			
			
		} catch (Exception e) {
			log.error("testDecimalFormat =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFormatUtil() {
		try {
			
			
			String stNumber = "212583212";
			log.info("testDecimalFormat =====> " + FormatUtil.format(stNumber));
			
			long lnNumber = 1216545L;
			log.info("testDecimalFormat =====> " + FormatUtil.format(lnNumber));
			
			double dNumber = 1252.3255;
			log.info("testDecimalFormat =====> " + FormatUtil.format(dNumber));
			
			float fNumber = 12.334F;
			log.info("testDecimalFormat =====> " + FormatUtil.format(fNumber));
			
			int iNumber = 123;
			log.info("testDecimalFormat =====> " + FormatUtil.format(iNumber));
			
			short sNumber = 12;
			log.info("testDecimalFormat =====> " + FormatUtil.format(sNumber));
		} catch (Exception e) {
			log.error("testFormatUtil =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNullParam() {
		try {
			String str = null;
			log.info("testDecimalFormat =====> " + FormatUtil.format(str));
			
		} catch (Exception e) {
			log.error("testNullParam =====> ", e);
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
