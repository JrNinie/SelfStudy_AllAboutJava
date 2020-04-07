package fr.afpa.learnspringdatajpa.domain;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "t_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private Long rId;
	@Column(name = "u_name")
	private String rName;
	
	//如果Role不放弃外键维护权，要写成下面这样
//	@ManyToMany(targetEntity = User.class)
//	@JoinTable(name="tur_user_role",
//				joinColumns = {@JoinColumn(name="tur_r_id", referencedColumnName="r_id")},
//				inverseJoinColumns = {@JoinColumn(name="tur_u_id", referencedColumnName="u_id")}
//			)
	
	//被动方主动放弃外键维护权
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<>();

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + ", users=" + users + "]";
	}
	
	
	
}
