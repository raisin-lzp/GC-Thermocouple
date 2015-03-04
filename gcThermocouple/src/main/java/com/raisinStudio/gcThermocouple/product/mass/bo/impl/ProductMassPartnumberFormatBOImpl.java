package com.raisinStudio.gcThermocouple.product.mass.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raisinStudio.Util.spring.dao.intf.CRUDDao;
import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassPartnumberFormatBO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassPartnumberFormat;

@Service
@Transactional
public class ProductMassPartnumberFormatBOImpl implements
		ProductMassPartnumberFormatBO {

	@Autowired
	private CRUDDao cRUDDao;

	public ProductMassPartnumberFormat getProductMassPartnumberFormatById(
			Long partNumberID) throws Exception {
		if (partNumberID == null || partNumberID.equals(new Long(0))) {
			return null;
		}
		return (ProductMassPartnumberFormat) cRUDDao.getById(partNumberID,
				"t_product_mass_partnumber_format",
				ProductMassPartnumberFormat.class);
	}

}
