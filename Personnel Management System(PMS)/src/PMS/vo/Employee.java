package PMS.vo;

public class Employee{
	private String employeeID;
	private String name;
	private String cardNumber;
	private String nation;
	private String sex;
	private String birthday;
	private String schoolRecord;
	private String department;
	private String positionName;
	private String road;
	private String tellphone;
	private String email;
	private String editTime;
	private String info;
	
	public Employee() {}
	public Employee(String employeeID, String name, String cardNumber, String nation, String sex, String birthday,
			String schoolRecord, String department, String positionName, String road, String tellphone, String email,
			String editTime, String info) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.cardNumber = cardNumber;
		this.nation = nation;
		this.sex = sex;
		this.birthday = birthday;
		this.schoolRecord = schoolRecord;
		this.department = department;
		this.positionName = positionName;
		this.road = road;
		this.tellphone = tellphone;
		this.email = email;
		this.editTime = editTime;
		this.info = info;
	}
	public String getEditTime() {
		return editTime;
	}
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}
	

	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNation() {
		return nation;
	}
	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", cardNumber=" + cardNumber + ", nation="
				+ nation + ", sex=" + sex + ", birthday=" + birthday + ", schoolRecord=" + schoolRecord
				+ ", department=" + department + ", positionName=" + positionName + ", road=" + road + ", tellphone="
				+ tellphone + ", email=" + email + ", editTime=" + editTime + ", info=" + info + "]";
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSchoolRecord() {
		return schoolRecord;
	}
	public void setSchoolRecord(String schoolRecord) {
		this.schoolRecord = schoolRecord;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getTellphone() {
		return tellphone;
	}
	public void setTellphone(String tellphone) {
		this.tellphone = tellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
