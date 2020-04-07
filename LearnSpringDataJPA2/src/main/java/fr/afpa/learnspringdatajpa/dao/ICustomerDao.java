package fr.afpa.learnspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.afpa.learnspringdatajpa.domain.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>  {

}
