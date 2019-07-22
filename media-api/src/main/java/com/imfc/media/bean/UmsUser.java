package com.imfc.media.bean;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;

/**
 * 用户
 */
@Entity
@Table ( name ="ums_user" )
public class UmsUser implements Serializable {

	private static final long serialVersionUID =  7167311191956921952L;

   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 用户名
	 */
   	@Column(name = "user_name",columnDefinition = "aaa")
	private String userName;

	/**
	 * 登录密码
	 */
   	@Column(name = "password")
	private String password;

	/**
	 * 性别
	 */
   	@Column(name = "gender" )
	private Long gender;

	/**
	 * 出生日期
	 */
   	@Column(name = "birthday")
	private Date birthday;

	/**
	 * 手机
	 */
   	@Column(name = "mobile" )
	private String mobile;

	/**
	 * 居住省份
	 */
   	@Column(name = "address_province" )
	private String addressProvince;

	/**
	 * 城市
	 */
   	@Column(name = "address_city" )
	private String addressCity;

	/**
	 * 区【镇、乡】
	 */
   	@Column(name = "address_county" )
	private String addressCounty;

	/**
	 * 详细地址
	 */
   	@Column(name = "address_detail" )
	private String addressDetail;

	/**
	 * 系统权限【可以登录哪个系统】
	 */
   	@Column(name = "sys_manage" )
	private Long sysManage;

	/**
	 * 角色
	 */
   	@Column(name = "role" )
	private Long role;

	/**
	 * 头像
	 */
   	@Column(name = "icon" )
	private String icon;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddressProvince() {
		return addressProvince;
	}

	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCounty() {
		return addressCounty;
	}

	public void setAddressCounty(String addressCounty) {
		this.addressCounty = addressCounty;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public Long getSysManage() {
		return sysManage;
	}

	public void setSysManage(Long sysManage) {
		this.sysManage = sysManage;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
