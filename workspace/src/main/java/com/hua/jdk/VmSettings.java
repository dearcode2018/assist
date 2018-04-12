/**
 * VmSettings.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.jdk;

import java.util.List;

/**
 * VmSettings
 * 描述: 
 * @author  qye.zheng
 */
public final class VmSettings
{

	// 默认虚拟机
	private String defaultVM;
	
	// 默认虚拟机 连接器
	private String defaultVMConnector;
	
	private VmType vmType;
	
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public VmSettings()
	{
	}

	/**
	 * @return the defaultVM
	 */
	public String getDefaultVM()
	{
		return defaultVM;
	}


	/**
	 * @param defaultVM the defaultVM to set
	 */
	public void setDefaultVM(String defaultVM)
	{
		this.defaultVM = defaultVM;
	}


	/**
	 * @return the defaultVMConnector
	 */
	public String getDefaultVMConnector()
	{
		return defaultVMConnector;
	}


	/**
	 * @param defaultVMConnector the defaultVMConnector to set
	 */
	public void setDefaultVMConnector(String defaultVMConnector)
	{
		this.defaultVMConnector = defaultVMConnector;
	}


	/**
	 * @return the vmType
	 */
	public VmType getVmType()
	{
		return vmType;
	}


	/**
	 * @param vmType the vmType to set
	 */
	public void setVmType(VmType vmType)
	{
		this.vmType = vmType;
	}

}
