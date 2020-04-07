package fr.afpa.learnspringdatajpa;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afpa.learnspringdatajpa.dao.IContactDao;
import fr.afpa.learnspringdatajpa.dao.ICustomerDao;
import fr.afpa.learnspringdatajpa.domain.Contact;
import fr.afpa.learnspringdatajpa.domain.Customer;

//对象导航查询测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class QueryTest {
	
	@Autowired
	private ICustomerDao customerDao;
	private IContactDao contactDao;
	
	
	//对象导航查询：查询一个对象的时候，通过此对象查询所有的关联对象
	@Test
	@Transactional //开启事务，否则会有no session错误
	public void testFindQuery() {
		Customer cst = customerDao.getOne(1L);
		Set<Contact> list  = cst.getContacts();
		for(Contact c : list) {
			System.out.println(c);
		}
		
	}
	
	
	
}
