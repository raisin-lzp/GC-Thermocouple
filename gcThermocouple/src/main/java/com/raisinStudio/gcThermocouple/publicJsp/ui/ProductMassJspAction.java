package com.raisinStudio.gcThermocouple.publicJsp.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassBO;
import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassTypeBO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMass;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassType;

@Controller
public class ProductMassJspAction {

	@Autowired
	private ProductMassTypeBO productMassTypeBO;
	@Autowired
	private ProductMassBO productMassBO;

	@RequestMapping(value = "/productMass/", method = RequestMethod.GET)
	public String productMassIndex(Model model) throws Exception {
		if (!productMassTypeBO.setModelTypeTree(model)) {
			System.out.println("wrong type");
		}
		return "gcThermocouple/pruductMass/listAll";
	}

	@RequestMapping(value = "/productMass/all", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		if (!productMassTypeBO.setModelTypeTree(model)) {
			System.out.println("wrong type");
		}
		return "gcThermocouple/pruductMass/listAll";
	}

	@RequestMapping(value = "/productMass/typeF/id/{id}", method = RequestMethod.GET)
	public String listTypeF(@PathVariable("id") String id, Model model)
			throws Exception {
		if (!productMassTypeBO.setModelTypeTree(model)) {
			System.out.println("wrong type");
		}
		model.addAttribute("thisPageType",
				productMassTypeBO.getById(new Long(id)));
		return "gcThermocouple/pruductMass/listTypeF";
	}

	@RequestMapping(value = "/productMass/typeS/id/{id}", method = RequestMethod.GET)
	public String listTypeS(@PathVariable("id") String id, Model model)
			throws Exception {
		if (!productMassTypeBO.setModelTypeTree(model)) {
			System.out.println("wrong type");
		}

		List<ProductMass> tempProductMassList = productMassBO.getAllByLevel(2,
				new Long(id));
		// Map<Long, ProductMass> tempProductMassMap = new HashMap<Long,
		// ProductMass>();
		//
		// if (tempProductMassList != null) {
		// for (ProductMass i : tempProductMassList) {
		// tempProductMassMap.put(i.getTypeS(), i);
		// }
		// }
		ProductMassType thisPageType = productMassTypeBO.getById(new Long(id));
		model.addAttribute("thisPageType", thisPageType);
		model.addAttribute("thisPageTypeF",
				productMassTypeBO.getById(thisPageType.getTypeF()));
		model.addAttribute("typeSProductMassList", tempProductMassList);
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
