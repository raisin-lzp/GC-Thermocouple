package com.raisinStudio.gcThermocouple.product.mass.dao.intf;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;


public interface ProductMassTypeDao {

	List<ProductMassType> getAllOrderByID()throws DataAccessException;

}
