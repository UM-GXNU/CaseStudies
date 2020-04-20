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
public class ManageStoreCRUDService{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean createStore(Integer id,String name,String address,Boolean isopened) throws PreconditionException{
	
		Store store=(Store)DaoManage.getData(daoManage.getDao(new Store()).findById(id));
		if(StandardOPs.oclIsUndefined(store)==true)
		{
			Store sto=new Store();
			sto.setId(id);
			sto.setName(name);
			sto.setAddress(address);
			sto.setIsOpened(isopened);
			daoManage.getDao(new Store()).save(sto);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Store queryStore(Integer id) throws PreconditionException{
	
		Store store=(Store)DaoManage.getData(daoManage.getDao(new Store()).findById(id));
		if(StandardOPs.oclIsUndefined(store)==false)
		{
			return store;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean modifyStore(Integer id,String name,String address,Boolean isopened) throws PreconditionException{
	
		Store store=(Store)DaoManage.getData(daoManage.getDao(new Store()).findById(id));
		if(StandardOPs.oclIsUndefined(store)==false)
		{
			store.setId(id);
			store.setName(name);
			store.setAddress(address);
			store.setIsOpened(isopened);
			daoManage.getDao(new Store()).save(store);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean deleteStore(Integer id) throws PreconditionException{
	
		Store store=(Store)DaoManage.getData(daoManage.getDao(new Store()).findById(id));
		if(StandardOPs.oclIsUndefined(store)==false)
		{
			daoManage.getDao(new Store()).delete(store);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
