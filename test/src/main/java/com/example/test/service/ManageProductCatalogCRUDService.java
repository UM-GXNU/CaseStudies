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
public class ManageProductCatalogCRUDService{
	@Autowired HttpSession hs;
		@Autowired 
		private DaoManage daoManage;
		
		@Autowired 
		private ServiceManage serviceManage;
	
	public Boolean createProductCatalog(Integer id,String name) throws PreconditionException{
	
		ProductCatalog productcatalog=(ProductCatalog)DaoManage.getData(daoManage.getDao(new ProductCatalog()).findById(id));
		if(StandardOPs.oclIsUndefined(productcatalog)==true)
		{
			ProductCatalog pro=new ProductCatalog();
			pro.setId(id);
			pro.setName(name);
			daoManage.getDao(new ProductCatalog()).save(pro);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public ProductCatalog queryProductCatalog(Integer id) throws PreconditionException{
	
		ProductCatalog productcatalog=(ProductCatalog)DaoManage.getData(daoManage.getDao(new ProductCatalog()).findById(id));
		if(StandardOPs.oclIsUndefined(productcatalog)==false)
		{
			return productcatalog;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean modifyProductCatalog(Integer id,String name) throws PreconditionException{
	
		ProductCatalog productcatalog=(ProductCatalog)DaoManage.getData(daoManage.getDao(new ProductCatalog()).findById(id));
		if(StandardOPs.oclIsUndefined(productcatalog)==false)
		{
			productcatalog.setId(id);
			productcatalog.setName(name);
			daoManage.getDao(new ProductCatalog()).save(productcatalog);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
	
	public Boolean deleteProductCatalog(Integer id) throws PreconditionException{
	
		ProductCatalog productcatalog=(ProductCatalog)DaoManage.getData(daoManage.getDao(new ProductCatalog()).findById(id));
		if(StandardOPs.oclIsUndefined(productcatalog)==false)
		{
			daoManage.getDao(new ProductCatalog()).delete(productcatalog);
			return true;
		}else{
		
		 	 throw new PreconditionException();
		
		}
}
}
