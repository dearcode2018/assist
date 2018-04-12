/**
 * Vm.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * Vm
 * 描述: 
 * @author  qye.zheng
 */
public class Vm extends BaseTag
{

	private List<LibraryLocation> libraryLocations = new ArrayList<LibraryLocation>();
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public Vm()
	{
	}

	/**
	 * @return the libraryLocations
	 */
	public List<LibraryLocation> getLibraryLocations()
	{
		return libraryLocations;
	}

	/**
	 * @param libraryLocations the libraryLocations to set
	 */
	public boolean addLibraryLocation(LibraryLocation libraryLocation)
	{
		return this.libraryLocations.add(libraryLocation);
	}
	
}
