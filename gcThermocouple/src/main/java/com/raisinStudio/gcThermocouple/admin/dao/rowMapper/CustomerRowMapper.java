package com.raisinStudio.gcThermocouple.admin.dao.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.raisinStudio.gcThermocouple.admin.po.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {
	private CustomerRowMapper() {
	}

	private static CustomerRowMapper instance = null;

	public static CustomerRowMapper getInstance() {
		if (instance == null) {
			instance = new CustomerRowMapper();
		}
		return instance;
	}

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setUserid(rs.getInt("USERID"));
		customer.setUsername(rs.getString("USERNAME"));
		customer.setPassword(rs.getString("PASSWORD"));
		customer.setPasswordtype(rs.getInt("PASSWORDTYPE"));
		customer.setFullname(rs.getString("FULLNAME"));
		customer.setStatus(rs.getInt("STATUS"));
		customer.setCountry(rs.getString("COUNTRY"));
		customer.setCity(rs.getString("CITY"));
		customer.setPhone(rs.getString("PHONE"));
		customer.setMobile(rs.getString("MOBILE"));
		customer.setEmail(rs.getString("EMAIL"));
		customer.setAddress(rs.getString("ADDRESS"));
		customer.setFax(rs.getString("FAX"));
		customer.setRemark(rs.getString("REMARK"));
		customer.setCreatetime(rs.getDate("CREATETIME"));
		customer.setUpdatetime(rs.getDate("UPDATETIME"));
		customer.setModpwdtime(rs.getDate("MODPWDTIME"));
		customer.setRsv1(rs.getString("RSV1"));
		customer.setRsv2(rs.getString("RSV2"));

		return customer;
	}

}
