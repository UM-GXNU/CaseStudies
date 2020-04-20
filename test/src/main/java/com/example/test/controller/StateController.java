package com.example.test.controller;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import com.example.test.entity.*;
	import com.alibaba.fastjson.JSON;
	import com.alibaba.fastjson.JSONObject;
	import com.example.test.DaoManage;
	@RestController
	@RequestMapping("/state")
	public class StateController {
		@Autowired 
		private DaoManage daoManage;
		@RequestMapping(value="/StoreTable",method=RequestMethod.GET)	
		public String StoreTables() {
		JSONObject object = new JSONObject();
		List<Store>list=daoManage.getDao(new Store()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/ProductCatalogTable",method=RequestMethod.GET)	
		public String ProductCatalogTables() {
		JSONObject object = new JSONObject();
		List<ProductCatalog>list=daoManage.getDao(new ProductCatalog()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/CashDeskTable",method=RequestMethod.GET)	
		public String CashDeskTables() {
		JSONObject object = new JSONObject();
		List<CashDesk>list=daoManage.getDao(new CashDesk()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/SaleTable",method=RequestMethod.GET)	
		public String SaleTables() {
		JSONObject object = new JSONObject();
		List<Sale>list=daoManage.getDao(new Sale()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/CashierTable",method=RequestMethod.GET)	
		public String CashierTables() {
		JSONObject object = new JSONObject();
		List<Cashier>list=daoManage.getDao(new Cashier()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/SalesLineItemTable",method=RequestMethod.GET)	
		public String SalesLineItemTables() {
		JSONObject object = new JSONObject();
		List<SalesLineItem>list=daoManage.getDao(new SalesLineItem()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/ItemTable",method=RequestMethod.GET)	
		public String ItemTables() {
		JSONObject object = new JSONObject();
		List<Item>list=daoManage.getDao(new Item()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/CashPaymentTable",method=RequestMethod.GET)	
		public String CashPaymentTables() {
		JSONObject object = new JSONObject();
		List<CashPayment>list=daoManage.getDao(new CashPayment()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/CardPaymentTable",method=RequestMethod.GET)	
		public String CardPaymentTables() {
		JSONObject object = new JSONObject();
		List<CardPayment>list=daoManage.getDao(new CardPayment()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/OrderEntryTable",method=RequestMethod.GET)	
		public String OrderEntryTables() {
		JSONObject object = new JSONObject();
		List<OrderEntry>list=daoManage.getDao(new OrderEntry()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/SupplierTable",method=RequestMethod.GET)	
		public String SupplierTables() {
		JSONObject object = new JSONObject();
		List<Supplier>list=daoManage.getDao(new Supplier()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
		@RequestMapping(value="/OrderProductTable",method=RequestMethod.GET)	
		public String OrderProductTables() {
		JSONObject object = new JSONObject();
		List<OrderProduct>list=daoManage.getDao(new OrderProduct()).findAll();
		object.put("list", list);
		String s=JSON.toJSONString(object);
		return s;
		}
	}
	