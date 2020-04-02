package fr.afpa.learnjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.junit.Test;

import fr.afpa.learnjpa.entities.Customer;
import fr.afpa.learnjpa.utils.EMFactoryUtils;

public class JPQLTest {

	/*
	 jaql的操作步骤
	 1.通过加载配置文件persistence.xml，创建工厂对象（实体管理器工厂 EntityManagerFactory）
	 2.通过实体管理器工厂获取实体管理器EntityManager
	 3.获取事务对象
	 4.开启事务
	 5.CRUD操作
	 	5.1.写JPQL语句
	 	5.2.创建query对象
	 	5.3.对参数赋值（不一定有这个步骤）
	 	5.4.发送查询并封装结果集
	 6.提交事务commit/回滚事务rollback
	 7.释放资源
	 */
	
	@Test
	public void testFindAllWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//写JPQL语句
		//String jpql = "FROM t_customer"; //wrong!这里操作的是实体类，不是表
		String jpql = "FROM Customer";
	 	//创建query对象
		Query query = em.createQuery(jpql);
	 	//发送查询并封装结果集(结果有多个getResultList;只有一个结果getSingleResult)
		List list  = query.getResultList();
		
		for(Object c : list) {
			System.out.println(c);
		}
		
		tx.commit();
		em.close();	
	}
	
	//根据id倒序查询
	@Test
	public void testFindAllDescWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		String jpql = "FROM Customer ORDER BY custId DESC";
		Query query = em.createQuery(jpql);
		List list  = query.getResultList();
		
		for(Object c : list) {
			System.out.println(c);
		}
		
		tx.commit();
		em.close();	
	}
	
	@Test
	public void testCountWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		String jpql = "SELECT COUNT(custId) FROM Customer";
		Query query = em.createQuery(jpql);
		//结果有多个getResultList;
		//只有一个结果getSingleResult,返回的是object，如果有需要可以cast
		Object o = query.getSingleResult();
		System.out.println(o);
		
		tx.commit();
		em.close();	
	}
	
	//分页查询（需要对参数赋值）
	@Test
	public void testPageWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		//sql查询语句： SELECT * FROM t_customer LIMIT ?,? (当第一个？是0的时候可以写成 SELECT * FROM t_customer LIMIT ?)
		//jpql查询语句： FROM Customer （然后再去后面设置setFirstResult和setMaxResult）
		String jpql = "FROM Customer";
		Query query = em.createQuery(jpql);
		
	 	//对参数赋值
		//起始索引
		query.setFirstResult(0);
		//每页查询的条数
		query.setMaxResults(3);
		
		List list  = query.getResultList();
		
		for(Object c : list) {
			System.out.println(c);
		}
		
		tx.commit();
		em.close();	
	}
	
	
	//查找以L开头的名字（需要对参数赋值）
	@Test
	public void testFindSthWithUtils() {
		EntityManager em = EMFactoryUtils.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			
		//sql查询语句： SELECT * FROM t_customer WHERE cust_name LIKE ？
		//jpql查询语句： FROM Customer WHERE custName LIKE ？ //必须在后面加数字，指定parameter
		String jpql = "FROM Customer WHERE custName LIKE ?1";
		Query query = em.createQuery(jpql);
		
	 	query.setParameter(1,"L%");
	 	
		
		List list  = query.getResultList();
		
		for(Object c : list) {
			System.out.println(c);
		}
		
		tx.commit();
		em.close();	
	}
}
