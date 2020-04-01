package fr.afpa.learnjpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactoryUtils {

	private static EntityManagerFactory factory;
	
	//通过静态代码块的形式，当程序第一次访问此工具类的时候便创建一个公共的实体类管理工厂对象EntityManagerFactory
	static {
		factory = Persistence.createEntityManagerFactory("myJpa");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
