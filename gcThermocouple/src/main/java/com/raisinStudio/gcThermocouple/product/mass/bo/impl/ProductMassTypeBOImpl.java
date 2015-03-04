package com.raisinStudio.gcThermocouple.product.mass.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raisinStudio.Util.spring.dao.intf.CRUDDao;
import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassTypeBO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

@Service
@Transactional
public class ProductMassTypeBOImpl implements ProductMassTypeBO {

	@Autowired
	private CRUDDao cRUDDao;

	public List<ProductMassType> getAll() throws Exception {
		List<ProductMassType> temp = new ArrayList<ProductMassType>();
		List<Object> tempFromDB = cRUDDao.getAll("t_product_mass_type",
				ProductMassType.class);
		if (tempFromDB == null) {
			return null;
		}
		for (Object i : tempFromDB) {
			temp.add((ProductMassType) i);
		}
		return temp;
	}

}
