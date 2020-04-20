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
@RequestMapping("/ManageCashierCRUDService")
public class ManageCashierCRUDServiceController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private ManageCashierCRUDService manageCashierCRUDService;
	
	@RequestMapping(value="/createCashier",method=RequestMethod.POST)	
	public String createCashier(CreateCashierMessage createCashierMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashierCRUDService.createCashier(createCashierMsg.id,createCashierMsg.name));
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
	@RequestMapping(value="/queryCashier",method=RequestMethod.GET)	
	public String queryCashier(QueryCashierMessage queryCashierMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashierCRUDService.queryCashier(queryCashierMsg.id));
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
	@RequestMapping(value="/modifyCashier",method=RequestMethod.PUT)	
	public String modifyCashier(ModifyCashierMessage modifyCashierMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashierCRUDService.modifyCashier(modifyCashierMsg.id,modifyCashierMsg.name));
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
	@RequestMapping(value="/deleteCashier",method=RequestMethod.DELETE)	
	public String deleteCashier(DeleteCashierMessage deleteCashierMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashierCRUDService.deleteCashier(deleteCashierMsg.id));
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
