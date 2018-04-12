/**
  * @filename DecryptionEntry.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.encryption;

import sun.misc.BASE64Decoder;

import com.hua.constant.Constant;
import com.hua.exception.AccountRuntimeException;
import com.hua.util.StringUtil;

 /**
 * @type DecryptionEntry
 * @description  解密入口
 * @author qianye.zheng
 */
public final class DecryptionEntry {

	/**
	 * 
	 * @description 解密入口
	 * @param value
	 * @param version
	 * @return
	 * @author qianye.zheng
	 */
	public static final String decryption(final String value, final String version)
	{
		/**
		 * 寻找入口
		 */
		switch (version)
		{
		// 版本 0.0.1 入口
		case EncryptionV001.VERSION:
		{
			return decryptionV001(value);
		}

		//
		default:
		{
			throw new AccountRuntimeException("版本不存在");
		}
		}
	}
	
	/**
	 * 
	 * @description 版本 0.0.1 解密
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	private static final String decryptionV001(final String value)
	{
		String output = null;
		try
		{
			// base64 解密
			BASE64Decoder decoder = new BASE64Decoder();
			StringBuffer buffer = null;
			String temp = null;
			
			buffer = StringUtil.getBuffer();
			buffer.append(value);
			
			// 翻转
			buffer.reverse();
			// base64 解密
			temp = new String(decoder.decodeBuffer(buffer.toString()), Constant.CHART_SET_UTF_8);
			buffer = StringUtil.getBuffer();
			buffer.append(temp);
			// 翻转
			buffer.reverse();
			
			temp = new String(decoder.decodeBuffer(buffer.toString()), Constant.CHART_SET_UTF_8);
			buffer = StringUtil.getBuffer();
			buffer.append(temp);
			// 翻转
			buffer.reverse();			
			
			// 去除头尾字符
			output = buffer.toString();
			output = output.substring(6);
			output = output.substring(0, output.length() - 6);
		} catch (Exception e)
		{

		}
		
		
		return output;
	}
}
