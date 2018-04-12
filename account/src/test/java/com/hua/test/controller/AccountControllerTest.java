/**
 * 描述: 
 * AccountControllerTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.controller;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hua.test.BaseSpringTest;
import com.hua.util.ClassPathUtil;
import com.hua.util.ProjectUtil;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * AccountControllerTest
 */
/*
 * 
 * @SpringJUnit4ClassRunner 运行器负责拉起 spring 环境
 * @ContextConfiguration 指定 spring配置文件，若不指定，则使用默认配置.
 */
// for Junit 4.x
public final class AccountControllerTest extends BaseSpringTest {

	/*
	配置方式1: 
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextConfiguration(locations = {
			"classpath:conf/xml/spring-bean.xml", 
			"classpath:conf/xml/spring-config.xml", 
			"classpath:conf/xml/spring-mvc.xml", 
			"classpath:conf/xml/spring-service.xml"
		})
	@RunWith(SpringJUnit4ClassRunner.class)  
	
	配置方式2: 	
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextHierarchy({  
		 @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),  
		 @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")  
		}) 
	@RunWith(SpringJUnit4ClassRunner.class)  
	 */
	
	/**
	 * 而启动spring 及其mvc环境，然后通过注入方式，可以走完 spring mvc 完整的流程.
	 * 
	 */
	//@Resource
	//private UserController userController;
	
	//@PathVariable
	
