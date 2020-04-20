package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> ,JpaSpecificationExecutor<Supplier>{
	List<Supplier> findByName(String parm);

}
