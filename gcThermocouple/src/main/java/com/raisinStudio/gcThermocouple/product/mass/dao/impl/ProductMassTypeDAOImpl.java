package com.raisinStudio.gcThermocouple.product.mass.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raisinStudio.Util.spring.dao.MapAndBean;
import com.raisinStudio.gcThermocouple.product.mass.dao.intf.ProductMassTypeDao;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

@Repository
public class ProductMassTypeDAOImpl implements ProductMassTypeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public List<ProductMassType> getAllOrderByID() throws DataAccessException {
		String sql = "SELECT * From t_product_mass_type ORDER BY typeID ASC";
		return (List<ProductMassType>) MapAndBean.transMapList2BeanList(
				jdbcTemplate.queryForList(sql), ProductMassType.class);
	}

}
