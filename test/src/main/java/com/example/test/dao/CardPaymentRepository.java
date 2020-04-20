package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface CardPaymentRepository extends JpaRepository<CardPayment, Integer> ,JpaSpecificationExecutor<CardPayment>{
	List<CardPayment> findByCardAccountNumber(String parm);
	List<CardPayment> findByExpiryDate(Date parm);

}
