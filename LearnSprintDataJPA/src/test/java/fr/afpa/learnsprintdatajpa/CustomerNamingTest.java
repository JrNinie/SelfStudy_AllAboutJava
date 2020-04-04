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
public class CustomerNamingTest {
	
	@Autowired
	private ICustomerDao customerDao;
	
	
	@Test
	public void testFindByCustName() {
		 Customer c = customerDao.findByCustName("Lisa");
		 System.out.println(c);
	}
	
	
	@Test
	public void testFindByCustNameLike() {
		 List<Customer> list = customerDao.findByCustNameLike("L%");
		 
		 for(Customer c : list) {
			 System.out.println(c);
		 }
	}
	
	
	@Test
	public void testFindByCustNameLikeAndCustIndustry() {
		 List<Customer> list = customerDao.findByCustNameLikeAndCustIndustry("Li%", "transport");
		 
		 for(Customer c : list) {
			 System.out.println(c);
		 }
	}
}
