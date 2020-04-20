package com.example.test.entity;

		import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item  implements Serializable{
		
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer barcode;
	public Integer getBarcode() {
		return barcode;
	}
	public void setBarcode(Integer barcode) {
		this.barcode = barcode;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Double price;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	private Integer stockNumber;
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	private Double orderPrice;
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	@ManyToOne(targetEntity=ProductCatalog.class) 
	@JoinColumn(name="productcatalog_id",referencedColumnName="id") 
	private ProductCatalog belongCatalog;
			
	public ProductCatalog getBelongCatalog() {
		return belongCatalog;
	}
			
	public void setBelongCatalog(ProductCatalog BelongCatalog) {
		this.belongCatalog = BelongCatalog;
	}
		}
