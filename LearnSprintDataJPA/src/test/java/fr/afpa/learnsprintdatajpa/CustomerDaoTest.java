package fr.afpa.learnsprintdatajpa;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afpa.learnsprintdatajpa.dao.ICustomerDao;
import fr.afpa.learnsprintdatajpa.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)//声明spring环境下提供的测试环境
@ContextConfiguration(locations ="classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerDaoTest {
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Test
	public void testFindOne() {
		Optional<Customer> c = customerDao.findById(2L);
		System.out.println(c.get());
	}

	
}
