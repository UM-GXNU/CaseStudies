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
@RequestMapping("/ManageStoreCRUDService")
public class ManageStoreCRUDServiceController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private ManageStoreCRUDService manageStoreCRUDService;
	
	@RequestMapping(value="/createStore",method=RequestMethod.POST)	
	public String createStore(CreateStoreMessage createStoreMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageStoreCRUDService.createStore(createStoreMsg.id,createStoreMsg.name,createStoreMsg.address,createStoreMsg.isopened));
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
	@RequestMapping(value="/queryStore",method=RequestMethod.GET)	
	public String queryStore(QueryStoreMessage queryStoreMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageStoreCRUDService.queryStore(queryStoreMsg.id));
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
	@RequestMapping(value="/modifyStore",method=RequestMethod.PUT)	
	public String modifyStore(ModifyStoreMessage modifyStoreMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageStoreCRUDService.modifyStore(modifyStoreMsg.id,modifyStoreMsg.name,modifyStoreMsg.address,modifyStoreMsg.isopened));
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
	@RequestMapping(value="/deleteStore",method=RequestMethod.DELETE)	
	public String deleteStore(DeleteStoreMessage deleteStoreMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageStoreCRUDService.deleteStore(deleteStoreMsg.id));
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
