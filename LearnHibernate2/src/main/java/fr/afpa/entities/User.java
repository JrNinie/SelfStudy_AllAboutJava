package fr.afpa.entities;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long uid;
	//private String uid; //如果是uuid主键生成策略就写String
	private String userName;
	private String password;
	private String address;
	//一个User可以选择多个role
	private Set<Role> roles = new HashSet<>();
	
	//主键生成策略是native/identity时
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", userName=" + userName + ", password=" + password + ", address=" + address + "]";
	}
	
	
}
