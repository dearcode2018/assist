/**
 * 描述: 
 * EncryptionTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.account;

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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.encryption.BaseEncryption;
import com.hua.encryption.DecryptionEntry;
import com.hua.encryption.EncryptionV001;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * EncryptionTest
 */
public final class EncryptionTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testEncryptionV001() {
		try {
			String input = "hdkdla123";
			input = "h11";
			String output = null;
			BaseEncryption encryption = new EncryptionV001(input);
			output = encryption.getOutput();
			
			//log.info("testEncryptionV001 =====> output = " + output);
			System.out.println(output);
		} catch (Exception e) {
			log.error("testEncryptionV001 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDecryptionV001() {
		try {
			String value = "BJ0QEVkRoFTMxIzM0UjN";
			value = "BJ0QEVkRoR2akxWYxIzMxIzM0UjN";
			value = "==gTqVFMNpXS41keJhXWXh3ahJjUvJ1aWVUUwokQ";
			value = "=4kaVBTT6lEeNRlRvJ1aWVUUwokQ";
			String result = DecryptionEntry.decryption(value, EncryptionV001.VERSION);
			
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testDecryptionV001 =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testByteValueOf() {
		try {
			String str = "-76";
			byte bt = Byte.valueOf(str);
			log.info("testByteValueOf =====> bt = " + bt);
			
		} catch (Exception e) {
			log.error("testByteValueOf =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testShift() {
		try {
			String value = "abc";
			
			byte[] data = value.getBytes();
			
			for (int i = 0; null != data && i < data.length; i++)
			{
				// 翻转
				data[i]  = new Integer(Integer.reverse(data[i])).byteValue();
			}
			
			for (int i = 0; null != data && i < data.length; i++)
			{
				// 右移 5 位
				data[i]  >>= 5;
			}
			
			value = new String(data);
			System.out.println(value);
		} catch (Exception e) {
			log.error("testShift =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testShift2() {
		try {
			String value = "abc";
			
			byte[] data = value.getBytes();
			
			for (int i = 0; null != data && i < data.length; i++)
			{
				// 左移 5 位
				data[i]  <<= 5;
			}
			
			for (int i = 0; null != data && i < data.length; i++)
			{
				// 右移 5 位
				data[i]  >>= 5;
			}
			
			value = new String(data);
			System.out.println(value);
		} catch (Exception e) {
			log.error("testShift2 =====> ", e);
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
