/**
 * 描述: 
 * CoreDaoTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.dao;

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

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.DictItem;
import com.hua.bean.common.Pager;
import com.hua.dao.DictDao;
import com.hua.entity.Dict;
import com.hua.test.BaseDaoTest;
import com.hua.util.SqlUtil;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * CoreDaoTest
 */
public class CoreDaoTest extends BaseDaoTest {

	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	@Resource
	private DictDao dictDao;
	
	/**
	 * 
	 * 描述: 
	 * 注意，在测试方法上加事务注解时，需要将该测试类改为非final类
	 * @author qye.zheng
	 */
	@Test
	public void testInsert() {
		try {
			Dict dict = new Dict();
			dict.setCode("test_code_001");
			dict.setValue("1");
			dict.setText("中文提示啊a");
			dict.setRemark("afkajflkasjflkasjlkfjaslkdf");
			
			dictDao.insert(dict);
			//dictDao.getEntityManager().persist(dict);

			
		} catch (Exception e) {
			log.error("testInsert =====> ", e);
		}
	}
		
	/**
	 * 
	 * 描述: 
	 * 注意，在测试方法上加事务注解时，需要将该测试类改为非final类
	 * @author qye.zheng
	 */
	@Test
	public void testDelete() {
		try {
			
			Integer id = 26;
			dictDao.delete(id);
			
		} catch (Exception e) {
			log.error("testDelete =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 注意，在测试方法上加事务注解时，需要将该测试类改为非final类
	 * @author qye.zheng
	 */
	@Test
	public void testUpdate() {
		try {
			Dict dict = new Dict();
			dict.setId(30);
			dict.setCode("haha_dd");
			dict.setValue("212");
			//dict.setText("中11");
			dict.setRemark("hhhhhh");
			
			dictDao.update(dict);

			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 注意，在测试方法上加事务注解时，需要将该测试类改为非final类
	 * @author qye.zheng
	 */
	@Test
	public void testUpdate2() {
		try {
			Dict dict = new Dict();
			dict.setId(24);
			dict.setCode("haha_dd");
			dict.setValue("212");
			dict.setText("中文提ddd示啊a");
			//dict.setRemark(null);
			dictDao.update(dict);

			
		} catch (Exception e) {
			log.error("testUpdate2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 注意，在测试方法上加事务注解时，需要将该测试类改为非final类
	 * @author qye.zheng
	 */
	@Test
	public void testGet() {
		try {
			Integer id = 28;
			Dict dict = dictDao.get(id);
			System.out.println(dict.toString());
			//dictDao.getEntityManager().persist(dict);

			
		} catch (Exception e) {
			log.error("testGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * 注意，在测试方法上加事务注解时，需要将该测试类改为非final类
	 * @author qye.zheng
	 */
	@Test
	public void testSearch() {
		try {
			Pager<DictItem> pager = new Pager<DictItem>();
			pager.setCurrentPage(1);
			pager.setPageSize(2);
			pager.setNeedPage(true);
			final DictItem searchBean = new DictItem();
			searchBean.setCode("level");
			searchBean.setStatus(1);
			//searchBean.setRemark("hhhhhh");
			searchBean.setRemark(SqlUtil.likeQuery("hhhhhh", true, true));
			dictDao.search(pager, searchBean);
			System.out.println(pager.getCurrentPage());
			System.out.println(pager.getDataSize());
			System.out.println(pager.getBeanList().get(0).getText());
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
	public void testSpringJunit() {
		try {
	
			
		} catch (Exception e) {
			log.error("testSpringJunit =====> ", e);
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
			//org.springframework.data.redis.connection.jedis.JedisConnectionFactory a;
			
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
