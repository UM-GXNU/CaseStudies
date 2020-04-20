package com.example.test;
	import java.util.Optional;
	import org.springframework.stereotype.Component;
	import org.springframework.beans.factory.annotation.Autowired;
	import com.example.test.dao.*;
	import com.example.test.entity.*;
	@Component
	public class DaoManage {
		@Autowired
		private StoreRepository storeRepository;
		public StoreRepository getDao(Store store) {
			return storeRepository;
		}
		@Autowired
		private ProductCatalogRepository productCatalogRepository;
		public ProductCatalogRepository getDao(ProductCatalog productCatalog) {
			return productCatalogRepository;
		}
		@Autowired
		private CashDeskRepository cashDeskRepository;
		public CashDeskRepository getDao(CashDesk cashDesk) {
			return cashDeskRepository;
		}
		@Autowired
		private SaleRepository saleRepository;
		public SaleRepository getDao(Sale sale) {
			return saleRepository;
		}
		@Autowired
		private CashierRepository cashierRepository;
		public CashierRepository getDao(Cashier cashier) {
			return cashierRepository;
		}
		@Autowired
		private SalesLineItemRepository salesLineItemRepository;
		public SalesLineItemRepository getDao(SalesLineItem salesLineItem) {
			return salesLineItemRepository;
		}
		@Autowired
		private ItemRepository itemRepository;
		public ItemRepository getDao(Item item) {
			return itemRepository;
		}
		@Autowired
		private CashPaymentRepository cashPaymentRepository;
		public CashPaymentRepository getDao(CashPayment cashPayment) {
			return cashPaymentRepository;
		}
		@Autowired
		private CardPaymentRepository cardPaymentRepository;
		public CardPaymentRepository getDao(CardPayment cardPayment) {
			return cardPaymentRepository;
		}
		@Autowired
		private OrderEntryRepository orderEntryRepository;
		public OrderEntryRepository getDao(OrderEntry orderEntry) {
			return orderEntryRepository;
		}
		@Autowired
		private SupplierRepository supplierRepository;
		public SupplierRepository getDao(Supplier supplier) {
			return supplierRepository;
		}
		@Autowired
		private OrderProductRepository orderProductRepository;
		public OrderProductRepository getDao(OrderProduct orderProduct) {
			return orderProductRepository;
		}
		public static Object getData(Optional<?> op) {
			if (op.isPresent()) {
				return op.get();
			} else {
				return null;
			}
		}
	}
	