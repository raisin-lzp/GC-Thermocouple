package com.raisinStudio.gcThermocouple.product.mass.ui;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassBO;
import com.raisinStudio.gcThermocouple.product.mass.bo.intf.ProductMassPartnumberFormatBO;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMass;
import com.raisinStudio.gcThermocouple.product.mass.po.ProductMassPartnumberFormat;

@Controller
@RequestMapping("/product/mass")
public class MassProductionAction {
	@Autowired
	private ProductMassBO productMassBO;

	@Autowired
	private ProductMassPartnumberFormatBO productMassPartnumberFormatBO;

	@RequestMapping(value = "/filter/ajax", produces = "application/json")
	public void filterMassProduction(HttpServletRequest request,
			MassProductionFilterForm massProductionFilterForm,
			PrintWriter printWriter) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		List<ProductMass> tempMassProductions = null;

		java.lang.Integer tempPageNumber = massProductionFilterForm
				.getPageNumber();

		if (tempPageNumber == null || tempPageNumber == 0) {
			tempPageNumber = 1;
		}

		java.lang.Integer tempNnumberPerPage = massProductionFilterForm
				.getNumberPerPage();

		if (tempNnumberPerPage == null || tempNnumberPerPage == 0) {
			tempNnumberPerPage = 20;
		}

		if (massProductionFilterForm.getTypeT() != null) {
			tempMassProductions = productMassBO.getAllByLevelAndPageNumber(3,
					massProductionFilterForm.getTypeT(), tempPageNumber,
					tempNnumberPerPage);
		} else if (massProductionFilterForm.getTypeT() != null) {
			tempMassProductions = productMassBO.getAllByLevelAndPageNumber(2,
					massProductionFilterForm.getTypeT(), tempPageNumber,
					tempNnumberPerPage);
		} else if (massProductionFilterForm.getTypeT() != null) {
			tempMassProductions = productMassBO.getAllByLevelAndPageNumber(1,
					massProductionFilterForm.getTypeT(), tempPageNumber,
					tempNnumberPerPage);
		}

		if (tempMassProductions == null) {
			map.put("result", "error");
			printWriter.write(JSONObject.fromObject(map).toString());
			printWriter.flush();
			printWriter.close();
			return;
		}

		map.put("massProductions", tempMassProductions);

		map.put("result", "success");
		printWriter.write(JSONObject.fromObject(map).toString());
		printWriter.flush();
		printWriter.close();
		return;
	}

	@RequestMapping(value = "/id/ajax", produces = "application/json")
	public void getOneMassProduction(HttpServletRequest request,
			MassProductionFilterForm massProductionFilterForm,
			PrintWriter printWriter) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		java.lang.Long productID = massProductionFilterForm.getProductID();

		ProductMass tempProductMass = productMassBO
				.getProductMassById(productID);

		if (tempProductMass == null) {
			map.put("result", "error");
			printWriter.write(JSONObject.fromObject(map).toString());
			printWriter.flush();
			printWriter.close();
			return;
		}

		map.put("productMass", tempProductMass);

		String[] tempPartNumberFormats = tempProductMass.getPartNumberFormat()
				.split(";");

		Map<String, Object> partNumberFormatMap = new HashMap<String, Object>();
		for (String i : tempPartNumberFormats) {
			if (i.startsWith("{")) {
				i = i.substring(1, i.length() - 1);
				i = i.split(":")[0];
				ProductMassPartnumberFormat tempProductMassPartnumberFormat = productMassPartnumberFormatBO
						.getProductMassPartnumberFormatById(new Long(i));
				if (tempProductMassPartnumberFormat == null) {
					System.out.println("====ERROR==================");
					System.out
							.println("Does have ProductMassPartnumberFormat id:"
									+ i);
					System.out.println("==========================");
				}
				partNumberFormatMap.put(i, tempProductMassPartnumberFormat);
			}
		}

		map.put("partNumberFormatMap", partNumberFormatMap);

		map.put("result", "success");

		printWriter.write(JSONObject.fromObject(map).toString());
		printWriter.flush();
		printWriter.close();
		return;
	}
}
