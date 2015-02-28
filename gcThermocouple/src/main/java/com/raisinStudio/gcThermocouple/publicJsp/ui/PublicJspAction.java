package com.raisinStudio.gcThermocouple.publicJsp.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublicJspAction {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootIndex(Model model) {
		return "gcThermocouple/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		return "gcThermocouple/index";
	}

	@RequestMapping(value = "/error/404", method = RequestMethod.GET)
	public String error404(Model model) {
		return "gcThermocouple/error/error404";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String other(Model model) {
		return "test";
	}
}
