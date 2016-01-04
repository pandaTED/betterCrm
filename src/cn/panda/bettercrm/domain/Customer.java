package cn.panda.bettercrm.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 运鹏 on 2015/10/31 0031.
 * 
 * id
 * 姓名，性别，年龄，生日，公司电话，手机，email，状态，跟踪，所属用户
 */
public class Customer {
	private Long id;
	private String name;
	private String gender;
	private int	age;
	private Date birthday;
	private String companyPhone;
	private String cellphone;
	private String email;
	private String status;
	private Set<Tracking> trackings = new HashSet<Tracking>();
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Tracking> getTrackings() {
		return trackings;
	}
	public void setTrackings(Set<Tracking> trackings) {
		this.trackings = trackings;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}