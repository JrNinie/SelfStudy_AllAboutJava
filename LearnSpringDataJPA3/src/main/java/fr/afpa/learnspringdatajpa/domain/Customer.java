package fr.afpa.learnspringdatajpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略：postgresql自增
	@Column(name="cust_id")
	private Long custId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="cust_source")
	private String custSource;
	@Column(name="cust_industry")
	private String custIndustry;
	@Column(name="cust_phone")
	private String custPhone;
	@Column(name="cust_mobile")
	private String custMobile;
	@Transient //表示该属性不会生成表中的字段
	private String custLevel;
	
	
	/*
	 虽然这个JoinColumn写在“一”这里，但是其实最后生成的外键是在“多”那边
	 这里写上JoinColumn意思是“一”也能够维护外键，并没有放弃操作权
	 JoinColumn
	 	name : 外键字段名称
	 	referencedColumnName: 参照的主表的主键的名称（其实就是它自己的主键）
	 */
//	@OneToMany(targetEntity=Contact.class)
//	@JoinColumn(name="c_cust_id", referencedColumnName="cust_id")
	
	
	/*
	 向上面这样写的双向关联最好改成单向关联：
	 	也就是说“一”的一方放弃外键维护权，让“多”去管理
	 	在“一”的一方，只要申明OneToMany的关系即可
	 */
	//"一"的一方默认fetch=LAZY，一般保持LAZY就好
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
	private Set<Contact> contacts = new HashSet<>();
	
	
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	
	
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custPhone=" + custPhone + ", custMobile=" + custMobile
				+ ", custLevel=" + custLevel + "]";
	}
	
	
	
	
	
}
