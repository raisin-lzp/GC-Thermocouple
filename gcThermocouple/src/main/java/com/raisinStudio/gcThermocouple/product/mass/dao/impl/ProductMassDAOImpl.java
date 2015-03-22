package com.raisinStudio.gcThermocouple.product.mass.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.raisinStudio.Util.spring.dao.MapAndBean;
import com.raisinStudio.gcThermocouple.product.mass.dao.intf.ProductMassDAO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMass;

@Repository
public class ProductMassDAOImpl implements ProductMassDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("unchecked")
	public List<ProductMass> getAllByLevelAndPageNumber(Integer level,
			Long typeId, Integer tempPageNumber, Integer tempNnumberPerPage)
			throws DataAccessException {
		String sql;
		if (level == 1) {
			sql = "SELECT * From t_product_mass where typeF=? ORDER BY productID DESC LIMIT ?,?";
		} else if (level == 2) {
			sql = "SELECT * From t_product_mass where typeS=? ORDER BY productID DESC LIMIT ?,?";
		} else if (level == 3) {
			sql = "SELECT * From t_product_mass where typeT=? ORDER BY productID DESC LIMIT ?,?";
		} else {
			return null;
		}

		return (List<ProductMass>) MapAndBean.transMapList2BeanList(
				jdbcTemplate.queryForList(sql, typeId, (tempPageNumber - 1)
						* tempNnumberPerPage, tempNnumberPerPage),
						ProductMass.class);
	}

	@SuppressWarnings("unchecked")
	public List<ProductMass> getAllByLevel(Integer level, Long typeId)
			throws DataAccessException {
		String sql;
		if (level == 1) {
			sql = "SELECT * From t_product_mass where typeF=? ORDER BY productID DESC";
		} else if (level == 2) {
			sql = "SELECT * From t_product_mass where typeS=? ORDER BY productID DESC";
		} else if (level == 3) {
			sql = "SELECT * From t_product_mass where typeT=? ORDER BY productID DESC";
		} else {
			return null;
		}
		return (List<ProductMass>) MapAndBean.transMapList2BeanList(
				jdbcTemplate.queryForList(sql, typeId), ProductMass.class);
	}
}
