/**
 * UpdateDriver.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hua.bean.UpdateParam;
import com.hua.bean.UpdateTip;
import com.hua.constant.Constant;
import com.hua.constant.UpdateConstant;
import com.hua.util.DateTimeUtil;
import com.hua.util.EmptyUtil;
import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;
import com.hua.util.StringUtil;

/**
 * UpdateDriver
 * 描述: 项目更新 - 驱动器
 * @author  qye.zheng
 */
public final class UpdateDriver
{

	/* 工作空间 路径 */
	private static String workspaceDirectory;
	
	/* 移动磁盘 项目-路径 */
	private static String removableDiskDirectory;
	
	/* 更新参数 - 公用单例 */
	private static final UpdateParam updateParam = UpdateParam.getInstance();
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private UpdateDriver()
	{
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * @return
	 */
	public static final boolean updateProject()
	{
		boolean flag = false;
		// 启动扫描，初始化路径参数
		if (scanner())
		{
			// 扫描成功
			System.out.println("扫描成功!");
			System.out.println("");
		} else
		{
			// 扫描失败，更新动作停止 - 警报提示
			System.out.println("扫描失败，更新动作停止!");
			
			return flag;
		}
		final File removableDiskFile = new File(removableDiskDirectory);
		final File[] tempFiles = removableDiskFile.listFiles();
		final List<File> typeFiles = new ArrayList<File>();
		// 遍历排除空的目录
		for (File f : tempFiles)
		{
			if (f.isDirectory() && !EmptyUtil.isEmpty(f.list()))
			{
				// 目录，而且不为空
				typeFiles.add(f);
			}
		}
		String[] projectNames = null;
		UpdateTip updateTip = null;
		String projectName = null;
		String projectCopyPath = null;
		File workspaceTypeFile = null;
		boolean result = false;
		try
		{
			String command =  null;
			final Runtime rt = Runtime.getRuntime();
			//Process ps = null;
			for (File typeFile : typeFiles)
			{
				// 若计算机磁盘workspace目录没有存在该类型目录，则创建
				workspaceTypeFile = new File(workspaceDirectory + File.separator + typeFile.getName());
				if (!workspaceTypeFile.exists())
				{
					workspaceTypeFile.mkdirs();
				}
				// 更新提示-信息
				updateTip = new UpdateTip();
				updateTip.setType(typeFile.getName());
				updateTip.setRemark("将移动磁盘中的[" + updateTip.getType() + "]项目，更新到工作空间!");
				updateTip.setDate(DateTimeUtil.getDate());
				// 开始更新
				updateTip.start();
				// 需要拷贝的项目名称
				projectNames = typeFile.list();
				/**
				 (备份) -- 删除工作空间指定项目 -- 移动磁盘拷贝项目 -- (删除移动磁盘项目)
				 */
				for (int i = 0; i < projectNames.length; i++)
				{
					projectName = projectNames[i];
					System.out.println("操作对象-项目名称: " + updateTip.getType() + Constant.DOT_MARK + projectName);
					// 删除工作空间项目之前，是否先备份
					if (updateParam.isWorkspaceBackup())
					{
						// TODO 备份功能暂停
						// 备份
						//BackupDriver.backupProject(projectName);
					}
					// 删除工作空间中指定的项目
					result = FileUtil.deleteDirectory(workspaceDirectory + File.separator + typeFile.getName() + File.separator + projectName);
					if (result)
					{
						// 删除成功 - 更新部分
						updateTip.updateIncrease();
					} else
					{
						// 删除没有执行 - 新增部分
						updateTip.newIncrease();
					}
					projectCopyPath = typeFile.getAbsolutePath() + File.separator + projectName;
					// 将移动磁盘中的项目拷贝到工作空间
					FileUtil.copy(projectCopyPath, workspaceDirectory + File.separator + typeFile.getName());
					
					// 移动磁盘的项目拷贝完成后，是否要删除
					if (updateParam.isDiskDelete())
					{
						FileUtil.deleteDirectory(projectCopyPath);
					}
				}
				// 更新结束
				updateTip.over();
				// 输出提示信息
				finishTip(updateTip);
				// 若有新增，则打开目录
				if (updateTip.getNewCount() > 0)
				{
					// 执行命令，打开指定的目录窗口
					command = "cmd /c start " + workspaceDirectory + File.separator + typeFile.getName();
					//System.out.println(command);
					//ps = rt.exec(command);
					rt.exec(command);
				}
			}
			flag = true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 扫描器，将工作空间和移动盘对象的项目目录
	 * 通过定向匹配，最终来扫描出来
	 * @author qye.zheng
	 */
	public static final boolean scanner()
	{
		boolean flag = false;
		final String[] possibleDrivers = updateParam.getPossibleDrivers();
		File workspaceFile = null;
		File removableDiskFile = null;
		if (!EmptyUtil.isEmpty(possibleDrivers))
		{
			for (int i = 0; i < possibleDrivers.length; i++)
			{
				// 工作空间 路径
				workspaceFile = new File(possibleDrivers[i] + Constant.COLON + 
						File.separator + updateParam.getWorkspaceName());
				if (workspaceFile.isDirectory() && workspaceFile.exists())
				{
					workspaceDirectory = workspaceFile.getAbsolutePath();
					// 找到工作空间目录
					System.out.println("找到 IDE 工作空间 路径: " + workspaceDirectory);
				}
				// 移动磁盘 项目-路径
				removableDiskFile = new File(possibleDrivers[i] + Constant.COLON + 
						File.separator + updateParam.getRemovableDiskName());
				if (removableDiskFile.isDirectory() && removableDiskFile.exists())
				{
					removableDiskDirectory = removableDiskFile.getAbsolutePath();
					// 找到工作空间目录
					System.out.println("找到 移动磁盘项目-路径: " + removableDiskDirectory);
				}
				// 扫描状态 - 是否成功
				if (!StringUtil.isEmpty(workspaceDirectory) && !StringUtil.isEmpty(removableDiskDirectory))
				{
					// 同时扫描到工作空间和移动磁盘项目的路径
					flag = true;
					
					return flag;
				}
			}
		}
		
		return flag;
	}

	/**
	 * 
	 * @description 生成 打开工作空间的脚本
	 * @author qye.zheng
	 */
	public static final void produceOpenWorkspaceScript()
	{
		final StringBuilder builder = StringUtil.getBuilder();
		final String filePath = ProjectUtil.getAbsolutePath("/batch", false);
		try
		{
			// 获取文件数据
			String data = FileUtil.getString(filePath, Constant.CHART_SET_GB2312);
			// 遍历组装多个set表达式，一个表达式一行
			//for (final SetVariable variable : variables)
			//{
			//	builder.append(variable.getSetExpression() + Constant.LINE_BREAK);
			//}
			
			// 执行替换
			data = data.replace(UpdateConstant.OPEN_WORKSPACE_REPLACE_SYMBOL, builder);
			// 输出到文件
			FileUtil.writeString(filePath, data, Constant.CHART_SET_GB2312);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param updateTip
	 * @author qye.zheng
	 */
	public static void finishTip(final UpdateTip updateTip)
	{
		final StringBuilder builder = StringUtil.getBuilder();
		builder.append("==========" + Constant.LINE_BREAK);
		builder.append("[更新信息]" + Constant.LINE_BREAK);
		builder.append("项目类型: " + updateTip.getType() + Constant.LINE_BREAK);
		builder.append("日期: " + DateTimeUtil.format(updateTip.getDate()) + Constant.LINE_BREAK);
		builder.append("更新数量: " + updateTip.getUpdateCount() + Constant.LINE_BREAK);
		builder.append("新增数量: " + updateTip.getNewCount() + Constant.LINE_BREAK);
		builder.append("耗时(毫秒数): " + updateTip.getTimeConsume() + Constant.LINE_BREAK);
		builder.append("备注: " + updateTip.getRemark() + Constant.LINE_BREAK);
		builder.append("==========" + Constant.LINE_BREAK);
		// 输出到控制台
		System.out.println(builder.toString());
	}
	
}
