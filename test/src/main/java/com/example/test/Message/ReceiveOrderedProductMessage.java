package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class ReceiveOrderedProductMessage{
	public Integer orderID;
	public Integer getOrderID() {
		return orderID;
	}
					
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
}
