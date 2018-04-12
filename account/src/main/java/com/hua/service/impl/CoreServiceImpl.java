/**
 * 描述: 
 * CoreServiceImpl.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hua.log.BaseLog;
import com.hua.service.CoreService;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreServiceImpl
 */
@Transactional
public abstract class CoreServiceImpl extends BaseLog implements CoreService {

	/* apache commons log */
	protected Log log = LogFactory.getLog(this.getClass().getName());
	
	
}
