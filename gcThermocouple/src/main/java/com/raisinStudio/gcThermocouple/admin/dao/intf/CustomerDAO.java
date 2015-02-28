package com.raisinStudio.gcThermocouple.admin.dao.intf;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.raisinStudio.gcThermocouple.admin.po.Customer;

public interface CustomerDAO {

	List<Customer> getAll() throws DataAccessException;

	Customer getCustomer(java.lang.Integer userid) throws DataAccessException;

	List<Customer> getCustomersbyUserName(String username)
			throws DataAccessException;

	void saveCustomer(Customer customer) throws DataAccessException;

	void updateCustomer(Customer customer) throws DataAccessException;

}
