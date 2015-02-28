package com.raisinStudio.gcThermocouple.admin.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raisinStudio.Util.spring.dao.MapAndBean;
import com.raisinStudio.gcThermocouple.admin.dao.intf.CustomerDAO;
import com.raisinStudio.gcThermocouple.admin.po.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	
	public List<Customer> getAll() throws DataAccessException {
		String sql = "SELECT * From t_user_info";
		return (List<Customer>) MapAndBean.transMapList2BeanList(
				jdbcTemplate.queryForList(sql), Customer.class);
		// return jdbcTemplate.queryForList(sql, CustomerRowMapper.getInstance());
	}

	
	public Customer getCustomer(Integer userid) throws DataAccessException {

		String sql = "SELECT * From t_user_info where USERID=?";
		return (Customer) MapAndBean.transMap2Bean(
				jdbcTemplate.queryForMap(sql, userid), Customer.class);
	}

	@SuppressWarnings("unchecked")
	
	public List<Customer> getCustomersbyUserName(String username)
			throws DataAccessException {

		String sql = "SELECT * From t_user_info where USERNAME=?";
		return (List<Customer>) MapAndBean.transMapList2BeanList(
				jdbcTemplate.queryForList(sql, username), Customer.class);
	}

	
	public void saveCustomer(Customer customer) throws DataAccessException {
		String sql = "INSERT INTO t_user_info() VALUES()";
		jdbcTemplate.update(sql);

	}

	
	public void updateCustomer(Customer customer) throws DataAccessException {

	}

}
