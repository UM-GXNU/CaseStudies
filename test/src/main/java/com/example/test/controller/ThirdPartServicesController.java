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
@RequestMapping("/ThirdPartServices")
public class ThirdPartServicesController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private ThirdPartServices thirdPartServices;
	
	@RequestMapping(value="/thirdPartyCardPaymentService",method=RequestMethod.GET)	
	public String thirdPartyCardPaymentService(ThirdPartyCardPaymentServiceMessage thirdPartyCardPaymentServiceMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", thirdPartServices.thirdPartyCardPaymentService(thirdPartyCardPaymentServiceMsg.cardAccountNumber,thirdPartyCardPaymentServiceMsg.expiryDate,thirdPartyCardPaymentServiceMsg.fee));
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
