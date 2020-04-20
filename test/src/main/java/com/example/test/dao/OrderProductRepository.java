package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> ,JpaSpecificationExecutor<OrderProduct>{
	List<OrderProduct> findBySupplier(Supplier supplier);
	List<OrderProduct> findByTime(Date parm);
	List<OrderProduct> findByAmount(Double parm);

}
