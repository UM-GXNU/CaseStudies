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
public class CoCoMEOrderProducts{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean makeNewOrder(Integer orderid) throws PreconditionException{
	
		if(true)
		{
			OrderProduct op=new OrderProduct();
			op.setId(orderid);
			op.setTime(new Date());
			daoManage.getDao(new OrderProduct()).save(op);
			hs.setAttribute("currentOrderProduct",op);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public List<Item> listAllOutOfStoreProducts() throws PreconditionException{
	
		if(true)
		{
			return daoManage.getDao(new Item()).findByStockNumber(0);
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean orderItem(Integer barcode,Integer quantity) throws PreconditionException{
	
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(item)==false)
		{
			OrderEntry order=new OrderEntry();
			order.setQuantity(quantity);
			order.setSubAmount(item.getOrderPrice()*quantity);
			order.setItem(item);
			daoManage.getDao(new OrderEntry()).save(order);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean chooseSupplier(Integer supplierID) throws PreconditionException{
	
		OrderProduct currentOrderProduct=(OrderProduct)hs.getAttribute("currentOrderProduct");
		Supplier sup=(Supplier)DaoManage.getData(daoManage.getDao(new Supplier()).findById(supplierID));
		if(StandardOPs.oclIsUndefined(sup)==false&&StandardOPs.oclIsUndefined(currentOrderProduct)==false)
		{
			currentOrderProduct.setSupplier(sup);
			daoManage.getDao(new OrderProduct()).save(currentOrderProduct);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean placeOrder() throws PreconditionException{
	
		OrderProduct currentOrderProduct=(OrderProduct)hs.getAttribute("currentOrderProduct");
		if(StandardOPs.oclIsUndefined(currentOrderProduct)==false)
		{
			List<OrderEntry>OrderEntryList=daoManage.getDao(new OrderEntry()).findByBelongOrderProduct(currentOrderProduct);
			for(OrderEntry o:OrderEntryList){
				currentOrderProduct.setAmount(currentOrderProduct.getAmount()+o.getSubAmount());
			};
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
