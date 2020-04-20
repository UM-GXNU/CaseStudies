package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface SaleRepository extends JpaRepository<Sale, Integer> ,JpaSpecificationExecutor<Sale>{
	List<Sale> findByBelongstore(Store store);
	List<Sale> findByBelongCashDesk(CashDesk cashDesk);
	List<Sale> findByTime(Date parm);
	List<Sale> findByIsComplete(Boolean parm);
	List<Sale> findByAmount(Double parm);
	List<Sale> findByIsReadytoPay(Boolean parm);

}
