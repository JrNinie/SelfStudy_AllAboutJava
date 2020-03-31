package fr.afpa.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import fr.afpa.entities.Role;
import fr.afpa.entities.User;
import fr.afpa.utils.HibernateUtils;

public class User_Role_Demo {

	//还没有设置cascade之前的添加
	@Test
	public void addDemo() {
		
		Session session = null;
		Transaction tr = null;
		try{
			
			session = HibernateUtils.getSessionObject();
			tr = session.beginTransaction();
			
			User user1 = new User();
			user1.setUserName("Claudine");
			User user2 = new User();
			user2.setUserName("Sandra");
			
			
			Role role1 = new Role();
			role1.setRoleName("RH");
			Role role2 = new Role();
			role2.setRoleName("Marketing");
			Role role3 = new Role();
			role3.setRoleName("IT");
	
			//A
			user1.getRoles().add(role1);
			user1.getRoles().add(role2);
			user2.getRoles().add(role2);
			user2.getRoles().add(role3);

			//B
			role1.getUsers().add(user1);
			role2.getUsers().add(user1);
			role2.getUsers().add(user2);
			role3.getUsers().add(user2);
			
			//这里A和B只能选择一个，另外一个要删除
			//因为目前user和role两个都能控制添加表的外键，所以会重复，一旦重复，就报错
			//所以，如果要保留A和B两个，被动方（role）必须放弃外键维护权
			
			session.save(user1);
			session.save(user2);
			session.save(role1);
			session.save(role2);
			session.save(role3);

			tr.commit();
		}catch(Exception e){
			e.printStackTrace();
			tr.rollback();
		}
	}
	
	
	@Test
	public void Demo2() {
		
		Session session = null;
		Transaction tr = null;
		try{
			
			session = HibernateUtils.getSessionObject();
			tr = session.beginTransaction();
			
			User user1 = session.get(User.class, 1L);
			Role role3 = session.get(Role.class, 3L);
 			user1.getRoles().add(role3);

 			session.update(user1);
 			
			tr.commit();
		}catch(Exception e){
			e.printStackTrace();
			tr.rollback();
		}
	}
	
}
