package fr.afpa.learnsprintdatajpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afpa.learnsprintdatajpa.dao.ICustomerDao;
import fr.afpa.learnsprintdatajpa.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring环境下提供的测试环境
@ContextConfiguration(locations ="classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerSqlTest {
	
	@Autowired
	private ICustomerDao customerDao;
	
	
	@Test
	public void testFindAllSql() {
		List<Object[]> list = customerDao.findAllSql();
		
		//返回值是List<Object[]>，遍历用：
		for(Object[] obj: list) {
			System.out.print(Arrays.toString(obj));
		}
	}
	
	
	
}
