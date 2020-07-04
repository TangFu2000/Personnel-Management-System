package PMS.vo;

public class Department {
	private String departID;
	private String departName;
	private String contact;
	private String chargePerson;
	private String info;
	public Department() {}
	public Department(String departID, String departName, String contact, String chargePerson, String info) {
		super();
		this.departID = departID;
		this.departName = departName;
		this.contact = contact;
		this.chargePerson = chargePerson;
		this.info = info;
	}
	public String getDepartID() {
		return departID;
	}
	public void setDepartID(String departID) {
		this.departID = departID;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getChargePerson() {
		return chargePerson;
	}
	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
