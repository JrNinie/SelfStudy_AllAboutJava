package fr.afpa.entities;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	//not long, but it's wrapper
	private Long cust_id;
	private String cust_name;
	private String cust_source;
	private String cust_industriy;
	private String cust_level;
	private String cust_phone;
	private String cust_mobile;
	//a customer could have SEVERAL contactmen
	//Hibernate : set not list
	private Set<ContactMan> contactMen = new HashSet<ContactMan>();
	
	
	//不要忘了getter setter，否则无法通过
	public Set<ContactMan> getContactMen() {
		return contactMen;
	}
	public void setContactMen(Set<ContactMan> contactMen) {
		this.contactMen = contactMen;
	}
	
	
	public Customer() {
		super();
	}
	public Customer(Long cust_id, String cust_name, String cust_source, String cust_industriy, String cust_level,
			String cust_phone, String cust_mobile) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_source = cust_source;
		this.cust_industriy = cust_industriy;
		this.cust_level = cust_level;
		this.cust_phone = cust_phone;
		this.cust_mobile = cust_mobile;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_source() {
		return cust_source;
	}
	public void setCust_source(String cust_source) {
		this.cust_source = cust_source;
	}
	public String getCust_industriy() {
		return cust_industriy;
	}
	public void setCust_industriy(String cust_industriy) {
		this.cust_industriy = cust_industriy;
	}
	public String getCust_level() {
		return cust_level;
	}
	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	
	
}
