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
public class CoCoMEProcessSale{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean openStore(Integer storeID) throws PreconditionException{
	
		Store sto=(Store)DaoManage.getData(daoManage.getDao(new Store()).findById(storeID));
		if(StandardOPs.oclIsUndefined(sto)==false&&sto.getIsOpened()==false)
		{
			hs.setAttribute("currentStore",sto);
			sto.setIsOpened(true);
			daoManage.getDao(new Store()).save(sto);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean closeStore(Integer storeID) throws PreconditionException{
	
		Store sto=(Store)DaoManage.getData(daoManage.getDao(new Store()).findById(storeID));
		if(StandardOPs.oclIsUndefined(sto)==false&&sto.getIsOpened()==true)
		{
			sto.setIsOpened(false);
			daoManage.getDao(new Store()).save(sto);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean openCashDesk(Integer cashDeskID) throws PreconditionException{
	
		Store currentStore=(Store)hs.getAttribute("currentStore");
		CashDesk cd=(CashDesk)DaoManage.getData(daoManage.getDao(new CashDesk()).findById(cashDeskID));
		if(StandardOPs.oclIsUndefined(cd)==false&&cd.getIsOpened()==false&&StandardOPs.oclIsUndefined(currentStore)==false&&currentStore.getIsOpened()==true)
		{
			hs.setAttribute("currentCashDesk",cd);
			cd.setIsOpened(true);
			daoManage.getDao(new CashDesk()).save(cd);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean closeCashDesk(Integer cashDeskID) throws PreconditionException{
	
		Store currentStore=(Store)hs.getAttribute("currentStore");
		CashDesk cd=(CashDesk)DaoManage.getData(daoManage.getDao(new CashDesk()).findById(cashDeskID));
		if(StandardOPs.oclIsUndefined(cd)==false&&cd.getIsOpened()==true&&StandardOPs.oclIsUndefined(currentStore)==false&&currentStore.getIsOpened()==true)
		{
			hs.setAttribute("currentCashDesk",cd);
			cd.setIsOpened(false);
			daoManage.getDao(new CashDesk()).save(cd);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean makeNewSale() throws PreconditionException{
	
		Sale currentSale=(Sale)hs.getAttribute("currentSale");
		CashDesk currentCashDesk=(CashDesk)hs.getAttribute("currentCashDesk");
		if(StandardOPs.oclIsUndefined(currentCashDesk)==false&&currentCashDesk.getIsOpened()==true&&(StandardOPs.oclIsUndefined(currentSale)==true||(StandardOPs.oclIsUndefined(currentSale)==false&&currentSale.getIsComplete()==true)))
		{
			Sale s=new Sale();
			s.setBelongCashDesk(currentCashDesk);
			s.setIsComplete(false);
			s.setIsReadytoPay(false);
			daoManage.getDao(new Sale()).save(s);
			hs.setAttribute("currentSale",s);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean enterItem(Integer barcode,Integer quantity) throws PreconditionException{
	
		Sale currentSale=(Sale)hs.getAttribute("currentSale");
		Item item=daoManage.getDao(new Item()).findByBarcode(barcode);
		if(StandardOPs.oclIsUndefined(currentSale)==false&&currentSale.getIsComplete()==false&&StandardOPs.oclIsUndefined(item)==false&&item.getStockNumber()>0)
		{
			SalesLineItem sli=new SalesLineItem();
			hs.setAttribute("currentSaleLine",sli);
			sli.setBelongSale(currentSale);
			sli.setQuantity(quantity);
			sli.setBelongItem(item);
			item.setStockNumber(item.getStockNumber()-quantity);
			sli.setSubamount(item.getPrice()*quantity);
			daoManage.getDao(new SalesLineItem()).save(sli);
			daoManage.getDao(new Item()).save(item);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Double endSale() throws PreconditionException{
	
		Sale currentSale=(Sale)hs.getAttribute("currentSale");
		List<SalesLineItem> sls=new ArrayList<SalesLineItem>();
		sls=daoManage.getDao(new SalesLineItem()).findByBelongSale(currentSale);
		List<Double> sub=new ArrayList<Double>();
		for(SalesLineItem s : sls ){
			sub.add(s.getSubamount());
		};
		if(StandardOPs.oclIsUndefined(currentSale)==false&&currentSale.getIsComplete()==false&&currentSale.getIsReadytoPay()==false)
		{
			currentSale.setAmount(StandardOPs.sum(sub));
			currentSale.setIsReadytoPay(true);
			daoManage.getDao(new Sale()).save(currentSale);
			return currentSale.getAmount();
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean makeCashPayment(Double amount) throws PreconditionException{
	
		Sale currentSale=(Sale)hs.getAttribute("currentSale");
		Store currentStore=(Store)hs.getAttribute("currentStore");
		if(StandardOPs.oclIsUndefined(currentSale)==false&&currentSale.getIsComplete()==false&&currentSale.getIsReadytoPay()==true&&amount>=currentSale.getAmount())
		{
			CashPayment cp=new CashPayment();
			cp.setAmountTendered(amount);
			cp.setBelongSale(currentSale);
			currentSale.setBelongstore(currentStore);
			currentSale.setIsComplete(true);
			currentSale.setTime(new Date());
			cp.setBalance(amount-currentSale.getAmount());
			daoManage.getDao(new CashPayment()).save(cp);
			daoManage.getDao(new Sale()).save(currentSale);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean makeCardPayment(String cardAccountNumber,Date expiryDate,Double fee) throws PreconditionException{
	
		Sale currentSale=(Sale)hs.getAttribute("currentSale");
		Store currentStore=(Store)hs.getAttribute("currentStore");
		if(StandardOPs.oclIsUndefined(currentSale)==false&&currentSale.getIsComplete()==false&&currentSale.getIsReadytoPay()==true&&((ThirdPartServices) serviceManage.getService("ThirdPartServices")).thirdPartyCardPaymentService(cardAccountNumber,expiryDate,fee))
		{
			CardPayment cdp=new CardPayment();
			cdp.setAmountTendered(fee);
			cdp.setBelongSale(currentSale);
			cdp.setCardAccountNumber(cardAccountNumber);
			cdp.setExpiryDate(expiryDate);
			daoManage.getDao(new CardPayment()).save(cdp);
			currentSale.setBelongstore(currentStore);
			currentSale.setIsComplete(true);
			currentSale.setTime(new Date());
			daoManage.getDao(new Sale()).save(currentSale);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
