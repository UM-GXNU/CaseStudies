package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface ItemRepository extends JpaRepository<Item, Integer> ,JpaSpecificationExecutor<Item>{
	List<Item> findByBelongCatalog(ProductCatalog productCatalog);
	Item findByBarcode(Integer parm);
	List<Item> findByName(String parm);
	List<Item> findByPrice(Double parm);
	List<Item> findByStockNumber(Integer parm);
	List<Item> findByOrderPrice(Double parm);

}
