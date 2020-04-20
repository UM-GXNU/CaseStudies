package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class OpenStoreMessage{
	public Integer storeID;
	public Integer getStoreID() {
		return storeID;
	}
					
	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}
}
