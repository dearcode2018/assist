/**
 * 描述: 
 * JqueryPagerServlet.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.controller.jquery;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hua.bean.Pager;
import com.hua.constant.Constant;
import com.hua.controller.BaseServlet;
import com.hua.entity.jquery.InfoShow;
import com.hua.entity.jquery.JqueryPageParam;
import com.hua.entity.jquery.JqueryPager;
import com.hua.entity.jquery.PersonInfo;
import com.hua.util.BeanUtil;
import com.hua.util.StringUtil;



/**
 * 描述: 
 * 
 * @author qye.zheng
 * JqueryPagerServlet
 */
@WebServlet(name="JqueryPagerServlet", urlPatterns={"/JqueryPagerServlet"})
public final class JqueryPagerServlet extends BaseServlet {

	 /* long */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/**
		 * 分页参数 需要和 jquery easy ui 分页参数对应起来
		 * 
		 * jeasyui 分页参数 :
		 * page 当前页 (相当于 currentPage)
		 * rows 页大小 (相当于 pageCount)
		 * 
		 * 
		 */
		log.info("doPost =====> queryString --> " + request.getQueryString());
		try
		{
			// 获取分页参数
			final JqueryPageParam param = new JqueryPageParam();
			BeanUtil.populate(param, request.getParameterMap());
			log.info("doPost =====> " + request.getParameterMap().size());
			log.info("doPost =====> " + request.getParameter("rows"));
			// 数据总数
			final int dataSize = 78;
			final int pageSize = param.getRows();
			final long startIndex = param.getRows() * (param.getPage() - 1);
			final long endIndex = param.getRows() * param.getPage();
			final InfoShow info = generateData(dataSize, startIndex, endIndex);
			final ObjectMapper mapper = new ObjectMapper();
			final JqueryPager<PersonInfo> pager = new JqueryPager<PersonInfo>();
			// 当前页
			pager.setPage(param.getPage());
			// 
			pager.setFrom(startIndex + 1);
			// 
			pager.setTo(endIndex + 1);
			// 页大小
			pager.setPageSize(pageSize);
			// 总记录数
			pager.setTotal(dataSize);
			// 数据集合
			pager.setRows(info.getDataList());
			// 生成 json
			final String json = mapper.writeValueAsString(pager);
			log.info("doPost =====> json = " + json);
			response.getOutputStream().write(json.getBytes(Constant.CHART_SET_UTF_8));
		} catch (Exception e)
		{
			log.error("doPost =====> ", e);
		}
	}
	
	/**
	 * 描述: 
	 * @author qye.zheng
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{
		log.info("doGet =====> ");
		// 调用 doPost 方法
		this.doPost(request, response);
	}
	
	/**
	 * 
	 * 描述: 生产数据
	 * @author qye.zheng
	 * 
	 * @return
	 */
	private InfoShow generateData(final int dataSize, long startIndex, long endIndex) {
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (endIndex < 0) {
			endIndex = 0;
		}
		if (startIndex < dataSize && endIndex > dataSize) {
			endIndex = dataSize;
		} else if (startIndex >= dataSize && endIndex >= dataSize) {
			// 超出全部数据的索引范围，返回记录为空
			startIndex = 0;
			endIndex = 0;
		}
		final InfoShow info = new InfoShow();
		info.setOid(728832938479328L);
		info.setRemark("上海市浦东新区 - 备注");
		info.setComment("评论 : 新华社评论");
		PersonInfo person = null;
		final String[] interestArray = {"运动", "阅读", "交友"};
		for (long i = startIndex; i < endIndex; i++) {
			person = new PersonInfo();
			person.setOid(1000L + i);
			person.setCreateTime(new Date());
			person.setUpdateTime(new Date());
			person.setInfo("信息内容 " + i);
			person.setLocation("位置 " + i);
			person.setUsername("username " + i);
			person.setPassword("password " + i);
			person.setInterestArray(interestArray);
			info.getDataList().add(person);
		}
		
		return info;
	}
}
