package com.raisinStudio.gcThermocouple.product.mass.bo.intf;

import java.util.List;

import org.springframework.ui.Model;

import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

public interface ProductMassTypeBO {

	List<ProductMassType> getAllOrderByID() throws Exception;

	boolean setModelTypeTree(Model model) throws Exception;

	ProductMassType getById(Long id) throws Exception;

}
