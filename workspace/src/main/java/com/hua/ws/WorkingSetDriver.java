/**
 * WorkingSetDriver.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.ws;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.hua.constant.Constant;
import com.hua.constant.ProjectConstant;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;

/**
 * WorkingSetDriver
 * 描述: 
 * @author  qye.zheng
 */
public final class WorkingSetDriver
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private WorkingSetDriver()
	{
	}
	
	/**
	 * 
	 * 描述: 将workbench.xml、workingsets.xml 拷贝到工作空间
	 * 配置目录下.metadata/.plugins/org.eclipse.ui.workbench/
	 * 覆盖式拷贝
	 * @author  qye.zheng
	 * @return
	 */
	public static boolean CoverCopyConfig()
	{
		/*
		 路径是否从当前项目的根路径开始 (这里操作的工作空间的资源，不是当前项目的资源)
		 */
		final boolean project = false;
		boolean flag = false;
		final String workBeanchOutputPath = ProjectUtil.getAbsolutePath(ProjectConstant.WORKING_SET_OUTPUT_RELATIVE_PATH 
				+ ProjectConstant.WORKING_SET_WORK_BENACH, project);
		final String workingSetOutputPath = ProjectUtil.getAbsolutePath(ProjectConstant.WORKING_SET_OUTPUT_RELATIVE_PATH 
				+ ProjectConstant.WORKING_SET_WORKING_SET, project);
		System.out.println(workBeanchOutputPath);
		System.out.println(workingSetOutputPath);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] data = new byte[1024];
		int actualCount = -1;
		try
		{
			inputStream = ClassPathUtil.getInputStream(ProjectConstant.WORKING_SET_INPUT_RELATIVE_PATH 
					+ ProjectConstant.WORKING_SET_WORK_BENACH);
			outputStream = new FileOutputStream(workBeanchOutputPath);
			while (Constant.NEGATIVE_ONE != (actualCount = inputStream.read(data)))
			{
				outputStream.write(data, Constant.ZERO, actualCount);
			}
			outputStream.flush();
			flag = true;
			System.out.println(ProjectConstant.WORKING_SET_WORK_BENACH + " 覆盖更新成功!");
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally 
		{
			try
			{
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
		try
		{
			inputStream = ClassPathUtil.getInputStream(ProjectConstant.WORKING_SET_INPUT_RELATIVE_PATH 
					+ ProjectConstant.WORKING_SET_WORKING_SET);
			outputStream = new FileOutputStream(workingSetOutputPath);
			while (Constant.NEGATIVE_ONE != (actualCount = inputStream.read(data)))
			{
				outputStream.write(data, Constant.ZERO, actualCount);
			}
			outputStream.flush();
			flag = true;
			System.out.println(ProjectConstant.WORKING_SET_WORKING_SET + " 覆盖更新成功!");
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally 
		{
			try
			{
				if (null != outputStream)
				{
					outputStream.close();
				}
				if (null != inputStream)
				{
					inputStream.close();
				}
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
		return flag;
	}

	public static boolean replaceJdtLaunchingCofing()
	{
		boolean flag = false;
		
		return flag;
	}
	
}
