package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface CashierRepository extends JpaRepository<Cashier, Integer> ,JpaSpecificationExecutor<Cashier>{
	List<Cashier> findByWorkedStore(Store store);
	List<Cashier> findByName(String parm);

}
