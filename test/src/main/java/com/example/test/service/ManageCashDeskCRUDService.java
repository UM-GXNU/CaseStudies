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
public class ManageCashDeskCRUDService{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean createCashDesk(Integer id,String name,Boolean isopened) throws PreconditionException{
	
		CashDesk cashdesk=(CashDesk)DaoManage.getData(daoManage.getDao(new CashDesk()).findById(id));
		if(StandardOPs.oclIsUndefined(cashdesk)==true)
		{
			CashDesk cas=new CashDesk();
			cas.setId(id);
			cas.setName(name);
			cas.setIsOpened(isopened);
			daoManage.getDao(new CashDesk()).save(cas);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public CashDesk queryCashDesk(Integer id) throws PreconditionException{
	
		CashDesk cashdesk=(CashDesk)DaoManage.getData(daoManage.getDao(new CashDesk()).findById(id));
		if(StandardOPs.oclIsUndefined(cashdesk)==false)
		{
			return cashdesk;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean modifyCashDesk(Integer id,String name,Boolean isopened) throws PreconditionException{
	
		CashDesk cashdesk=(CashDesk)DaoManage.getData(daoManage.getDao(new CashDesk()).findById(id));
		if(StandardOPs.oclIsUndefined(cashdesk)==false)
		{
			cashdesk.setId(id);
			cashdesk.setName(name);
			cashdesk.setIsOpened(isopened);
			daoManage.getDao(new CashDesk()).save(cashdesk);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean deleteCashDesk(Integer id) throws PreconditionException{
	
		CashDesk cashdesk=(CashDesk)DaoManage.getData(daoManage.getDao(new CashDesk()).findById(id));
		if(StandardOPs.oclIsUndefined(cashdesk)==false)
		{
			daoManage.getDao(new CashDesk()).delete(cashdesk);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
