/**
 * ImageOuput.java
 * @author qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;

/**
 * ImageOuput
 * 描述: 验证码
 * 生成随机验证码 : 纯数字、纯字母、数字字母混合
 * 
 * 以流的形式输出验证码结果
 * 
 * @author qye.zheng
 * 
 */
public final class ImageOuput
{
	/* 颜色RGB最大值 */
	private static final int COLOR_LIMIT = 255;
	
	/* 是否绘制干扰线 (默认 true) */
	private boolean isDrawLine = true;
	
	/* 图像宽度 : px */
	private int width = 85;
	
	/* 图像高度 : px */
	private int height = 25;
	
	/* 干扰线数量  */
	private int lineSize = 24;
	
	/* 字体大小  */
	private int fontSize = 25;
	
	/* 前景色 */
	private int foregroundColor = 110;
	
	/* 背颜色 */
	private int backgroundColor = 133;
	
	/* 图片格式, 默认 JPEG */
	private String format = "JPEG";

	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public ImageOuput()
	{
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param width
	 * @param height
	 * @author qianye.zheng
	 */
	public ImageOuput(int width, int height)
	{
		this.width = width;
		this.height= height;
	}
	
	/**
	 * 
	 * @description 构造方法
	 * @param width
	 * @param height
	 * @param lineSize
	 * @param fontSize
	 * @author qianye.zheng
	 */
	public ImageOuput(int width, int height, int lineSize, int fontSize)
	{
		this.width = width;
		this.height= height;
		this.lineSize = lineSize;
		this.fontSize = fontSize;
	}
	
	/**
	 * 
	 * @description 
	 * @param output
	 * @param value 输出的值
	 * @return
	 * @author qianye.zheng
	 */
	public final boolean output(final OutputStream outputStream, final String value) {
		boolean flag = false;
		try
		{
			// 缓冲区Image类
			final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			// 绘制板
			final Graphics graphics = image.getGraphics();
			// 绘制方图
			graphics.fillRect(0, 0, width, height);
			// 绘制干扰线
			if (isDrawLine) {
				for (int i = 0; i < lineSize; i++) {
					drawLine(graphics);
				}
			}
			// 绘制随机字符串
			// 生成随机字符串
			for (int i = 0; i< value.length(); i++) {
				// 循环调用绘制单个码
				drawString(graphics, String.valueOf(value.charAt(i)), i + 1);
			}
			// 绘制处理
			graphics.dispose();
			// 将内存中的图片输出到指定的流
			ImageIO.write(image, format, outputStream);
			flag = true;
		} catch (Exception e)
		{
			flag = false;
			e.printStackTrace();
		} finally
		{
			IOUtil.close(outputStream);
		}
		
		return flag;
	}
	
	/**
	 * 
	 * 描述: 绘制字符串 
	 * @author qye.zheng
	 * 
	 * @param graphics
	 * @param randomString
	 * @param index
	 * @return
	 */
	private void drawString(final Graphics graphics, final String randomString, final int index) {
		graphics.setFont(getFont());
		graphics.setColor(getRandomColor());
		graphics.translate(RandomUtil.nextInt(3), RandomUtil.nextInt(3));
		graphics.drawString(randomString, 13 * index, 16);
	}
	
	/**
	 * 
	 * 描述: 绘制干扰线
	 * @author qye.zheng
	 * 
	 * @param graphics
	 */
	private void drawLine(final Graphics graphics) {
		final int x1 = RandomUtil.nextInt(width);
		final int y1 = RandomUtil.nextInt(height);
		final int x2 = RandomUtil.nextInt(width - 5) + x1;
		final int y2 = RandomUtil.nextInt(height - 5) + y1;
		// 绘制干扰线
		graphics.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * 
	 * 描述: 获取字体
	 * @author qye.zheng
	 * 
	 * @return
	 */
	private Font getFont() {
		return new Font(Font.SERIF, Font.CENTER_BASELINE, fontSize);
	}
	
	/**
	 * 
	 * 描述: 获取随机颜色
	 * @author qye.zheng
	 * 
	 * @param foregroundColor 前景色 [0, COLOR_LIMIT]
	 * @param backgroundColor 背景色 [0, COLOR_LIMIT]
	 * @return
	 */
	private final Color getRandomColor() {
		final int red = foregroundColor + RandomUtil.nextInt(backgroundColor - foregroundColor - 16);
		final int green = foregroundColor + RandomUtil.nextInt(backgroundColor - foregroundColor - 14);
		final int blue = foregroundColor + RandomUtil.nextInt(backgroundColor - foregroundColor - 18);
		
		return new Color(red, green, blue);
	}

	/**
	 * @param width the width to set
	 */
	public final void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @param height the height to set
	 */
	public final void setHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 * @param lineSize the lineSize to set
	 */
	public final void setLineSize(int lineSize)
	{
		this.lineSize = lineSize;
	}

	/**
	 * @param fontSize the fontSize to set
	 */
	public final void setFontSize(int fontSize)
	{
		this.fontSize = fontSize;
	}

	/**
	 * @param foregroundColor the foregroundColor to set
	 */
	public final void setForegroundColor(int foregroundColor)
	{
		if (foregroundColor > COLOR_LIMIT) {
			foregroundColor = COLOR_LIMIT;
		}
		this.foregroundColor = foregroundColor;
	}

	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public final void setBackgroundColor(int backgroundColor)
	{
		if (backgroundColor > COLOR_LIMIT) {
			backgroundColor = COLOR_LIMIT;
		}
		this.backgroundColor = backgroundColor;
	}

	/**
	 * @param isDrawLine the isDrawLine to set
	 */
	public final void setDrawLine(boolean isDrawLine)
	{
		this.isDrawLine = isDrawLine;
	}

	/**
	 * @param format the format to set
	 */
	public final void setFormat(String format)
	{
		this.format = format;
	}
	
}
