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
@RequestMapping("/ManageCashDeskCRUDService")
public class ManageCashDeskCRUDServiceController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private ManageCashDeskCRUDService manageCashDeskCRUDService;
	
	@RequestMapping(value="/createCashDesk",method=RequestMethod.POST)	
	public String createCashDesk(CreateCashDeskMessage createCashDeskMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashDeskCRUDService.createCashDesk(createCashDeskMsg.id,createCashDeskMsg.name,createCashDeskMsg.isopened));
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
	@RequestMapping(value="/queryCashDesk",method=RequestMethod.GET)	
	public String queryCashDesk(QueryCashDeskMessage queryCashDeskMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashDeskCRUDService.queryCashDesk(queryCashDeskMsg.id));
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
	@RequestMapping(value="/modifyCashDesk",method=RequestMethod.PUT)	
	public String modifyCashDesk(ModifyCashDeskMessage modifyCashDeskMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashDeskCRUDService.modifyCashDesk(modifyCashDeskMsg.id,modifyCashDeskMsg.name,modifyCashDeskMsg.isopened));
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
	@RequestMapping(value="/deleteCashDesk",method=RequestMethod.DELETE)	
	public String deleteCashDesk(DeleteCashDeskMessage deleteCashDeskMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageCashDeskCRUDService.deleteCashDesk(deleteCashDeskMsg.id));
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
