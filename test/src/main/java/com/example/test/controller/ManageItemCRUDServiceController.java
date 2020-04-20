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
@RequestMapping("/ManageItemCRUDService")
public class ManageItemCRUDServiceController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private ManageItemCRUDService manageItemCRUDService;
	
	@RequestMapping(value="/createItem",method=RequestMethod.POST)	
	public String createItem(CreateItemMessage createItemMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageItemCRUDService.createItem(createItemMsg.barcode,createItemMsg.name,createItemMsg.price,createItemMsg.stocknumber,createItemMsg.orderprice));
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
	@RequestMapping(value="/queryItem",method=RequestMethod.GET)	
	public String queryItem(QueryItemMessage queryItemMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageItemCRUDService.queryItem(queryItemMsg.barcode));
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
	@RequestMapping(value="/modifyItem",method=RequestMethod.PUT)	
	public String modifyItem(ModifyItemMessage modifyItemMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageItemCRUDService.modifyItem(modifyItemMsg.barcode,modifyItemMsg.name,modifyItemMsg.price,modifyItemMsg.stocknumber,modifyItemMsg.orderprice));
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
	@RequestMapping(value="/deleteItem",method=RequestMethod.DELETE)	
	public String deleteItem(DeleteItemMessage deleteItemMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageItemCRUDService.deleteItem(deleteItemMsg.barcode));
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
