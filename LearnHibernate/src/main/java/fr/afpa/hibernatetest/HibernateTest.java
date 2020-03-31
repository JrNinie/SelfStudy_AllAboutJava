package fr.afpa.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import fr.afpa.entities.User;
import fr.afpa.utils.HibernateUtils;

public class HibernateTest {

	//不利用HibernateUtils类创建
	@Test
	public void testAddWithoutUtils(){
		
		//1、加载hibernate核心配置文件
		//就是在src下面去找hibernate.cfg.xml并且加载封装
		Configuration cfg = new Configuration().configure();
		
		//2、创建sessionFactory对象
		//读取核心配置文件，根据映射关系创建表
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//3、使用sessionFactory创建session对象
		//类似于JDBC里面的连接connection
		Session session = sessionFactory.openSession();
		
		//4、开启事务
		Transaction tr = session.beginTransaction();
		
		
		//5、写具体逻辑crud操作
		User user = new User();
		//user.setUid(53); //Uid是自增长的，不需要手动设置。如果手动设置了，不会报错，但是不会是53，而是原本该有的数
		user.setUserName("Lucie");
		user.setPassword("123");
		user.setAddress("3 M Street");
		
		session.save(user);
		
		//6、提交事务
		tr.commit();
		
		//7、关闭资源
		session.close();
		sessionFactory.close();
	}
	
	
	//利用HibernateUtils类创建
		@Test
		public void testAddWithUtils() {
			//1,2,3都在这
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			//4、开启事务
			Transaction tr = session.beginTransaction();
			
			
			//5、写具体逻辑crud操作
			User user1 = new User();
			User user2 = new User();
			User user3 = new User();
			//user.setUid(53); //Uid是自增长的，不需要手动设置。如果手动设置了，不会报错，但是不会是53，而是原本该有的数
			user1.setUserName("Lola");
			user1.setPassword("123456");
			user1.setAddress("89 M Street");
			
			user2.setUserName("Lucie");
			user2.setPassword("123456");
			user2.setAddress("12 M Street");
			
			user3.setUserName("Charlotte");
			user3.setPassword("1456");
			user3.setAddress("9 M Street");
			
			session.save(user1);
			session.save(user2);
			session.save(user3);
			
			//6、提交事务
			tr.commit();
			
			//7、关闭资源（这里就不能再关闭sessionFactory了，否则其它地方用不到啊）
			session.close();
			//sessionFactory.close(); //删除
		}
		
		
		@Test
		public void testGet() {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			//第一个参数：实体类的名字
			//第二个参数：ID的值
			User u = session.get(User.class, 3);
			System.out.println(u);
			
			tr.commit();
			session.close();	
		}
		
		
		@Test
		public void testUpdate() {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			

			User u = session.get(User.class, 2);
			u.setUserName("Leo");
			session.update(u);
			
			System.out.println(u);
			
			tr.commit();
			session.close();
			
		}
		
		
		@Test
		public void testDelete() {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			

			User u = session.get(User.class, 2);
			session.delete(u);
			
			System.out.println(u);
			
			tr.commit();
			session.close();
			
		}
		
		
		@Test
		public void testGet2Times() {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			

			User u1 = session.get(User.class, 3);
			System.out.println(u1);
			User u2 = session.get(User.class, 3);
			System.out.println(u2);

			
			tr.commit();
			session.close();
			
		}
		
		
		@Test
		public void testUpdateWithoutUpdate() {
			SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			

			User u1 = session.get(User.class, 3);
			u1.setUserName("Lea");
			//session.update(u1);

			
			tr.commit();
			session.close();
			
		}
		
		
		
		@Test
		public void testRollback() {
			SessionFactory sessionFactory = null;
			Session session = null;
			Transaction tr = null;
			try{
				sessionFactory = HibernateUtils.getSessionFactory();
				session = sessionFactory.openSession();
				//开启事务
				tr = session.beginTransaction();
				
				User user1 = new User();
				user1.setUserName("Sandie");
				user1.setPassword("123456");
				user1.setAddress("80 M Street");
				//模拟异常
				//int i = 9/0;
				session.save(user1);
				
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
		
		//绑定线程
		@Test
		public void testSessionThread() {
			Session session = null;
			Transaction tr = null;
			try{
				
				session = HibernateUtils.getSessionObject();
				//开启事务
				tr = session.beginTransaction();
				
				User user1 = new User();
				user1.setUserName("Claudine");
				user1.setPassword("123456");
				user1.setAddress("70 M Street");
				session.save(user1);
				
				//提交事务
				tr.commit();
			}catch(Exception e){
				e.printStackTrace();
				//回滚事务
				tr.rollback();
			}finally{
				//不再需要手动关闭资源，要删除，否则报错
				//session.close();	
			}
		}
}
