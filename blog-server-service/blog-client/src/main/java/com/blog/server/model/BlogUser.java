package com.blog.server.model;

import java.util.Date;

import com.lzl.base.model.BaseModel;

/**
 * 博客用户
 * 
 * @author admin
 *
 */
public class BlogUser extends BaseModel<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2527887381184565018L;

	private String userName;

	private String password;

	private String email;

	private String phone;

	private String address;

	private String photo;

	private Integer sex;

	private Integer age;

	private Date birthday;

	private Integer state;

	private String qqNumber;

	private String wxNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber == null ? null : qqNumber.trim();
	}

	public String getWxNumber() {
		return wxNumber;
	}

	public void setWxNumber(String wxNumber) {
		this.wxNumber = wxNumber == null ? null : wxNumber.trim();
	}
}
