package fr.afpa.entities;

public class ContactMan {

	private Long cm_id;
	private String cm_name;
	private String cm_gender;
	private String cm_phone;
	private String cm_mobile;
	private String cm_mail;
	private String cm_position;
	private String cm_memo;
	//a contactman for ONLY ONE customer, so:
	private Customer cst;
	
	
	
	public Long getCm_id() {
		return cm_id;
	}
	public void setCm_id(Long cm_id) {
		this.cm_id = cm_id;
	}
	public String getCm_name() {
		return cm_name;
	}
	public void setCm_name(String cm_name) {
		this.cm_name = cm_name;
	}
	public String getCm_gender() {
		return cm_gender;
	}
	public void setCm_gender(String cm_gender) {
		this.cm_gender = cm_gender;
	}
	public String getCm_phone() {
		return cm_phone;
	}
	public void setCm_phone(String cm_phone) {
		this.cm_phone = cm_phone;
	}
	public String getCm_mobile() {
		return cm_mobile;
	}
	public void setCm_mobile(String cm_mobile) {
		this.cm_mobile = cm_mobile;
	}
	public String getCm_mail() {
		return cm_mail;
	}
	public void setCm_mail(String cm_mail) {
		this.cm_mail = cm_mail;
	}
	public String getCm_position() {
		return cm_position;
	}
	public void setCm_position(String cm_position) {
		this.cm_position = cm_position;
	}
	public String getCm_memo() {
		return cm_memo;
	}
	public void setCm_memo(String cm_memo) {
		this.cm_memo = cm_memo;
	}
	public Customer getCst() {
		return cst;
	}
	public void setCst(Customer cst) {
		this.cst = cst;
	}
	
	
	
	
	
}
