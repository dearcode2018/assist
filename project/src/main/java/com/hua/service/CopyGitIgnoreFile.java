/**
  * @filename CopyGitIgnoreFile.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.service;

import java.io.File;

import org.junit.Test;

import com.hua.util.FileUtil;
import com.hua.util.ProjectUtil;

/**
 * @type CopyGitIgnoreFile
 * @description 拷贝git .gitignore
 * @author qianye.zheng
 */
public class CopyGitIgnoreFile
{
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void start()
	{
		/** ===== begin 驱动参数设置  ===== */
		/**
		 * 目录下所有的项目
		 */
		String path = "E:/workspace/java";
		String templatePath = ProjectUtil.getAbsolutePath("/doc/template.gitignore", true);
		final String tempPath = ProjectUtil.getAbsolutePath("/doc/.gitignore", true);
		// 先删除临时文件
		FileUtil.deleteFile(tempPath);
		// 临时文件
		final File templateFile = new File(tempPath) ;
		FileUtil.writeString(templateFile, FileUtil.getString(templatePath)+ ".gitignore", false);
		final File file = new File(path);
		final File[] files = file.listFiles();
		for (File e : files)
		{
			if (e.isDirectory() && !e.getName().startsWith("."))
			{
				FileUtil.copy(templateFile, e.getAbsolutePath());
			}
		}
		
		
		/** ===== end of 驱动参数设置 ===== */

		// 启动驱动
		
		
	}
	
}
