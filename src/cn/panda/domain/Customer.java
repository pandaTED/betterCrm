package cn.panda.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 运鹏 on 2015/10/31 0031.
 * 迁移于SimpleCRM项目
 * 字段：id 姓名，性别，年龄，生日，公司电话，手机，email，状态，跟踪，所属用户
 */
public class Customer {
	private int age;
	private Date birthday;
	private String cellphone;
	private String companyName;		
	private String companyPhone;
	private Date customerSaveDate;		//客户信息录入的日期时间
	private String email;						
	private String gender;				
	private Long id;
	private String name;
	private String status;						//客户状态，比如“成交”/“正在洽谈”/“没戏”
	private Set<Tracking> trackings = new HashSet<Tracking>();
	private User user;							//这条客户信息所属的用户

	public int getAge() {
		return age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getCellphone() {
		return cellphone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public Date getCustomerSaveDate() {
		return customerSaveDate;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public Set<Tracking> getTrackings() {
		return trackings;
	}

	public User getUser() {
		return user;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public void setCustomerSaveDate(Date customerSaveDate) {
		this.customerSaveDate = customerSaveDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTrackings(Set<Tracking> trackings) {
		this.trackings = trackings;
	}

	public void setUser(User user) {
		this.user = user;
	}

}