package com.raisinStudio.gcThermocouple.publicJsp.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassTypeBO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

@Controller
public class ProductMassJspAction {

	@Autowired
	private ProductMassTypeBO productMassTypeBO;

	@RequestMapping(value = "/productMass/", method = RequestMethod.GET)
	public String productMassIndex(Model model) throws Exception {
		Map<String, Object> typeMap = new HashMap<String, Object>();

		List<ProductMassType> tempProductMassTypeList = productMassTypeBO
				.getAll();

		for (ProductMassType i : tempProductMassTypeList) {
			if (i.getTypeLevel().equals(1)) {
				typeMap.put(i.getName(), i.getTypeID());
			}
		}

		for (String i : typeMap.keySet()) {
			Map<String, Object> typeSMap = new HashMap<String, Object>();
			for (ProductMassType j : tempProductMassTypeList) {
				if (j.getTypeLevel().equals(2)
						&& j.getTypeF().equals(typeMap.get(i))) {
					typeSMap.put(j.getName(), j);
				}
			}
			typeSMap.put("typeFId", typeMap.get(i));
			typeMap.replace(i, typeSMap);
		}

		model.addAttribute("typeMap", typeMap);
		return "gcThermocouple/pruductMass/listAll";
	}

	@RequestMapping(value = "/productMass/all", method = RequestMethod.GET)
	public String listAll(Model model) {
		return "gcThermocouple/pruductMass/listAll";
	}

	@RequestMapping(value = "/productMass/typeF", method = RequestMethod.GET)
	public String listTypeF(Model model) {
		return "gcThermocouple/pruductMass/listTypeF";
	}

	@RequestMapping(value = "/productMass/typeS", method = RequestMethod.GET)
	public String listTypeS(Model model) {
		return "gcThermocouple/pruductMass/listTypeS";
	}

	/*
	 * @RequestMapping(value = "/productMass/typeT", method = RequestMethod.GET)
	 * public String listTypeT(Model model) { return
	 * "gcThermocouple/pruductMass/listTypeT"; }
	 */

	@RequestMapping(value = "/productMass/id", method = RequestMethod.GET)
	public String productMassDetail(Model model) {
		return "gcThermocouple/pruductMass/productMassDetail";
	}

}
