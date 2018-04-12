/**
  * @filename BaseEncryption.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.encryption;

 /**
 * @type BaseEncryption
 * @description  
 * @author qianye.zheng
 */
public abstract class BaseEncryption {

	/* 版本，不同版本使用的密钥不同 规格: 0.0.1 */
	private String version;
	
	/* 加密输入值 */
	protected String input;
	
	/* 加密输出 */
	protected String output;

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public BaseEncryption(final String version) {
		this.version = version;
	}
	
	/**
	 * @return the version
	 */
	public final String getVersion() {
		return version;
	}

	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public abstract String getOutput();	
}
