package fr.afpa.learnjpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 配置映射关系
 1. 配置实体类和表的映射： @Entity, @Table
 2. 配置实体类属性和表字段的映射 ： @Id， @GeneratedValue，@Column
 * 
 */

@Entity //声明实体类（不要导错包，是javax.persistence里的）
@Table(name="t_customer") //指明对应的表的名字
public class Customer {
	/*
	 主键生成策略：
	 	GenerationType.IDENTITY: 自增auto-increment（但是底层数据库必须支持自增，比如MySql, Postgresql）
		GenerationType.SEQUENCE: 序列（Oracle）
		GenerationType.TABLE: jpa提供的机制，通过一张数据库表的形式帮助我们完成主键自增
		GenerationType.AUTO: 由程序自动选择
	 */
	@Id //声明表中的主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) //声明主键的生成策略
	@Column(name="cust_id") //在对应的表中字段名
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
	
	
	public Customer() {
		super();
	}
	
	public Customer(Long custId, String custName, String custSource, String custIndustry, String custLevel,
			String custPhone, String custMobile) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custSource = custSource;
		this.custIndustry = custIndustry;
		this.custLevel = custLevel;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
	}

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

	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
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

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + "]";
	}
	
	
}
