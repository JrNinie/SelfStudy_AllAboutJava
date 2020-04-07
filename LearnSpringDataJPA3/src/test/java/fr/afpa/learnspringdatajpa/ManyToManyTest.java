package fr.afpa.learnspringdatajpa;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.afpa.learnspringdatajpa.dao.IRoleDao;
import fr.afpa.learnspringdatajpa.dao.IUserDao;
import fr.afpa.learnspringdatajpa.domain.Role;
import fr.afpa.learnspringdatajpa.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class ManyToManyTest {
	
	@Autowired
	private IUserDao userDao;
	private IRoleDao roleDao;
	
	//保存一个用户就级联保存相关的角色
	@Test
	@Transactional
	@Rollback(false)
	public void testAdd() {
		User u = new User();
		u.setuName("Lea");
		
		Role r  = new Role();
		r.setrName("dev");
		
		u.getRoles().add(r);
		
		userDao.save(u);
		
	}
	
	
	
	//删除一个用户就级联保存相关的角色
	@Test
	@Transactional
	@Rollback(false)
	public void testDelete() {
		Optional<User> u = userDao.findById(1L);
		userDao.delete(u.get());
		
	}
	
}
