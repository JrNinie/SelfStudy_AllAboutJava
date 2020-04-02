package fr.afpa.learnjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import org.junit.Test;

import fr.afpa.learnjpa.entities.Customer;
import fr.afpa.learnjpa.utils.EMFactoryUtils;

public class JpaTest {

	
	/*
	 jap的操作步骤
	 1.通过加载配置文件persistence.xml，创建工厂对象（实体管理器工厂 EntityManagerFactory）
	 2.通过实体管理器工厂获取实体管理器EntityManager
	 3.获取事务对象
	 4.开启事务
	 5.CRUD操作
	 6.提交事务commit/回滚事务rollback
	 7.释放资源
	 */

	
	@Test
	public void testSaveWithoutUtils() {
		//1.通过加载配置文件persistence.xml，创建工厂对象（实体管理器工厂 EntityManagerFactory）
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa"); //填入在核心配置文件中自己给persistence-unit起的名字
		//2.通过实体管理器工厂获取实体管理器EntityManager
		EntityManager em = factory.createEntityManager();
		//3.获取事务对象
		EntityTransaction tx = em.getTransaction(); //注意：返回的是EntityTransaction，而不是Transaction
		//4.开启事务
		tx.begin();
		
		//5.CRUD操作
		Customer c1 = new Customer();
		c1.setCustName("Francois");
		em.persist(c1);
	
		//6.提交事务commit
		tx.commit();
		
		//7.释放资源:与开启的顺序要相反，先关em，后关factory
		em.close();
		factory.close();
	}

	@Test
	public void testFindWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer cst = em.find(Customer.class, 1L);
		System.out.println("通过find得到的customer实体是"+cst);
		
		tx.commit();
		em.close();	
		//这里就没有之前的factory.close()了，因为整个程序共用一个EntityManagerFactory,你关了，别人怎么用啊
	}
	
	
	//测试find和getReference的区别(其实在具体使用时没有啥区别啊)
	//find立即加载，getReference延迟加载
	@Test
	public void testGetReferenceWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer cst = em.getReference(Customer.class, 6L);
		String name  = cst.getCustName();
		Customer newCst = new Customer();
		newCst.setCustName(name);
		newCst.setCustIndustry("transport");
		em.persist(newCst);
		
		
		tx.commit();
		em.close();	
	}
	
	@Test
	public void testRemoveWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer cst = em.getReference(Customer.class, 6L);
		em.remove(cst);
				
		tx.commit();
		em.close();	
	}
	
	@Test
	public void testMergeWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Customer cst = em.getReference(Customer.class, 5L);
		cst.setCustMobile("0677889900");
		em.merge(cst);
				
		tx.commit();
		em.close();	
	}
	
}

