package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface CashDeskRepository extends JpaRepository<CashDesk, Integer> ,JpaSpecificationExecutor<CashDesk>{
	List<CashDesk> findByBelongStore(Store store);
	List<CashDesk> findByName(String parm);
	List<CashDesk> findByIsOpened(Boolean parm);

}
