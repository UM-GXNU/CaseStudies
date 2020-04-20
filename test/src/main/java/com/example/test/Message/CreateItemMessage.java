package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class CreateItemMessage{
	public Integer barcode;
	public Integer getBarcode() {
		return barcode;
	}
					
	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}
	public String name;
	public String getName() {
		return name;
	}
					
	public void setName(String name) {
		this.name = name;
	}
	public Double price;
	public Double getPrice() {
		return price;
	}
					
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer stocknumber;
	public Integer getStocknumber() {
		return stocknumber;
	}
					
	public void setStocknumber(Integer stocknumber) {
		this.stocknumber = stocknumber;
	}
	public Double orderprice;
	public Double getOrderprice() {
		return orderprice;
	}
					
	public void setOrderprice(Double orderprice) {
		this.orderprice = orderprice;
	}
}
