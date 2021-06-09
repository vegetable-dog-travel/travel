package com.igeek.travel.entity;

import javax.swing.text.StringContent;
import java.nio.charset.CoderMalfunctionError;
import java.util.Date;

/**
 * 用户类
 */
public class User {

	private String uid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String telephone;
	private Date birthday;
	private String sex;
	private int state;//0--未激活 1--激活
	private String code;//激活码
	private String address;

	public User() {
	}

	public User(String uid, String username, String password, String name, String email, String telephone, Date birthday, String sex, int state, String code) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.sex = sex;
		this.state = state;
		this.code = code;
	}

	public User(String uid, String username, String password, String name, String email, String telephone, Date birthday, String sex, int state, String code, String address) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.birthday = birthday;
		this.sex = sex;
		this.state = state;
		this.code = code;
		this.address = address;
	}

	/**
	 * 获取
	 * @return uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置
	 * @param uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 获取
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 设置
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * 获取
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取
	 * @return state
	 */
	public int getState() {
		return state;
	}

	/**
	 * 设置
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * 获取
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "User{uid = " + uid + ", username = " + username + ", password = " + password + ", name = " + name + ", email = " + email + ", telephone = " + telephone + ", birthday = " + birthday + ", sex = " + sex + ", state = " + state + ", code = " + code + ", address = " + address + "}";
	}
}
