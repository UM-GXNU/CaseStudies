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
@RequestMapping("/CoCoMEProcessSale")
public class CoCoMEProcessSaleController {
	
	@Autowired HttpSession hs;
	
	@Autowired 
	private CoCoMEProcessSale coCoMEProcessSale;
	
	@RequestMapping(value="/openStore",method=RequestMethod.PUT)	
	public String openStore(OpenStoreMessage openStoreMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.openStore(openStoreMsg.storeID));
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
	@RequestMapping(value="/closeStore",method=RequestMethod.PUT)	
	public String closeStore(CloseStoreMessage closeStoreMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.closeStore(closeStoreMsg.storeID));
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
	@RequestMapping(value="/openCashDesk",method=RequestMethod.PUT)	
	public String openCashDesk(OpenCashDeskMessage openCashDeskMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.openCashDesk(openCashDeskMsg.cashDeskID));
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
	@RequestMapping(value="/closeCashDesk",method=RequestMethod.PUT)	
	public String closeCashDesk(CloseCashDeskMessage closeCashDeskMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.closeCashDesk(closeCashDeskMsg.cashDeskID));
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
	@RequestMapping(value="/makeNewSale",method=RequestMethod.POST)	
	public String makeNewSale() {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.makeNewSale());
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
	@RequestMapping(value="/enterItem",method=RequestMethod.POST)	
	public String enterItem(EnterItemMessage enterItemMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.enterItem(enterItemMsg.barcode,enterItemMsg.quantity));
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
	@RequestMapping(value="/endSale",method=RequestMethod.PUT)	
	public String endSale() {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.endSale());
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
	@RequestMapping(value="/makeCashPayment",method=RequestMethod.POST)	
	public String makeCashPayment(MakeCashPaymentMessage makeCashPaymentMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.makeCashPayment(makeCashPaymentMsg.amount));
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
	@RequestMapping(value="/makeCardPayment",method=RequestMethod.POST)	
	public String makeCardPayment(MakeCardPaymentMessage makeCardPaymentMsg) {
		JSONObject object = new JSONObject();
		try {
			object.put("data", coCoMEProcessSale.makeCardPayment(makeCardPaymentMsg.cardAccountNumber,makeCardPaymentMsg.expiryDate,makeCardPaymentMsg.fee));
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
