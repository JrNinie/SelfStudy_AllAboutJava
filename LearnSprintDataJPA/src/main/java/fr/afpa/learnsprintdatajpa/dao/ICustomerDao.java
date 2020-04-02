package fr.afpa.learnsprintdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.afpa.learnsprintdatajpa.domain.Customer;

/*
 符合springdatajpa的dao层接口的规范：
 	-继承JpaRepository<T, ID>， T指操作的实体类类型，ID指实体类中主键属性的类型
 		封装了基本的CRUD操作
 	-继承JpaSpecificationExecutor<T>， T指操作的实体类类型
 		封装了复杂的查询（分页等）
 */

public interface ICustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

}
