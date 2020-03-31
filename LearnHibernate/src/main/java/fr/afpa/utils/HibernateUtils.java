package fr.afpa.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final Configuration configuration;
	private static final SessionFactory sessionFactory;
	
	static {
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();			
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//这个方法返回一个与本地线程绑定的session，用了这个session之后是不需要手动关闭session的
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}
	
}
