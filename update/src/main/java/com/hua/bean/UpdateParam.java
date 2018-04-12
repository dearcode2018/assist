/**
 * 描述: 
 * UpdateParam.java
 * @author	qye.zheng
 *  version 1.0
 */
package com.hua.bean;

import com.hua.constant.Constant;
import com.hua.util.ArrayUtil;
import com.hua.util.ReadProperties;
import com.hua.util.StringUtil;

/**
 * 描述: 更新参数 - 实体
 * @author  qye.zheng
 * UpdateParam
 */
public final class UpdateParam
{
	/* 可能存放的盘符 */
	private String[] possibleDrivers;
	
	/* 工作空间 目录名称 */
	private String workspaceName;
	
	/* 删除工作空间项目之前，是否先备份 */
	private boolean workspaceBackup;
	
	/* 移动盘的目录名称 */
	private String removableDiskName;
	
	/* 移动磁盘的项目拷贝完成后，是否要删除 */
	private boolean diskDelete;
	
	private static final String CONFIG_PATH = "/conf/properties/update.properties";
	
	private static final ReadProperties props = new ReadProperties(CONFIG_PATH);

	private static UpdateParam instance;
	
	
	static
	{
		instance = new UpdateParam();
		
		// 可能存放的盘符
		final String drivers = props.getProperty("fs.windows.possible.drivers");
		// 拦截空设置
		if (!StringUtil.isEmpty(drivers))
		{
			final String[] possibleDrivers = drivers.split(Constant.COMMA);
			ArrayUtil.trim(possibleDrivers);
			instance.setPossibleDrivers(possibleDrivers);
		}
		// 工作空间 目录名称
		instance.setWorkspaceName(props.getProperty("fs.windows.workspace.name"));
		// 删除工作空间项目之前，是否先备份
		instance.setWorkspaceBackup(Boolean.parseBoolean(props.getProperty("fs.windows.workspace.backup")));
		
		// 移动盘的目录名称
		instance.setRemovableDiskName(props.getProperty("fs.windows.removable.disk.name"));
		// 移动磁盘的项目拷贝完成后，是否要删除
		instance.setDiskDelete(Boolean.parseBoolean(props.getProperty("fs.windows.removable.disk.delete")));
	}
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 */
	private UpdateParam()
	{
	}

	/**
	 * @return the possibleDrivers
	 */
	public final String[] getPossibleDrivers()
	{
		return possibleDrivers;
	}

	/**
	 * @param possibleDrivers the possibleDrivers to set
	 */
	public final void setPossibleDrivers(String[] possibleDrivers)
	{
		this.possibleDrivers = possibleDrivers;
	}

	/**
	 * @return the workspaceName
	 */
	public final String getWorkspaceName()
	{
		return workspaceName;
	}

	/**
	 * @param workspaceName the workspaceName to set
	 */
	public final void setWorkspaceName(String workspaceName)
	{
		this.workspaceName = workspaceName;
	}

	/**
	 * @return the removableDiskName
	 */
	public final String getRemovableDiskName()
	{
		return removableDiskName;
	}

	/**
	 * @param removableDiskName the removableDiskName to set
	 */
	public final void setRemovableDiskName(String removableDiskName)
	{
		this.removableDiskName = removableDiskName;
	}

	/**
	 * @return the workspaceBackup
	 */
	public final boolean isWorkspaceBackup()
	{
		return workspaceBackup;
	}

	/**
	 * @param workspaceBackup the workspaceBackup to set
	 */
	public final void setWorkspaceBackup(boolean workspaceBackup)
	{
		this.workspaceBackup = workspaceBackup;
	}

	/**
	 * @return the diskDelete
	 */
	public final boolean isDiskDelete()
	{
		return diskDelete;
	}

	/**
	 * @param diskDelete the diskDelete to set
	 */
	public final void setDiskDelete(boolean diskDelete)
	{
		this.diskDelete = diskDelete;
	}

	/**
	 * @return the instance
	 */
	public static final UpdateParam getInstance()
	{
		return instance;
	}

}
