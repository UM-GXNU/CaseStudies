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
public class CoCoMESystem{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean changePrice(Integer barcode,Double newPrice) throws PreconditionException{
	
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(item)==false)
		{
			item.setPrice(newPrice);
			daoManage.getDao(new Item()).save(item);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean receiveOrderedProduct(Integer orderID) throws PreconditionException{
	
		OrderProduct op=(OrderProduct)DaoManage.getData(daoManage.getDao(new OrderProduct()).findById(orderID));
		if(StandardOPs.oclIsUndefined(op)==false)
		{
			List<OrderEntry>OrderEntryList=daoManage.getDao(new OrderEntry()).findByBelongOrderProduct(op);
			for(OrderEntry oe:OrderEntryList){
				oe.getItem().setStockNumber(oe.getItem().getStockNumber()+oe.getQuantity());
			};
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public List<Supplier> listSuppliers() throws PreconditionException{
	
		if(true)
		{
			return daoManage.getDao(new Supplier()).findAll();
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public List<Item> showStockReports() throws PreconditionException{
	
		if(true)
		{
			return daoManage.getDao(new Item()).findAll();
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
