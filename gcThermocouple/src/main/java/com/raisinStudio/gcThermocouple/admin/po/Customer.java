/*
 * Copyright (c) 2012, Asiainfo-Linkage. All rights reserved.<br>
 * Asiainfo-Linkage PROPRIETARY/CONFIDENTIAL. Use is subject to license terms. 
 */
package com.raisinStudio.gcThermocouple.admin.po;

import java.io.Serializable;

/**
 * <p>
 * <b>版权：</b>Copyright (c) 2014 松果科技.<br>
 * <b>工程：</b>OnlineShop<br>
 * <b>文件：</b>Customer.java<br>
 * <b>创建时间：</b>2014-08-14 17:34:42<br>
 * <p>
 * <b>Customer PO.</b><br>
 * </p>
 * 
 * @author lezp
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class Customer implements Serializable {
    
    private java.lang.Integer userid;
    
    private java.lang.String username;
    
    private java.lang.String password;
    
    private java.lang.Integer passwordtype;
    
    private java.lang.String fullname;
    
    private java.lang.Integer status;
    
    private java.lang.String country;
    
    private java.lang.String city;
    
    private java.lang.String phone;
    
    private java.lang.String mobile;
    
    private java.lang.String email;
    
    private java.lang.String address;
    
    private java.lang.String fax;
    
    private java.lang.String remark;
    
    private java.util.Date createtime;
    
    private java.util.Date updatetime;
    
    private java.util.Date modpwdtime;
    
    private java.lang.String rsv1;

    private java.lang.String rsv2;

	public java.lang.Integer getUserid() {
		return userid;
	}

	public java.lang.String getUsername() {
		return username;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public java.lang.Integer getPasswordtype() {
		return passwordtype;
	}

	public java.lang.String getFullname() {
		return fullname;
	}

	public java.lang.Integer getStatus() {
		return status;
	}

	public java.lang.String getCountry() {
		return country;
	}

	public java.lang.String getCity() {
		return city;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public java.lang.String getMobile() {
		return mobile;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public java.lang.String getFax() {
		return fax;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public java.util.Date getUpdatetime() {
		return updatetime;
	}

	public java.util.Date getModpwdtime() {
		return modpwdtime;
	}

	public java.lang.String getRsv1() {
		return rsv1;
	}

	public java.lang.String getRsv2() {
		return rsv2;
	}

	public void setUserid(java.lang.Integer userid) {
		this.userid = userid;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public void setPasswordtype(java.lang.Integer passwordtype) {
		this.passwordtype = passwordtype;
	}

	public void setFullname(java.lang.String fullname) {
		this.fullname = fullname;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public void setCountry(java.lang.String country) {
		this.country = country;
	}

	public void setCity(java.lang.String city) {
		this.city = city;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public void setFax(java.lang.String fax) {
		this.fax = fax;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public void setModpwdtime(java.util.Date modpwdtime) {
		this.modpwdtime = modpwdtime;
	}

	public void setRsv1(java.lang.String rsv1) {
		this.rsv1 = rsv1;
	}

	public void setRsv2(java.lang.String rsv2) {
		this.rsv2 = rsv2;
	}


}

