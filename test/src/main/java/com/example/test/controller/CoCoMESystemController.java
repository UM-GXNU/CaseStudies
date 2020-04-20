package com.example.test.controller;
import com.example.test.service.*;
import com.example.test.Message.*;
import java.util.Date;
import com.example.test.PreconditionException;
import com.example.test.StandardOPs;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/CoCoMESystem")
public class CoCoMESystemController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private CoCoMESystem coCoMESystem;
	
	@RequestMapping(value="/changePrice",method=RequestMethod.PUT)	
	public String changePrice(ChangePriceMessage changePriceMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMESystem.changePrice(changePriceMsg.barcode,changePriceMsg.newPrice));
			object.put("msg", "success");
		} catch (Exception e) {
			if (e instanceof PreconditionException) {
				object.put("msg", "PreconditionException");
			}else {
				object.put("msg", e.getMessage());
				e.printStackTrace();
			}
		}
		String s=JSON.toJSONString(object);
		return s;
	}
	@RequestMapping(value="/receiveOrderedProduct",method=RequestMethod.GET)	
	public String receiveOrderedProduct(ReceiveOrderedProductMessage receiveOrderedProductMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMESystem.receiveOrderedProduct(receiveOrderedProductMsg.orderID));
			object.put("msg", "success");
		} catch (Exception e) {
			if (e instanceof PreconditionException) {
				object.put("msg", "PreconditionException");
			}else {
				object.put("msg", e.getMessage());
				e.printStackTrace();
			}
		}
		String s=JSON.toJSONString(object);
		return s;
	}
	@RequestMapping(value="/listSuppliers",method=RequestMethod.GET)	
	public String listSuppliers() {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMESystem.listSuppliers());
			object.put("msg", "success");
		} catch (Exception e) {
			if (e instanceof PreconditionException) {
				object.put("msg", "PreconditionException");
			}else {
				object.put("msg", e.getMessage());
				e.printStackTrace();
			}
		}
		String s=JSON.toJSONString(object);
		return s;
	}
	@RequestMapping(value="/showStockReports",method=RequestMethod.GET)	
	public String showStockReports() {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMESystem.showStockReports());
			object.put("msg", "success");
		} catch (Exception e) {
			if (e instanceof PreconditionException) {
				object.put("msg", "PreconditionException");
			}else {
				object.put("msg", e.getMessage());
				e.printStackTrace();
			}
		}
		String s=JSON.toJSONString(object);
		return s;
	}
}
