package fr.afpa.hibernatetest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import fr.afpa.entities.User;
import fr.afpa.utils.HibernateUtils;

public class QueryDataTest {

		
		@Test
		public void testQuery() {
			SessionFactory sessionFactory = null;
			Session session = null;
			Transaction tr = null;
			try{
				sessionFactory = HibernateUtils.getSessionFactory();
				session = sessionFactory.openSession();
				//开启事务
				tr = session.beginTransaction();
				
				//1、创建Query对象
				Query query = session.createQuery("from User");
				//2、调用Query对象里的方法得到结果
				List<User> list  = query.list();
				
				for(User user : list) {
					System.out.println(user);
				}
				//提交事务
				tr.commit();
			}catch(Exception e){
				e.printStackTrace();
				//回滚事务
				tr.rollback();
			}finally{
				//关闭资源
				session.close();
				sessionFactory.close();
			}
			
		}
		
		
		@Test
		public void testCriteria() {
			SessionFactory sessionFactory = null;
			Session session = null;
			Transaction tr = null;
			try{
				sessionFactory = HibernateUtils.getSessionFactory();
				session = sessionFactory.openSession();
				//开启事务
				tr = session.beginTransaction();
				
				//1、创建Critieria对象
				Criteria critierie = session.createCriteria(User.class);
				//2、调用Query对象里的方法得到结果
				List<User> list  = critierie.list();
				
				for(User user : list) {
					System.out.println(user);
				}
				//提交事务
				tr.commit();
			}catch(Exception e){
				e.printStackTrace();
				//回滚事务
				tr.rollback();
			}finally{
				//关闭资源
				session.close();
				sessionFactory.close();
			}
			
		}
		
		
		
		@Test
		public void testSQLQuery() {
			SessionFactory sessionFactory = null;
			Session session = null;
			Transaction tr = null;
			try{
				sessionFactory = HibernateUtils.getSessionFactory();
				session = sessionFactory.openSession();
				//开启事务
				tr = session.beginTransaction();
				
				//1、创建SQLQuery对象
				SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
				//2、指定返回的每部分为对象，而不是默认的数组
				//如果没有这一步的话，返回的list里面每个部分都是list，便利比较复杂Array.toString
				sqlQuery.addEntity(User.class);
				
				//3、调用Query对象里的方法得到结果
				List<User> list = sqlQuery.list();
				
				for(User user : list) {
					System.out.println(user);
				}
				//提交事务
				tr.commit();
			}catch(Exception e){
				e.printStackTrace();
				//回滚事务
				tr.rollback();
			}finally{
				//关闭资源
				session.close();
				sessionFactory.close();
			}
			
		}
}
