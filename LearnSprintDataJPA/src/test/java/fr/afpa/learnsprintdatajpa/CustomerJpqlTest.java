package fr.afpa.learnsprintdatajpa;

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
public class CustomerJpqlTest {
	
	@Autowired
	private ICustomerDao customerDao;
	
	
	@Test
	public void testFindById() {
		Customer c  = customerDao.findByCustomerName("Lucie");
		System.out.print(c);
		
	}
	
	
	@Test
	public void testFindByCustomerNameAndId() {
		Customer c  = customerDao.findByCustomerNameAndId(8L,"Xinpa");
		System.out.print(c);
		
	}
	
	@Test
	/*
	 默认情况下， SpringData 的每个方法上有事务， 但都是一个只读事务。 他们不能完成修改/删除操作。
	 Update或者delete都需要添加事务的支持@Transactional，而且默认就是Rollback = true
	 因此虽然执行了，但是数据库并不会更新
	 所以要手动把Rollback改为false
	 */
	@Transactional 
	@Rollback (value= false)
	public void testUpdateNameById() {
		customerDao.updateNameById("New Francois", 2L);	
	}
	
}
