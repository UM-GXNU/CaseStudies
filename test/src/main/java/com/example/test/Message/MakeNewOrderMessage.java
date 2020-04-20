package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class MakeNewOrderMessage{
	public Integer orderid;
	public Integer getOrderid() {
		return orderid;
	}
					
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
}
