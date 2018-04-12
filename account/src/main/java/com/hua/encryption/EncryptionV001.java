/**
  * @filename EncryptionV001.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.encryption;

import sun.misc.BASE64Encoder;

import com.hua.constant.Constant;
import com.hua.util.StringUtil;

 /**
 * @type EncryptionV001
 * @description  0.0.1 版本的加密
 * @author qianye.zheng
 */
public final class EncryptionV001 extends BaseEncryption {
	
	public static final String VERSION = "0.0.1";
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public EncryptionV001(final String input) {
		// 固定值
		super(VERSION);
		super.input = input;
	}

	/**
	 * @description 获取加密的输出
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String getOutput() {
		try
		{
			StringBuffer buffer = null;
			String temp = null;
			// base64 加密
			BASE64Encoder encoder = new BASE64Encoder();
			
			 buffer = StringUtil.getBuffer();
			// 添加扩展字符串
			buffer.append("ABCDEF" + input + "123456");
			// 翻转
			buffer.reverse();
			
			// base64 加密
			temp = encoder.encode(buffer.toString().getBytes(Constant.CHART_SET_UTF_8));
			
			buffer = StringUtil.getBuffer();
			buffer.append(temp);
			// 翻转
			buffer.reverse();
			
			// base64 加密
			temp = encoder.encode(buffer.toString().getBytes(Constant.CHART_SET_UTF_8));
			
			buffer = StringUtil.getBuffer();
			buffer.append(temp);
			// 翻转
			buffer.reverse();
			
			output = buffer.toString();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return output;
	}
}
