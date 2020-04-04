package fr.afpa.learnsprintdatajpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.afpa.learnsprintdatajpa.domain.Customer;

/*
 符合springdatajpa的dao层接口的规范：
 	-继承JpaRepository<T, ID>， T指操作的实体类类型，ID指实体类中主键属性的类型
 		封装了基本的CRUD操作
 	-继承JpaSpecificationExecutor<T>， T指操作的实体类类型
 		封装了复杂的查询（分页等）
 */

public interface ICustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	


	//通过名字找到顾客信息
	//@Query代表的是进行查询，如果要进行update/delete还要加上@Modifying
	@Query(value="FROM Customer WHERE custName = ?1")
	public Customer findByCustomerName(String name);
	
	//通过名字和Id找到顾客信息
	/*
	 写jpql语句两种方法：
	 1.？加索引
	 一定要指定占位符的索引的位置
	 custName = ?2 表示拿传入的第二个参数name
	 custId =?1 表示拿传入的第一个参数id
	 一定要做到一一对应，否则会出错哦
	 
	 2.：加名称
	 在参数里面写@Param
	 */
//	@Query(value="FROM Customer WHERE custName = ?2 AND custId =?1 ")
//	public Customer findByCustomerNameAndId(Long id, String name);
	
	@Query(value="FROM Customer WHERE custName = :custName AND custId = :custId ")
	public Customer findByCustomerNameAndId(@Param("custId")Long id, @Param("custName")String name);
	
	
	//根据id改客户名称
	@Query(value="UPDATE Customer SET custName = ?1 WHERE custId = ?2")
	@Modifying //这里是update因此要联合使用@Query和@Modifying
	public void updateNameById(String newName, Long id);
	
	
	
	
	//除了可以用jpql语句写，也可以用sql语句来写，只要在@Query里面添加nativeQuery=true（默认是false）
	@Query(value="SELECT * FROM t_customer", nativeQuery=true)
	public List<Object[]> findAllSql();
	
	
	
	
	//方法名称规则查询，不需要再写jpql语句了
	//精准查询
	public Customer findByCustName(String nameToSearch);
	
	//模糊查询
	public List<Customer> findByCustNameLike(String nameToSearch);
	
	//多条件查询：客户名字模糊查询+行业精准查询
	//形参的顺序一定要与方法的名称顺序一致
	public List<Customer> findByCustNameLikeAndCustIndustry(String name, String industry);
}
