package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class OrderItemMessage{
	public Integer barcode;
	public Integer getBarcode() {
		return barcode;
	}
					
	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}
	public Integer quantity;
	public Integer getQuantity() {
		return quantity;
	}
					
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
