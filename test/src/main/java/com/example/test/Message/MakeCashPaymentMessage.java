package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class MakeCashPaymentMessage{
	public Double amount;
	public Double getAmount() {
		return amount;
	}
					
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
