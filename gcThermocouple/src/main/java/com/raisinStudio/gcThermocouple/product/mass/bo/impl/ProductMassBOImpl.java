package com.raisinStudio.gcThermocouple.product.mass.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raisinStudio.Util.spring.dao.intf.CRUDDao;
import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassBO;
import com.raisinStudio.gcThermocouple.product.mass.dao.intf.ProductMassDAO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMass;

@Service
@Transactional
public class ProductMassBOImpl implements ProductMassBO {

	@Autowired
	private ProductMassDAO productMassDAO;

	@Autowired
	private CRUDDao cRUDDao;

	public ProductMass getProductMassById(Long productID) throws Exception {
		if (productID == null || productID.equals(new Long(0))) {
			return null;
		}
		return (ProductMass) cRUDDao.getById(productID, "t_product_mass",
				ProductMass.class);
	}

	public List<ProductMass> getAllByLevelAndPageNumber(Integer level,
			Long typeId, Integer tempPageNumber, Integer tempNnumberPerPage)
			throws Exception {
		return productMassDAO.getAllByLevelAndPageNumber(level, typeId,
				tempPageNumber, tempNnumberPerPage);
	}

}
