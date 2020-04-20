package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface OrderEntryRepository extends JpaRepository<OrderEntry, Integer> ,JpaSpecificationExecutor<OrderEntry>{
	List<OrderEntry> findByItem(Item item);
	List<OrderEntry> findByBelongOrderProduct(OrderProduct orderProduct);
	List<OrderEntry> findByQuantity(Integer parm);
	List<OrderEntry> findBySubAmount(Double parm);

}
