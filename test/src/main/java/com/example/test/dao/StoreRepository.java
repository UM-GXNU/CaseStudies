package com.example.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import java.util.Date;
import com.example.test.entity.*;

public interface StoreRepository extends JpaRepository<Store, Integer> ,JpaSpecificationExecutor<Store>{
	List<Store> findByName(String parm);
	List<Store> findByAddress(String parm);
	List<Store> findByIsOpened(Boolean parm);

}
