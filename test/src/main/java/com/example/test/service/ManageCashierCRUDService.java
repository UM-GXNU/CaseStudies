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
public class ManageCashierCRUDService{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean createCashier(Integer id,String name) throws PreconditionException{
	
		Cashier cashier=(Cashier)DaoManage.getData(daoManage.getDao(new Cashier()).findById(id));
		if(StandardOPs.oclIsUndefined(cashier)==true)
		{
			Cashier cas=new Cashier();
			cas.setId(id);
			cas.setName(name);
			daoManage.getDao(new Cashier()).save(cas);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Cashier queryCashier(Integer id) throws PreconditionException{
	
		Cashier cashier=(Cashier)DaoManage.getData(daoManage.getDao(new Cashier()).findById(id));
		if(StandardOPs.oclIsUndefined(cashier)==false)
		{
			return cashier;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean modifyCashier(Integer id,String name) throws PreconditionException{
	
		Cashier cashier=(Cashier)DaoManage.getData(daoManage.getDao(new Cashier()).findById(id));
		if(StandardOPs.oclIsUndefined(cashier)==false)
		{
			cashier.setId(id);
			cashier.setName(name);
			daoManage.getDao(new Cashier()).save(cashier);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean deleteCashier(Integer id) throws PreconditionException{
	
		Cashier cashier=(Cashier)DaoManage.getData(daoManage.getDao(new Cashier()).findById(id));
		if(StandardOPs.oclIsUndefined(cashier)==false)
		{
			daoManage.getDao(new Cashier()).delete(cashier);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