	//@Resource(type = WebApplicationContext.class)
	//@Autowired
	@Resource
    private WebApplicationContext webApplicationContext; 
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		prefix = "/api/account";
	}	
	
	/**
	 * 控制器 单元测试
	 * 描述: spring mvc 单元测试 (单元测试只能确保整个业务流程可以跑通)
	 * 直接注入控制器的方式只能做单元测试，不能做系统集成测试，
	 * 例如 可以走 spring mvc 过滤器链、类型转换、数据验证、数据绑定、拦截器等..
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnitController() {
		try {
			/**
			 * 构造 request / response 和参数对象
			 * 可以将此测试代码写在要测试的项目中，
			 * 也可以新建一个项目，然后引用需要测试的项目，
			 * 将 spring spring-mvc 系列环境启动起来，就可以测试了.
			 * dao / service / controller / tx / 数据源 ...
			 */
			HttpServletRequest request = new MockHttpServletRequest();
			HttpServletResponse response = new MockHttpServletResponse();
			//User user = new User();
			//user.setUsername("admin");
			//user.setPassword("123456");
			
			//userController.login(request, response, user);
			
		} catch (Exception e) {
			log.error("testInjectController =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 新增帐户
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAdd() {
		try {
			// 页面/服务 地址
			String url = prefix + "/add";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("username", "94521366");
			requestBuilder.param("status", "1");
			requestBuilder.param("password", "123456");
			requestBuilder.param("level", "1");
			requestBuilder.param("type", "1");
			requestBuilder.param("source", "腾讯公司");
			requestBuilder.param("usage", "登录QQ 邮箱...");
			requestBuilder.param("relationalAccounts", "94521366@qq.com");
			requestBuilder.param("expireDate", "2018-10-13");
			requestBuilder.param("mobilePhone", "15213647585");
			requestBuilder.param("officialLink", "http://caibaojian.com/demo/power-slider/index2.html");
			requestBuilder.param("loginLink", "http://mail.qq.com/cgi-bin/loginpage?t=wx_logout&s=logout&f=html&uin=969239655&open_ad=0");
			requestBuilder.param("location", "广东省广州市");
			requestBuilder.param("remark", "备注呵呵呵呵");
			
			// 文件
			String path = null;
			InputStream inputStream = null;
			MockMultipartFile file = null;
			// 
			// 第一部分
			path = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
			inputStream = new FileInputStream(path);
			//file = new MockMultipartFile("file", "白熊_01.jpg", "application/octet-stream", inputStream);
			file = new MockMultipartFile("file", "白熊_01.jpg", "", inputStream);
			requestBuilder.file(file);
			
			path = ClassPathUtil.getClassSubpath("/file/img/沉睡老虎.jpg", true);
			inputStream = new FileInputStream(path);
			//file = new MockMultipartFile("file", "白熊_01.jpg", "application/octet-stream", inputStream);
			file = new MockMultipartFile("file", "沉睡老虎.jpg", "", inputStream);
			requestBuilder.file(file);
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testAdd =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 删除帐户
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDelete() {
		try {
			// 页面/服务 地址
			String url = prefix + "/delete";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("token", "1");
			requestBuilder.param("id", "1");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testDelete =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 更新帐户
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUpdate() {
		try {
			// 页面/服务 地址
			String url = prefix + "/update";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("id", "1");
			//requestBuilder.param("username", "94521366");
			requestBuilder.param("status", "1");
			//requestBuilder.param("password", "123456");
			requestBuilder.param("level", "2");
			requestBuilder.param("type", "2");
			requestBuilder.param("source", "深圳市腾讯公司");
			requestBuilder.param("usage", "登录QQ 邮箱...");
			requestBuilder.param("relationalAccounts", "94521366@qq.com");
			requestBuilder.param("expireDate", "2018-10-13");
			requestBuilder.param("mobilePhone", "15213647585");
			requestBuilder.param("officialLink", "http://caibaojian.com/demo/power-slider/index2.html");
			requestBuilder.param("loginLink", "http://mail.qq.com/cgi-bin/loginpage?t=wx_logout&s=logout&f=html&uin=969239655&open_ad=0");
			requestBuilder.param("location", "广东省广州市");
			requestBuilder.param("remark", "备注呵呵呵呵");
			
			// 文件
			String path = null;
			InputStream inputStream = null;
			MockMultipartFile file = null;
			// 
			// 第一部分
			path = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
			inputStream = new FileInputStream(path);
			//file = new MockMultipartFile("file", "白熊_01.jpg", "application/octet-stream", inputStream);
			file = new MockMultipartFile("file", "白熊_01.jpg", "", inputStream);
			requestBuilder.file(file);
			
			path = ClassPathUtil.getClassSubpath("/file/img/沉睡老虎.jpg", true);
			inputStream = new FileInputStream(path);
			//file = new MockMultipartFile("file", "白熊_01.jpg", "application/octet-stream", inputStream);
			file = new MockMultipartFile("file", "沉睡老虎.jpg", "", inputStream);
			requestBuilder.file(file);			
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 修改帐户密码
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testModifyPwd() {
		try {
			// 页面/服务 地址
			String url = prefix + "/modifyPwd";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("token", "1");
			requestBuilder.param("id", "1");
			requestBuilder.param("username", "94521366");
			requestBuilder.param("password", "123456");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testModifyPwd =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 查看帐户
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testView() {
		try {
			// 页面/服务 地址
			String url = prefix + "/view";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("token", "1");
			requestBuilder.param("id", "1");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testView =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 查看密码，生成图片流
	 * @param request
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testViewPwd() {
		try {
			// 页面/服务 地址
			String url = "/file/data/o2omember/4e9fec03-94b2-4999-ac32-85cee8003b86.png";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("username", "admin");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			
			// 获取字符串形式的响应内容
			//String result = response.getContentAsString();
			
			//System.out.println(result);
			OutputStream outputStream =new FileOutputStream(ProjectUtil.getAbsolutePath("/doc/download/t.png", true));
			//outputStream.write(response.getContentAsByteArray());
			//outputStream.flush();
			IOUtils.write(response.getContentAsByteArray(), outputStream);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testViewPwd =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 搜索帐户
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSearch() {
		try {
			// 页面/服务 地址
			String url = prefix + "/search";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("username", "94521366");
			requestBuilder.param("status", "1");
			requestBuilder.param("level", "2");
			requestBuilder.param("type", "2");
			requestBuilder.param("source", "深圳市腾讯公司");
			//requestBuilder.param("usage", "登录QQ 邮箱...");
			// 有效期至(开始)
			requestBuilder.param("expireDateBegin", "2018-10-13");
			// 有效期至(结束) 
			requestBuilder.param("expireDateEnd", "2018-10-13");
			// 创建日期时间(开始)
			requestBuilder.param("createDateTimeBegin", "2015-10-13 11:02:03");
			// 创建日期时间(结束)
			requestBuilder.param("createDateTimeEnd", "2015-10-13 11:02:03");
			// 更新日期时间(开始)
			requestBuilder.param("updateDateTimeBegin", "2015-10-13 11:02:03");
			// 更新日期时间(结束)
			requestBuilder.param("updateDateTimeEnd", "2015-10-13 11:02:03");
			
			// 分页参数
			requestBuilder.param("currentPage", "1");
			requestBuilder.param("pageSize", "10");
			requestBuilder.param("needPage", "true");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testSearch =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMockMVC() {
		try {
			// 页面/服务 地址
			String url = prefix + "/";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("username", "admin");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testMockMVC =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 文件上传
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFileUpload() {
		try {
			// 页面/服务 地址
			String url = prefix + "/new/company/wx/upload";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockMultipartHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload(url);
			/*
			 * 设置请求参数
			 */
			// 销售人员ID
/*			requestBuilder.param("sellerID", "270593");
			// 公司卡号
			requestBuilder.param("companyCardNo", "95555551");
			// 公司名称
			requestBuilder.param("companyName", "广东农商银行总行");
			// 打款账户名
			requestBuilder.param("payName", "广州银行");
			// 公司营业执照编号
			requestBuilder.param("companyNo", "yingyezhi2015");
			// 邮寄地址
			requestBuilder.param("invoiceAddress", "广州天河区");
			// 微信ID
			requestBuilder.param("openId", "123456");
			// 店铺ID
			requestBuilder.param("storeId", "2");
			// 联系人姓名
			requestBuilder.param("concatName", "张先生");
			// 联系人-邮箱
			requestBuilder.param("concatMail", "admin1@163.com");
			//  联系人-手机号码
			requestBuilder.param("concatPhone", "15024657856");*/
			
			// 文件
			String path = null;
			InputStream inputStream = null;
			MockMultipartFile file = null;
			// 
			// 第一部分
			path = ClassPathUtil.getClassSubpath("/file/img/白熊_01.jpg", true);
			inputStream = new FileInputStream(path);
			//file = new MockMultipartFile("file", "白熊_01.jpg", "application/octet-stream", inputStream);
			file = new MockMultipartFile("file", "白熊_01.jpg", "", inputStream);
			requestBuilder.file(file);
		
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			
			System.out.println(result);
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testFileUpload =====> ", e);
		}
	}			
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDownload() {
		try {
			// 页面/服务 地址
			String url = "/file/data/o2omember/4e9fec03-94b2-4999-ac32-85cee8003b86.png";
			// 请求构建器
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("username", "admin");
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			
			// 获取字符串形式的响应内容
			//String result = response.getContentAsString();
			
			//System.out.println(result);
			OutputStream outputStream =new FileOutputStream(ProjectUtil.getAbsolutePath("/doc/download/t.png", true));
			//outputStream.write(response.getContentAsByteArray());
			//outputStream.flush();
			IOUtils.write(response.getContentAsByteArray(), outputStream);
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
			
			
		} catch (Exception e) {
			log.error("testDownload =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMockMVCExample() {
		try {
			// 页面/服务 地址
			String url = "/api/sys/login";
			// 请求构建器
			//RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// get 方法
			//MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url);
			// post 方法
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url);
			//String json = "{\"username\":\"admin\", \"password\":\"123456\"}";
			//requestBuilder.content(json);
			/*
			 * 设置请求参数
			 */
			requestBuilder.param("username", "admin");
			requestBuilder.param("password", "123456");
			//MockMvc mockMvc =  MockMvcBuilders.standaloneSetup(userController).build(); 
			
			// 模拟 mvc 对象，设置 WebApplicationContext，然后构建 模拟mvc对象
			MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); 
			// mvc 结果
			MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
			
			
			// 响应对象
			MockHttpServletResponse response = mvcResult.getResponse();
			// 获取字符串形式的响应内容
			String result = response.getContentAsString();
			System.out.println(result);
			
			//Map<String, Object> map = mvcResult.getModelAndView().getModel();
			//System.out.println(map);
			// 结果对象
			//Object resultObj = mvcResult.getAsyncResult();
			//System.out.println(resultObj.toString());
			
			// 异常对象
			//Exception exception = mvcResult.getResolvedException();
			
			
		} catch (Exception e) {
			log.error("testMockMVCExample =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
		
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
