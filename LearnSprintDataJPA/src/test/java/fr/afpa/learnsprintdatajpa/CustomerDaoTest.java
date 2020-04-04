package fr.afpa.learnsprintdatajpa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
	
	//从2.0版本开始，以前的findOne变成了findById,而且返回值也变成了optional
	//可以参考https://stackoverflow.com/questions/49316751/spring-data-jpa-findone-change-to-optional-how-to-use-this
	@Test
	public void testFindById() {
		Optional<Customer> c = customerDao.findById(22L);
		if(c.isPresent()) {
			System.out.println(c.get());
		}else {
			System.out.println("the customer doesn't exist");
		}
		
	}
	
	/*
	 getOne和findById的区别
	 	findById： em.find()立即加载
	 	getOne:	em.getReference()延迟加载（返回的是一个动态代理对象，什么时候用，什么时候才查询）
	 */
	@Transactional //没有这个@会报错，显示could not initialize proxy no Session
	@Test
	public void testGetOne() {
		Customer c = customerDao.getOne(2L);
		System.out.println(c);
	}
	
	
	//保存一个新客户save
	//但是其实sava除了可以保存，还可以跟新（如果设置id，并且该id在数据库中是存在的）
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setCustName("Lily");
		c.setCustIndustry("education");
		c.setCustLevel("vip");
		customerDao.save(c);
	}
	
	
	//想要通过save去更新一个已经存在的custumor，并且id是正确的
	//结果就是：修改了名字，但是其它之前保存的内容全部变成了Null
	@Test
	public void testSaveUpdateWithRingtId() {
		Customer c = new Customer();
		c.setCustId(8L); //这里一定要给出正确的id
		c.setCustName("Xinpa");
		customerDao.save(c);
	}
	
	//想要通过save去更新一个已经存在的custumor，但是id给错了
	//结果就是：创建新的一行数据，id是自增的，不会用我们给的错误id
	@Test
	public void testSaveUpdateWithWrongId() {
		Customer c = new Customer();
		c.setCustId(18L); 
		c.setCustName("Lily2");
		customerDao.save(c);
	}

	
	@Test
	public void testDelete() {
		customerDao.deleteById(9L);
	}
	
	@Test
	public void testFindAll() {
		List<Customer> customers = customerDao.findAll();
		for(Customer c : customers) {
			System.out.println(c);
		}
	}
	
	
	@Test
	public void testCount() {
		long count  = customerDao.count();
		System.out.println(count);
		
	}
	
	
	@Test
	public void testExists() {
		Boolean isExists = customerDao.existsById(88L);
		System.out.println(isExists);
		
	}
	
	
	
}
