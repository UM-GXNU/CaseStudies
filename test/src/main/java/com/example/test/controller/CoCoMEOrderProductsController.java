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
@RequestMapping("/CoCoMEOrderProducts")
public class CoCoMEOrderProductsController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private CoCoMEOrderProducts coCoMEOrderProducts;
	
	@RequestMapping(value="/makeNewOrder",method=RequestMethod.POST)	
	public String makeNewOrder(MakeNewOrderMessage makeNewOrderMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEOrderProducts.makeNewOrder(makeNewOrderMsg.orderid));
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
	@RequestMapping(value="/listAllOutOfStoreProducts",method=RequestMethod.GET)	
	public String listAllOutOfStoreProducts() {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEOrderProducts.listAllOutOfStoreProducts());
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
	@RequestMapping(value="/orderItem",method=RequestMethod.POST)	
	public String orderItem(OrderItemMessage orderItemMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEOrderProducts.orderItem(orderItemMsg.barcode,orderItemMsg.quantity));
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
	@RequestMapping(value="/chooseSupplier",method=RequestMethod.PUT)	
	public String chooseSupplier(ChooseSupplierMessage chooseSupplierMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEOrderProducts.chooseSupplier(chooseSupplierMsg.supplierID));
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
	@RequestMapping(value="/placeOrder",method=RequestMethod.GET)	
	public String placeOrder() {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEOrderProducts.placeOrder());
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
