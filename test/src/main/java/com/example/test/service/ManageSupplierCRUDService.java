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
public class ManageSupplierCRUDService{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean createSupplier(Integer id,String name) throws PreconditionException{
	
		Supplier supplier=(Supplier)DaoManage.getData(daoManage.getDao(new Supplier()).findById(id));
		if(StandardOPs.oclIsUndefined(supplier)==true)
		{
			Supplier sup=new Supplier();
			sup.setId(id);
			sup.setName(name);
			daoManage.getDao(new Supplier()).save(sup);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Supplier querySupplier(Integer id) throws PreconditionException{
	
		Supplier supplier=(Supplier)DaoManage.getData(daoManage.getDao(new Supplier()).findById(id));
		if(StandardOPs.oclIsUndefined(supplier)==false)
		{
			return supplier;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean modifySupplier(Integer id,String name) throws PreconditionException{
	
		Supplier supplier=(Supplier)DaoManage.getData(daoManage.getDao(new Supplier()).findById(id));
		if(StandardOPs.oclIsUndefined(supplier)==false)
		{
			supplier.setId(id);
			supplier.setName(name);
			daoManage.getDao(new Supplier()).save(supplier);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean deleteSupplier(Integer id) throws PreconditionException{
	
		Supplier supplier=(Supplier)DaoManage.getData(daoManage.getDao(new Supplier()).findById(id));
		if(StandardOPs.oclIsUndefined(supplier)==false)
		{
			daoManage.getDao(new Supplier()).delete(supplier);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
