package fr.afpa.learnspringdatajpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
				+ ", custIndustry=" + custIndustry + ", custPhone=" + custPhone + ", custMobile=" + custMobile
				+ ", custLevel=" + custLevel + "]";
	}
	
	
	
	
	
}
