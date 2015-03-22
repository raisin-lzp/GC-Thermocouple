package com.raisinStudio.gcThermocouple.product.mass.bo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.raisinStudio.Util.spring.dao.intf.CRUDDao;
import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassTypeBO;
import com.raisinStudio.gcThermocouple.product.mass.dao.intf.ProductMassTypeDao;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

@Service
@Transactional
public class ProductMassTypeBOImpl implements ProductMassTypeBO {

	@Autowired
	private ProductMassTypeDao productMassTypeDao;

	@Autowired
	private CRUDDao cRUDDao;

	public List<ProductMassType> getAllOrderByID() throws Exception {
		return productMassTypeDao.getAllOrderByID();
	}

	public boolean setModelTypeTree(Model model) throws Exception {
		List<ProductMassType> typeFList = new ArrayList<ProductMassType>();

		List<ProductMassType> tempProductMassTypeList = this.getAllOrderByID();

		for (ProductMassType i : tempProductMassTypeList) {
			if (i.getTypeLevel().equals(1)) {
				typeFList.add(i);
			}
		}

		Map<Long, Object> typeSMap = new HashMap<Long, Object>();

		for (ProductMassType i : typeFList) {
			List<ProductMassType> typeSList = new ArrayList<ProductMassType>();
			for (ProductMassType j : tempProductMassTypeList) {
				if (j.getTypeLevel().equals(2)
						&& j.getTypeF().equals(i.getTypeID())) {
					typeSList.add(j);
				}
			}
			typeSMap.put(i.getTypeID(), typeSList);
		}

		model.addAttribute("typeFList", typeFList);
		model.addAttribute("typeSMap", typeSMap);
		return true;
	}

	public ProductMassType getById(Long id) throws Exception {
		return (ProductMassType) cRUDDao.getById(id, "t_product_mass_type",
				"typeID", ProductMassType.class);
	}

}
