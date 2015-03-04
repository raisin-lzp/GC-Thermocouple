package com.raisinStudio.gcThermocouple.product.mass.bo.intf;

import java.util.List;

import com.raisinStudio.gcThermocouple.product.mass.po.ProductMass;

public interface ProductMassBO {

	ProductMass getProductMassById(Long productID) throws Exception;

	List<ProductMass> getAllByLevelAndPageNumber(Integer level, Long typeId,
			Integer tempPageNumber, Integer tempNnumberPerPage)
			throws Exception;

}
