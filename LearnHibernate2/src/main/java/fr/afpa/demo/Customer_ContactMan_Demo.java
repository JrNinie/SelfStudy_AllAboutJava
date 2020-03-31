package fr.afpa.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import fr.afpa.entities.ContactMan;
import fr.afpa.entities.Customer;
import fr.afpa.utils.HibernateUtils;

//one to many test
public class Customer_ContactMan_Demo {

	//建立 2 customers 和 3 contactmen
	//两边都保存
	@Test
	public void createDemo() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tr = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session =sessionFactory.openSession();
			
			tr = session.beginTransaction();
			
			Customer cst1 = new Customer();
			cst1.setCust_name("Toulouse Bank");
			
			Customer cst2 = new Customer();
			cst2.setCust_name("Tisseo");
			
			ContactMan c1 = new ContactMan();
			c1.setCm_name("Lucie");
			c1.setCst(cst1);
			
			ContactMan c2 = new ContactMan();
			c2.setCm_name("Lea");
			c2.setCst(cst1);
			
			ContactMan c3 = new ContactMan();
			c3.setCm_name("Julien");
			c3.setCst(cst2);
			
			
			
			session.save(cst1);
			session.save(cst2);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			tr.commit();
		}catch(Exception e) {
			System.out.println("exception");
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}	
	}
	
	
	//只保存一边是否可以
	//不可以，会有TransientObjectException
	@Test
	public void createDemo2() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tr = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session =sessionFactory.openSession();
			
			tr = session.beginTransaction();
			
			Customer cst1 = new Customer();
			cst1.setCust_name("Bordeau Bank");
	
			ContactMan c1 = new ContactMan();
			c1.setCm_name("Sandra");
			c1.setCst(cst1);

			//一定两边都要保存，否则会有错误
			session.save(cst1);
			session.save(c1);
			
			tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}	
	}
	
	//进行级联操作：通过只保存customer，级联其contactman
	//操作的主体是customer，所以要去customer.hbm.xml里面进行配置
	//<set name="contactMen" cascade="save-update">
	@Test
	public void createDemo3() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tr = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session =sessionFactory.openSession();
			
			tr = session.beginTransaction();
			
			Customer cst1 = new Customer();
			cst1.setCust_name("Lilly Bank");
	
			ContactMan c1 = new ContactMan();
			c1.setCm_name("Julie");
			
			
			cst1.getContactMen().add(c1);
			c1.setCst(cst1);


			session.save(cst1);
			
			tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}	
	}
	
	
	//进行级联操作：通过只保存contactman，级联其customer
	//操作的主体是contactman，所以要去contactman.hbm.xml里面进行配置
	//<many-to-one name="cst" class="fr.afpa.entities.Customer" column="cm_cust_id" cascade="save-update"></many-to-one>
	@Test
	public void createDemo4() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tr = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session =sessionFactory.openSession();
			
			tr = session.beginTransaction();
			
			Customer cst1 = new Customer();
			cst1.setCust_name("Caca Bank");
	
			Customer cst2 = new Customer();
			cst2.setCust_name("TRAP");
			
			ContactMan c1 = new ContactMan();
			c1.setCm_name("Luc");
			c1.setCst(cst1);
			
			ContactMan c2 = new ContactMan();
			c2.setCm_name("Sandie");
			c2.setCst(cst1);
			
			ContactMan c3 = new ContactMan();
			c3.setCm_name("Linda");
			c3.setCst(cst2);
			
			
			cst1.getContactMen().add(c1);
			cst1.getContactMen().add(c2);
			cst2.getContactMen().add(c3);
			
			c1.setCst(cst1);
			c2.setCst(cst1);
			c3.setCst(cst2);


			session.save(c1);
			session.save(c2);
			System.out.println("before save c3");
			session.save(c3);
			
			
			Customer cst = session.get(Customer.class, 1L);
			System.out.println(cst);
			session.delete(cst);
			
			tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}	
	}
	
	//??还有问题：无法查找，sessionFactory有问题
	//级联删除：通过删除customer，删除其所有的contactman
	//<set name="contactMen" cascade="save-update,delete">
	@Test
	public void Demo5() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tr = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session =sessionFactory.openSession();
			
			tr = session.beginTransaction();
			
			Customer cst = session.get(Customer.class, 1L);
			System.out.println(cst);
			session.delete(cst);
			
			tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}	
	}
	
	//cascade和inverse的不同
	@Test
	public void Demo6() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tr = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session =sessionFactory.openSession();
			
			tr = session.beginTransaction();
			
			Customer cst1 = new Customer();
			cst1.setCust_name("Caca Bank");
			
			ContactMan c1 = new ContactMan();
			c1.setCm_name("Luc");
			
			cst1.getContactMen().add(c1);
			
			//前提条件：
			//customer : <set name="contactMen" cascade="save-update,delete" inverse="true">
			//contactman : <many-to-one name="cst" cascade="save-update" class="fr.afpa.entities.Customer" column="cm_cust_id" />
			session.save(cst1);
			//结果会保存cst1和c1(因为但凡保存cst1就会连级cascade保存c1)
			//但是c1里的外键为null，因为customer已经放弃了对外键的操作inverse="true"
	
			tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			session.close();
		}	
	}
}
