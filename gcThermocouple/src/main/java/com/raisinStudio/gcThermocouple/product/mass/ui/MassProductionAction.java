package com.raisinStudio.gcThermocouple.product.mass.ui;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raisinStudio.gcThermocouple.admin.bo.intf.CustomerBO;

@Controller
@RequestMapping("/product/mass")
public class MassProductionAction {
	@Autowired
	private CustomerBO customerBO;

	@RequestMapping(value = "/filter", produces = "application/json")
	public void filterMassProduction(HttpServletRequest request,
			MassProductionFilterForm massProductionFilterForm,
			PrintWriter printWriter) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		printWriter.write(JSONObject.fromObject(map).toString());
		printWriter.flush();
		printWriter.close();
		return;
	}
}
