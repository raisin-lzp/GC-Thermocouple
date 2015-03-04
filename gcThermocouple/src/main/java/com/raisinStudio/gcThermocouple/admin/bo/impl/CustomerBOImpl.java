package com.raisinStudio.gcThermocouple.admin.bo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raisinStudio.Util.spring.dao.intf.CRUDDao;
import com.raisinStudio.gcThermocouple.admin.bo.intf.CustomerBO;
import com.raisinStudio.gcThermocouple.admin.dao.intf.CustomerDAO;
import com.raisinStudio.gcThermocouple.admin.po.Customer;

@Service
@Transactional
public class CustomerBOImpl implements CustomerBO {


	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CRUDDao cRUDDao;


	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public List<Customer> getAll() throws Exception {
		try {
			return customerDAO.getAll();
		} catch (Exception e) {
			throw e;
		}
	}

	public Customer getCustomer(java.lang.Integer userid) throws Exception {
		try {
			return customerDAO.getCustomer(userid);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean addSubmit(Customer customer) throws Exception {
		try {
			List<Customer> tempCustomers = getCustomersbyUserName(customer
					.getUsername());

			if (tempCustomers.size() != 0) {
				return false;
			}

			customer.setUserid(0);

			customer.setStatus(1);

			customer.setPasswordtype(1);

			customer.setCreatetime(new Date());

			cRUDDao.save(customer,"t_user_info",Customer.class);

		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public boolean modSubmit(Customer customer) throws Exception {
		try {
			Customer tempCustomer = getCustomer(customer.getUserid());

			if (tempCustomer == null) {
				return false;
			}


			customerDAO.updateCustomer(customer);

		} catch (Exception e) {
			throw e;
		}
		return true;
	}

	public List<Customer> getCustomersbyUserName(String username)
			throws Exception {
		try {
			return customerDAO.getCustomersbyUserName(username);
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean loginValid(Customer customer) throws Exception {
		try {
			String strPassword = customer.getPassword();
			List<Customer> tempCustomers = this.getCustomersbyUserName(customer
					.getUsername());
			if (tempCustomers.size() == 0) {
				return false;
			}
			if (tempCustomers.get(0).getStatus().intValue() != 1) {
				return false;
			}
			if (strPassword.equals(tempCustomers.get(0).getPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		}
	}


}
