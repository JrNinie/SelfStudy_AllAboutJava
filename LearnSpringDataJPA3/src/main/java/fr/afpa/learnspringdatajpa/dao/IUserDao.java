package fr.afpa.learnspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.afpa.learnspringdatajpa.domain.User;

public interface IUserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>  {

}
 