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
@RequestMapping("/ManageProductCatalogCRUDService")
public class ManageProductCatalogCRUDServiceController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private ManageProductCatalogCRUDService manageProductCatalogCRUDService;
	
	@RequestMapping(value="/createProductCatalog",method=RequestMethod.POST)	
	public String createProductCatalog(CreateProductCatalogMessage createProductCatalogMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageProductCatalogCRUDService.createProductCatalog(createProductCatalogMsg.id,createProductCatalogMsg.name));
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
	@RequestMapping(value="/queryProductCatalog",method=RequestMethod.GET)	
	public String queryProductCatalog(QueryProductCatalogMessage queryProductCatalogMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageProductCatalogCRUDService.queryProductCatalog(queryProductCatalogMsg.id));
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
	@RequestMapping(value="/modifyProductCatalog",method=RequestMethod.PUT)	
	public String modifyProductCatalog(ModifyProductCatalogMessage modifyProductCatalogMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageProductCatalogCRUDService.modifyProductCatalog(modifyProductCatalogMsg.id,modifyProductCatalogMsg.name));
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
	@RequestMapping(value="/deleteProductCatalog",method=RequestMethod.DELETE)	
	public String deleteProductCatalog(DeleteProductCatalogMessage deleteProductCatalogMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", manageProductCatalogCRUDService.deleteProductCatalog(deleteProductCatalogMsg.id));
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
