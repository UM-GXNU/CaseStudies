package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class ChooseSupplierMessage{
	public Integer supplierID;
	public Integer getSupplierID() {
		return supplierID;
	}
					
	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}
}
