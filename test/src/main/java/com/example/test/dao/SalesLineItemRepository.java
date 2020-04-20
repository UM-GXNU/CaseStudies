package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface SalesLineItemRepository extends JpaRepository<SalesLineItem, Integer> ,JpaSpecificationExecutor<SalesLineItem>{
	List<SalesLineItem> findByBelongSale(Sale sale);
	List<SalesLineItem> findByBelongItem(Item item);
	List<SalesLineItem> findByQuantity(Integer parm);
	List<SalesLineItem> findBySubamount(Double parm);

}
