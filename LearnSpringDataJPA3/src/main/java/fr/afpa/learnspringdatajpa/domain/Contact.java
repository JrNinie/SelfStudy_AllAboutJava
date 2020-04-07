package fr.afpa.learnspringdatajpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_id")
	private Long cId;
	
	@Column(name="c_name")
	private String cName;
	
	@Column(name="c_position")
	private String cPosition;
	
	@Column(name="c_phone")
	private String cPhone;
	
	//"多"的一方默认fetch=EARGY，按照自己需求可以选择LAZY
	@ManyToOne(targetEntity=Customer.class)
	//这里的name是自己起的
	//@JoinColumn(name="c_cust_id", referencedColumnName="cust_id")
	@JoinColumn(name="c_cust_id")
	private Customer customer;
	
	
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPosition() {
		return cPosition;
	}
	public void setcPosition(String cPosition) {
		this.cPosition = cPosition;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", cName=" + cName + ", cPosition=" + cPosition + ", cPhone=" + cPhone + "]";
	}
	
	
	
}
