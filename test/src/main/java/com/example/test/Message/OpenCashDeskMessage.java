package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class OpenCashDeskMessage{
	public Integer cashDeskID;
	public Integer getCashDeskID() {
		return cashDeskID;
	}
					
	public void setCashDeskID(Integer cashDeskID) {
		this.cashDeskID = cashDeskID;
	}
}
