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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private Long uId;
	@Column(name = "u_name")
	private String uName;
	@Column(name = "u_mail")
	private String uMail;
	
	
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
	/*
	 name="t_user_role" : 给中间表起个名字
	 joinColumns:当前对象User在中间表的外键
	 inverseJoinColumns:对方对象Role在中间表的外键
	 */
	@JoinTable(name="tur_user_role",
				joinColumns = {@JoinColumn(name="tur_u_id", referencedColumnName="u_id")},
				inverseJoinColumns = {@JoinColumn(name="tur_r_id", referencedColumnName="r_id")}
			)
	private Set<Role> roles = new HashSet<>();

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuMail() {
		return uMail;
	}

	public void setuMail(String uMail) {
		this.uMail = uMail;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uMail=" + uMail + ", roles=" + roles + "]";
	}
	
	
	
	
	
	
}
