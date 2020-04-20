package com.example.test.service;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test.entity.*;
import com.example.test.DaoManage;
import com.example.test.PreconditionException;
import com.example.test.ServiceManage;
import com.example.test.StandardOPs;

@Service
public class ManageItemCRUDService{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean createItem(Integer barcode,String name,Double price,Integer stocknumber,Double orderprice) throws PreconditionException{
	
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(item)==true)
		{
			Item ite=new Item();
			ite.setBarcode(barcode);
			ite.setName(name);
			ite.setPrice(price);
			ite.setStockNumber(stocknumber);
			ite.setOrderPrice(orderprice);
			daoManage.getDao(new Item()).save(ite);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Item queryItem(Integer barcode) throws PreconditionException{
	
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(item)==false)
		{
			return item;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean modifyItem(Integer barcode,String name,Double price,Integer stocknumber,Double orderprice) throws PreconditionException{
	
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(item)==false)
		{
			item.setBarcode(barcode);
			item.setName(name);
			item.setPrice(price);
			item.setStockNumber(stocknumber);
			item.setOrderPrice(orderprice);
			daoManage.getDao(new Item()).save(item);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean deleteItem(Integer barcode) throws PreconditionException{
	
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(item)==false)
		{
			daoManage.getDao(new Item()).delete(item);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
