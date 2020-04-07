package fr.afpa.learnspringdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.afpa.learnspringdatajpa.domain.Contact;

public interface IContactDao extends JpaRepository<Contact, Long>, JpaSpecificationExecutor<Contact>  {

}
 