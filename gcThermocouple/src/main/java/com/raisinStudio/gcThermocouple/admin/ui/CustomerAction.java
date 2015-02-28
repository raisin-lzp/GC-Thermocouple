package com.raisinStudio.gcThermocouple.admin.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.raisinStudio.gcThermocouple.admin.bo.intf.CustomerBO;
import com.raisinStudio.gcThermocouple.admin.po.Customer;
import com.raisinStudio.system.beans.AdminBean;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class CustomerAction {
	@Autowired
	private CustomerBO customerBO;

	@RequestMapping(value = "/login_submit", produces = "application/json")
	public void loginSubmit(HttpServletRequest request,
			CustomerForm customerForm, PrintWriter printWriter)
			throws Exception {

		Map<String, String> map = new HashMap<String, String>();

		String verifyCode = (String) request.getSession().getAttribute(
				"VerifyCode");

		String strAdmin = customerForm.getUsername();
		String strPassword = customerForm.getPassword();
		String strVerifyCode = customerForm.getVerifyCode();

		List<Customer> temptest = customerBO.getAll();

		for (Customer i : temptest) {
			System.out.println(i.getUsername());
		}

		if (strAdmin == null || strAdmin.equals("") || strPassword == null
				|| strPassword.equals("") || strVerifyCode == null
				|| strVerifyCode.equals("")) {
			map.put("error", "nofulldata");
			printWriter.write(JSONObject.fromObject(map).toString());
			printWriter.flush();
			printWriter.close();
			return;
		}

		if (verifyCode == null || customerForm.getVerifyCode() == null
				|| !verifyCode.trim().equals(customerForm.getVerifyCode())) {
			map.put("error", "verifyCode");
			printWriter.write(JSONObject.fromObject(map).toString());
			printWriter.flush();
			printWriter.close();
			return;
		}

		Customer tempCustomer = new Customer();
		tempCustomer.setUsername(customerForm.getUsername());
		tempCustomer.setPassword(customerForm.getPassword());

		String loginMessage = loginProcess(tempCustomer, request.getSession());

		if (loginMessage.equals("success")) {
			map.put("success", "success");
		} else {
			map.put("error", loginMessage);
		}

		printWriter.write(JSONObject.fromObject(map).toString());
		printWriter.flush();
		printWriter.close();
		return;
	}

	private String loginProcess(Customer tempCustomer, HttpSession httpSession) {
		try {
			if (customerBO.loginValid(tempCustomer) == true) {
				Customer customer = customerBO.getCustomersbyUserName(
						tempCustomer.getUsername()).get(0);

				AdminBean tempAdminObject = new AdminBean();

				tempAdminObject.setUsername(customer.getUsername());

				httpSession.setAttribute("adminBean", tempAdminObject);

				return "success";

			} else {

				return customerBO.getMessage();

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception";
		}

	}

	@RequestMapping(value = "/verifyCode")
	public void verifyCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.setProperty("java.awt.fonts", System.getProperty("JAVA_HOME")
				+ "/jre/lib/fonts");

		response.setHeader("Cache-Control", "no-store");
		response.setContentType("image/jpeg");

		int i1 = (int) (java.lang.Math.random() * 10);
		int i2 = (int) (java.lang.Math.random() * 10);
		int i3 = (int) (java.lang.Math.random() * 10);
		int i4 = (int) (java.lang.Math.random() * 10);

		String verifyCode = String.valueOf(i1) + String.valueOf(i2)
				+ String.valueOf(i3) + String.valueOf(i4);

		// 2007/12/07修改为新版本校验码 by lance
		BufferedImage image4 = null;
		if (verifyCode.length() >= 6) {
			image4 = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		} else {
			image4 = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		}
		Graphics g = image4.getGraphics();
		g.setColor(Color.white);
		if (verifyCode.length() >= 6) {
			g.fillRect(0, 0, 80, 20);
		} else {
			g.fillRect(0, 0, 60, 20);
		}
		g.setColor(new Color(0, 0, 255));

		// g.drawString(verifyCode, 10, 10);
		// 生成干扰
		Color[] c = { Color.BLACK, Color.BLUE, Color.RED };
		// 定义字体
		// String[] font = {"Verdana", "Microsoft Sans Serif", "Comic Sans MS",
		// "Arial", "宋体"};
		// 随机输出噪点
		Random rand = new Random();

		// 画图片的背景噪音线
		for (int i = 0; i < 5; i++) {
			int x1 = rand.nextInt(60);
			int x2 = rand.nextInt(60);
			if (verifyCode.length() >= 6) {
				x1 = rand.nextInt(80);
				x2 = rand.nextInt(80);
			}
			int y1 = rand.nextInt(20);
			int y2 = rand.nextInt(20);
			int z = rand.nextInt(3);
			g.setColor(c[z]);
			g.drawLine(x1, y1, x2, y2);
		}
		// 背景噪点
		for (int i = 0; i < 70; i++) {
			int x = rand.nextInt(60);
			if (verifyCode.length() >= 6) {
				x = rand.nextInt(80);
			}
			int y = rand.nextInt(20);
			int z = rand.nextInt(3);
			g.setColor(c[z]);
			g.fillRect(x, y, 1, 1);
		}

		int wi = 0;
		// 输出不同字体和颜色的验证码字符char[] ac = verifyCode.toCharArray();
		int xd = 1;
		for (int i = 0; i < verifyCode.length(); i++) {
			String a = verifyCode.substring(i, i + 1);
			int cc = rand.nextInt(2);
			int z = rand.nextInt(2);
			g.setColor(c[z]);
			xd = xd * (-1);
			cc = cc * xd;
			try {
				Font fonts = new Font(null, Font.BOLD, 15);
				g.setFont(fonts);
				g.drawString(a, 10 + wi, 15 + cc);
				wi = wi + 10;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image4);
		out.close();

		HttpSession session = request.getSession();
		System.out.println("begin setVerifyCode " + verifyCode);
		session.setAttribute("VerifyCode", verifyCode);
		System.out.println("end.. setVerifyCode ");

	}

	@RequestMapping(value = "/exist_submit")
	public String existsubmit(HttpServletRequest request) throws Exception {
		try {

			request.getSession().setAttribute("adminBean", null);
			return "ecommerce/index";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(value = "/register_submit", produces = "application/json")
	public void registerSubmit(HttpServletRequest request,
			CustomerForm customerForm, PrintWriter printWriter)
			throws Exception {
		try {

			HttpSession httpSession = request.getSession();

			Map<String, String> map = new HashMap<String, String>();

			if (httpSession.getAttribute("adminBean") != null) {
				map.put("error", "alreadylogin");
				printWriter.write(JSONObject.fromObject(map).toString());
				printWriter.flush();
				printWriter.close();
				return;
			}

			if (!httpSession.getAttribute("VerifyCode").equals(
					customerForm.getVerifyCode())) {
				map.put("error", "VerifyCode");
				printWriter.write(JSONObject.fromObject(map).toString());
				printWriter.flush();
				printWriter.close();
				return;
			}

			Customer tempcustomer = new Customer();
			tempcustomer.setUsername(customerForm.getUsername());
			tempcustomer.setPassword(customerForm.getPassword());
			tempcustomer.setEmail(customerForm.getEmail());

			if (customerBO.addSubmit(tempcustomer)) {
				map.put("success", customerBO.getMessage());
				printWriter.write(JSONObject.fromObject(map).toString());
				printWriter.flush();
				printWriter.close();
				return;
			} else {
				map.put("error", customerBO.getMessage());
				printWriter.write(JSONObject.fromObject(map).toString());
				printWriter.flush();
				printWriter.close();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	//
	// public String modSubmit() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (!isSessionFlag()) {
	// map.put("error", "out_time");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "nocustomer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// Customer customer = tempcustomers.get(0);
	//
	// customer.setFullname(customerForm.getFullname());
	// customerForm.setFullname(null);
	//
	// customer.setEmail(customerForm.getEmail());
	// customerForm.setEmail(null);
	//
	// customer.setMobile(customerForm.getMobile());
	// customerForm.setMobile(null);
	//
	// customer.setFax(customerForm.getFax());
	// customerForm.setFax(null);
	//
	// customer.setCountry(customerForm.getCountry());
	// customerForm.setCountry(null);
	//
	// customer.setCity(customerForm.getCity());
	// customerForm.setCity(null);
	//
	// customer.setAddress(customerForm.getAddress());
	// customerForm.setAddress(null);
	//
	// customer.setUpdatetime(new Date());
	//
	// if (customerBO.modSubmit(customer, adminObject)) {
	// map.put("succes", "success");
	//
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	// } else {
	// map.put("error", customerBO.getMessage());
	//
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }
	//
	// public String passwordmodSubmit() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (!isSessionFlag()) {
	// map.put("error", "out_time");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "nocustomer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// Customer customer = tempcustomers.get(0);
	//
	// if (!customer.getPassword().equals(customerForm.getPassword())) {
	// map.put("error", "oldpasswordwrong");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// customer.setPassword(customerForm.getNewpassword());
	// customerForm.setPassword(null);
	// customerForm.setNewpassword(null);
	//
	// customer.setModpwdtime(new Date());
	//
	// if (customerBO.modSubmit(customer, adminObject)) {
	// map.put("success", "success");
	//
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// sessionBean.setAdminObject(null);
	// sessionBean.setControlBean(null);
	// return SUCCESS;
	// } else {
	// map.put("error", customerBO.getMessage());
	//
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }
	//
	// public String menuQuery() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (!isSessionFlag()) {
	// map.put("error", "out_time");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "no_customer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// Customer customer = tempcustomers.get(0);
	//
	// if (customerForm.getMenutype().equals("Account_Infomation")) {
	//
	// map.put("fullnametxt", customer.getFullname());
	// map.put("emailtxt", customer.getEmail());
	// map.put("mobiletxt", customer.getMobile());
	// map.put("faxtxt", customer.getFax());
	// map.put("countrytxt", customer.getCountry());
	// map.put("citytxt", customer.getCity());
	// map.put("adresstxt", customer.getAddress());
	//
	// customerForm.setMenutype(null);
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	//
	// } else if (customerForm.getMenutype().equals("My_Order")) {
	//
	// List<Order> orderList = customerBO
	// .getOrdersByCustomerId(customer.getUserid());
	// Map<String, Object> listMap = new HashMap<String, Object>();
	// Map<String, Object> applistMap = new HashMap<String, Object>();
	//
	// listMap.put("orderlist", orderList);
	//
	// for (Order i : orderList) {
	// List<productapp> tempproductapplist = customerBO
	// .getAppListByAppidsStr(i.getAppids());
	// Map<String, Object> applistListMap = new HashMap<String, Object>();
	//
	// for (productapp j : tempproductapplist) {
	// if (j != null) {
	// applistListMap.put(j.getAppid().toString(),
	// j.getName() + "," + j.getPrice().toString()
	// + "," + j.getScode() + ","
	// + j.getApptype().toString());
	// }
	// }
	//
	// applistMap.put(i.getOrderid().toString() + "apps",
	// applistListMap);
	// }
	//
	// listMap.put("applist", applistMap);
	//
	// customerForm.setMenutype(null);
	// jo = JSONObject.fromObject(listMap);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	//
	// }
	//
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// return ERROR;
	// }
	//
	// public String getbackpasswordSubmit() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (isSessionFlag()) {
	// map.put("error", "alreadylogin");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(customerForm.getUsername());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "no_customer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	// Customer customer = tempcustomers.get(0);
	//
	// if (!customer.getEmail().equals(customerForm.getEmail())) {
	// map.put("error", "notmatch");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	// try {
	// MailSenderInfo mailInfo = new MailSenderInfo();
	// mailInfo.setMailServerHost("192.168.11.107");
	// mailInfo.setMailServerPort("25");
	// mailInfo.setValidate(true);
	// mailInfo.setUserName("123");
	// mailInfo.setPassword("111111a");
	// mailInfo.setFromAddress("123@127.0.0.1");
	// mailInfo.setToAddress("ledaer@126.com");
	// mailInfo.setSubject("SymbolBox get back pw");
	// mailInfo.setContent("the url,no reply");
	//
	// SimpleMailSender sms = new SimpleMailSender();
	// sms.sendTextMail(mailInfo);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// map.put("success", "success");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }
	//
	// public String addcartSubmit() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (!isSessionFlag()) {
	// map.put("error", "out_time");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "no_customer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// Customer customer = tempcustomers.get(0);
	//
	// Integer tempappid = customerForm.getAddtocartappid();
	//
	// if (tempappid == null) {
	// map.put("error", "noappid");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// if (!customerBO.addAppToCart(customer.getUserid(), tempappid)) {
	// map.put("error", customerBO.getMessage());
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// map.put("success", "success");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }
	//
	// public String removecartSubmit() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (!isSessionFlag()) {
	// map.put("error", "out_time");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "no_customer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// Customer customer = tempcustomers.get(0);
	//
	// Integer tempappid = customerForm.getRemovefromcartappid();
	//
	// if (tempappid == null) {
	// map.put("error", "noappid");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// if (!customerBO.removeAppFromCart(customer.getUserid(), tempappid)) {
	// map.put("error", customerBO.getMessage());
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// map.put("success", "success");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }
	//
	// public String cartlistQuery() throws UIException {
	// try {
	// this.getSession();
	//
	// Map<String, String> map = new HashMap<String, String>();
	//
	// JSONObject jo = null;
	//
	// if (!isSessionFlag()) {
	// map.put("error", "out_time");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// map.put("error", "no_customer");
	// jo = JSONObject.fromObject(map);
	// customerForm.setResult(jo.toString());
	// return ERROR;
	// }
	//
	// Customer customer = tempcustomers.get(0);
	//
	// List<productapp> tempAppList = customerBO
	// .getAppsFromCartByCustomerID(customer.getUserid());
	//
	// Map<String, List<productapp>> mapList = new HashMap<String,
	// List<productapp>>();
	//
	// mapList.put("success", tempAppList);
	// jo = JSONObject.fromObject(mapList);
	// customerForm.setResult(jo.toString());
	// return SUCCESS;
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }
	//
	// public String orderMake() throws UIException {
	// try {
	// this.getSession();
	//
	// if (!isSessionFlag()) {
	// return TIMEOUT;
	// }
	//
	// List<Customer> tempcustomers = customerBO
	// .getCustomersbyUserName(adminObject.getAdminName());
	//
	// if (tempcustomers.size() == 0) {
	// return TIMEOUT;
	// }
	//
	// String tempAppids = customerForm.getAppids();
	//
	// if (tempAppids == null || tempAppids.equals("")) {
	// return ERROR;
	// }
	//
	// List<productapp> tempAppList = customerBO
	// .getAppListByAppidsStr(tempAppids);
	//
	// if (tempAppList.size() == 0) {
	// return ERROR;
	// }
	//
	// customerForm.setAppList(tempAppList);
	//
	// return setProcessResult(customerForm, "info",
	// customerBO.getMessage(), BACKINPUT, SUCCESS);
	// } catch (Exception e) {
	// throw new UIException(e, this.getClass());
	// }
	// }

}
