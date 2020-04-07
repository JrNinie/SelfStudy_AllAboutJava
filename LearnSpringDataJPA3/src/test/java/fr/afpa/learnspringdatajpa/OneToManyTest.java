package fr.afpa.learnspringdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afpa.learnspringdatajpa.dao.IContactDao;
import fr.afpa.learnspringdatajpa.dao.ICustomerDao;
import fr.afpa.learnspringdatajpa.domain.Contact;
import fr.afpa.learnspringdatajpa.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class OneToManyTest {
	
	@Autowired
	private ICustomerDao customerDao;
	private IContactDao contactDao;
	
	//通过customer级联添加contact
	/*
	 条件：
	    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
		private Set<Contact> contacts = new HashSet<>();
	 
	 	@ManyToOne(targetEntity=Customer.class)
		@JoinColumn(name="cust_id")
		private Customer customer;
	 */
	
	@Test
	@Transactional
	@Rollback(false)
	public void testAddCascade() {
		Customer cst  = new Customer();
		cst.setCustName("Boud");
		
		Contact c  = new Contact();
		c.setcName("Sandra");
		c.setcPosition("CEO");
		
		//因为在Customer里面设置了cascade，
		//所以只要保存Customer，加上下面这句话，当保存customer时就会自动保存contact
		cst.getContacts().add(c);
		//加上下面这句，contact里面的外键才会书写，因为只有contact有外键维护权
		c.setCustomer(cst);
		
		customerDao.save(cst);
		
	}
	
	
	//通过customer级联删除contact
		/*
		 条件：
		    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
			private Set<Contact> contacts = new HashSet<>();
		 
		 	@ManyToOne(targetEntity=Customer.class)
			@JoinColumn(name="cust_id")
			private Customer customer;
		 */
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteCascade() {
		Optional<Customer> c = customerDao.findById(1L);
		customerDao.delete(c.get());
		
	}
}
