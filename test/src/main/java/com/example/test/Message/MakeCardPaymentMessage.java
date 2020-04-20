package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class MakeCardPaymentMessage{
	public String cardAccountNumber;
	public String getCardAccountNumber() {
		return cardAccountNumber;
	}
					
	public void setCardAccountNumber(String cardAccountNumber) {
		this.cardAccountNumber = cardAccountNumber;
	}
	@JsonbDateFormat("yyyy-MM-dd")
	public Date expiryDate;
	public Date getExpiryDate() {
		return expiryDate;
	}
					
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Double fee;
	public Double getFee() {
		return fee;
	}
					
	public void setFee(Double fee) {
		this.fee = fee;
	}
}
