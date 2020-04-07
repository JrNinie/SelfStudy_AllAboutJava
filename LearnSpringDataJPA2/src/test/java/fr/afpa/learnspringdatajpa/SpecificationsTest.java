package fr.afpa.learnspringdatajpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afpa.learnspringdatajpa.dao.ICustomerDao;
import fr.afpa.learnspringdatajpa.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext.xml")
public class SpecificationsTest {
	
	@Autowired
	private ICustomerDao customerDao;
	
	/*
	 自定义查询步骤：
	 	1、实现Specification接口（提供泛型：要查询的对象类型）
	 	2、实现toPredicate方法（构造查询条件）
	 	3、借助方法参数中的两个参数：
	 		Root<Customer>: 获取需要查询对象的各种属性root.get("custName")
	 		CriteriaBuilder: 它内部封装了很多查询条件，可以用它来构造查询条件
	 		
	 */
	
	@Test 
	public void testFindOneSpec() {
		Specification<Customer> spec  = new Specification<Customer>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//通过root获取需要比较的属性（实体类的属性，不是表的字段名）
				Path<Object> nameInEntity = root.get("custName");
				//利用criteriaBuilder里的方法equal进行比较：
				Predicate predicate = criteriaBuilder.equal(nameInEntity, "Linda");
				return predicate;
			}
		};
		Optional<Customer> c = customerDao.findOne(spec);
		System.out.println(c.get());
	}
	

	//用lambda表达式把上面的写了一遍
	@Test 
	public void testFindOneSpecLambda() {
		
		Specification<Customer> spec  = (root, query, cb) -> {
				return cb.equal(root.get("custName"), "Linda");
			};

		Optional<Customer> c = customerDao.findOne(spec);
		System.out.println(c.get());
	}
	
	
	//动态多条件查询并排序：查询客户名叫Lisa(Like)并且行业是transport(=)的客户
	@Test
	public void testFindOneSpecLisa() {
		Specification<Customer> spec = (root,query, cb)->{
			Predicate p1 = cb.equal(root.get("custIndustry"), "transport");
			//现在不指明as(String.class)也是可以的
			//Predicate p2 = cb.like(root.get("custName").as(String.class), "Lisa%");
			Predicate p2 = cb.like(root.get("custName"), "Lisa%");
			//and : 同时满足p1和p2
			//or: p1和p2满足其中一个即可
			return cb.and(p1, p2);
		};
		
		//Sort.by("custId")默认是升序asc
		//List<Customer> list = customerDao.findAll(spec, Sort.by("custId"));
		List<Customer> list = customerDao.findAll(spec, Sort.by(Direction.DESC, "custId"));
		for(Customer c : list) {
			System.out.println(c);
		}
	}
	
	//分页显示
	/*
	 findAll(Specification spec, pageable) :带有条件的分页
	 findAll(Pageable pageable): 没有条件的分页
	 */
	@Test
	public void testPage() {
		//这里为了方便写了Null，否则可以自己写个条件的
		Specification spec = null;
		/*
		 PageRequest是Pageable的实现类
		 	PageRequest.of(page, size)
		 		page: 从哪一页开始显示（第一页是0，第二页是1）
		 		size：每页显示的条数
		 */
		Pageable pageable = PageRequest.of(1, 3);
		Page<Customer> page = customerDao.findAll(spec, pageable);
		System.out.println(page.getContent());//得到数据集合列表
		System.out.println(page.getTotalElements());//得到总条数
		System.out.println(page.getTotalPages());//得到总页数
		
	}
	
}
