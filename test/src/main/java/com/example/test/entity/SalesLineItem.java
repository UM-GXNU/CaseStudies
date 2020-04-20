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
public class SalesLineItem  implements Serializable{
		
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer quantity;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	private Double subamount;
	public Double getSubamount() {
		return subamount;
	}
	public void setSubamount(Double subamount) {
		this.subamount = subamount;
	}
	@ManyToOne(targetEntity=Sale.class) 
	@JoinColumn(name="sale_id",referencedColumnName="id") 
	private Sale belongSale;
			
	public Sale getBelongSale() {
		return belongSale;
	}
			
	public void setBelongSale(Sale BelongSale) {
		this.belongSale = BelongSale;
	}
	@ManyToOne(targetEntity=Item.class) 
	@JoinColumn(name="item_id",referencedColumnName="id") 
	private Item belongItem;
			
	public Item getBelongItem() {
		return belongItem;
	}
			
	public void setBelongItem(Item BelongItem) {
		this.belongItem = BelongItem;
	}
		}
