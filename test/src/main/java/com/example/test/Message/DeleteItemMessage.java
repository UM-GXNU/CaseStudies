package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class DeleteItemMessage{
	public Integer barcode;
	public Integer getBarcode() {
		return barcode;
	}
					
	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}
}
