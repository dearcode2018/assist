/**
 * LibraryLocation.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.jdk;

/**
 * LibraryLocation
 * 描述: 
 * @author  qye.zheng
 */
public final class LibraryLocation extends BaseTag
{

	private String jreJar;
	
	private String jreJavadoc;
	
	private String jreSrc;
	
	private String pkgRoot;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public LibraryLocation()
	{
	}

	/**
	 * @return the jreJar
	 */
	public String getJreJar()
	{
		return jreJar;
	}

	/**
	 * @param jreJar the jreJar to set
	 */
	public void setJreJar(String jreJar)
	{
		this.jreJar = jreJar;
	}

	/**
	 * @return the jreJavadoc
	 */
	public String getJreJavadoc()
	{
		return jreJavadoc;
	}

	/**
	 * @param jreJavadoc the jreJavadoc to set
	 */
	public void setJreJavadoc(String jreJavadoc)
	{
		this.jreJavadoc = jreJavadoc;
	}

	/**
	 * @return the pkgRoot
	 */
	public String getPkgRoot()
	{
		return pkgRoot;
	}

	/**
	 * @param pkgRoot the pkgRoot to set
	 */
	public void setPkgRoot(String pkgRoot)
	{
		this.pkgRoot = pkgRoot;
	}

	/**
	 * @return the jreSrc
	 */
	public String getJreSrc()
	{
		return jreSrc;
	}

	/**
	 * @param jreSrc the jreSrc to set
	 */
	public void setJreSrc(String jreSrc)
	{
		this.jreSrc = jreSrc;
	}

}
