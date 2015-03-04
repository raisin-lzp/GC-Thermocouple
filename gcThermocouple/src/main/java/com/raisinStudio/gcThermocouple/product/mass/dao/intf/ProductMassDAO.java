package com.raisinStudio.gcThermocouple.product.mass.dao.intf;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.raisinStudio.gcThermocouple.product.mass.po.ProductMass;

public interface ProductMassDAO {

	List<ProductMass> getAllByLevelAndPageNumber(Integer level, Long typeId,
			Integer tempPageNumber, Integer tempNnumberPerPage)
			throws DataAccessException;

}
