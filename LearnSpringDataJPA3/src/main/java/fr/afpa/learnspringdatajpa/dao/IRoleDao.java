package fr.afpa.learnspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.afpa.learnspringdatajpa.domain.Role;

public interface IRoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>  {

}
 