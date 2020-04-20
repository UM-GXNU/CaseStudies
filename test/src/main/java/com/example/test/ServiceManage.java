package com.example.test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import com.example.test.service.*;
	@Component
	public class ServiceManage {
	@Autowired
	private CoCoMEProcessSale coCoMEProcessSale;
	@Autowired
	private CoCoMEOrderProducts coCoMEOrderProducts;
	@Autowired
	private CoCoMESystem coCoMESystem;
	@Autowired
	private ThirdPartServices thirdPartServices;
	@Autowired
	private ManageStoreCRUDService manageStoreCRUDService;
	@Autowired
	private ManageProductCatalogCRUDService manageProductCatalogCRUDService;
	@Autowired
	private ManageCashDeskCRUDService manageCashDeskCRUDService;
	@Autowired
	private ManageCashierCRUDService manageCashierCRUDService;
	@Autowired
	private ManageItemCRUDService manageItemCRUDService;
	@Autowired
	private ManageSupplierCRUDService manageSupplierCRUDService;
	public Object getService(String name) {
		if("CoCoMEProcessSale".equals(name)) {
			return coCoMEProcessSale;
		}
		else if("CoCoMEOrderProducts".equals(name)) {
			return coCoMEOrderProducts;
		}
		else if("CoCoMESystem".equals(name)) {
			return coCoMESystem;
		}
		else if("ThirdPartServices".equals(name)) {
			return thirdPartServices;
		}
		else if("ManageStoreCRUDService".equals(name)) {
			return manageStoreCRUDService;
		}
		else if("ManageProductCatalogCRUDService".equals(name)) {
			return manageProductCatalogCRUDService;
		}
		else if("ManageCashDeskCRUDService".equals(name)) {
			return manageCashDeskCRUDService;
		}
		else if("ManageCashierCRUDService".equals(name)) {
			return manageCashierCRUDService;
		}
		else if("ManageItemCRUDService".equals(name)) {
			return manageItemCRUDService;
		}
		else if("ManageSupplierCRUDService".equals(name)) {
			return manageSupplierCRUDService;
		}
		return null;
	}
	}
	