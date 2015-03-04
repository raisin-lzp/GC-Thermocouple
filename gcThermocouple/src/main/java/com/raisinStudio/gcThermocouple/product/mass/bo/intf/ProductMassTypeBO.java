package com.raisinStudio.gcThermocouple.product.mass.bo.intf;

import java.util.List;

import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

public interface ProductMassTypeBO {

	List<ProductMassType> getAll() throws Exception;

}
