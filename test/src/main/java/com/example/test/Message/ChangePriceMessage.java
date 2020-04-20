package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class ChangePriceMessage{
	public Integer barcode;
	public Integer getBarcode() {
		return barcode;
	}
					
	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}
	public Double newPrice;
	public Double getNewPrice() {
		return newPrice;
	}
					
	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}
}
