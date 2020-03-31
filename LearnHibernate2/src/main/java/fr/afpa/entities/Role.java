package fr.afpa.entities;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Long rid;
	private String roleName;
	//一个role可以被多个user选择
	private Set<User> users = new HashSet<>();
	
	
	public Role() {
		super();
	}


	public Role(Long rid, String roleName) {
		super();
		this.rid = rid;
		this.roleName = roleName;
	}


	public Long getRid() {
		return rid;
	}


	public void setRid(Long rid) {
		this.rid = rid;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	
}
