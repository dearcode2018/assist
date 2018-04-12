/**
 * 描述: 
 * EncryptionStarter.java
 * @author	qye.zheng
 * 
 *  version 1.0
 */
package com.hua.starter;

import org.junit.Test;

import com.hua.encryption.BaseEncryption;
import com.hua.encryption.DecryptionEntry;
import com.hua.encryption.EncryptionV001;

/**
 * 描述: 启动器
 * @author  qye.zheng
 * 
 * EncryptionStarter
 */
public final class EncryptionStarter
{


	

	// 启动器模板
	/**
	 * 
	 * 描述: 加密启动器
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		// 常用密码加密对
		/**
		 * OpWVw0keJhXT6lEelhFc0I1aWVUUwokQ : xzy123
		 */
		String pwd = "xzy123";
		BaseEncryption encryption = new EncryptionV001(pwd);
		System.out.println(encryption.getOutput());
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}
	
	@Test
	public void start001()
	{
		/** ===== begin 驱动参数设置  ===== */
		// 设置例子
		// OpWVw0keJhXT6lEelhFc0I1aWVUUwokQ
		//System.out.println(DecryptionEntry.decryption("OpWVw0keJhXT6lEelhFc0I1aWVUUwokQ", EncryptionV001.VERSION));
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}

}
