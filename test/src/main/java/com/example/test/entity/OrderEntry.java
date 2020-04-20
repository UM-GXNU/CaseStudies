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
public class OrderEntry  implements Serializable{
		
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
	private Double subAmount;
	public Double getSubAmount() {
		return subAmount;
	}
	public void setSubAmount(Double subAmount) {
		this.subAmount = subAmount;
	}
	@ManyToOne(targetEntity=Item.class) 
	@JoinColumn(name="item_id",referencedColumnName="id") 
	private Item item;
			
	public Item getItem() {
		return item;
	}
			
	public void setItem(Item Item) {
		this.item = Item;
	}
	@ManyToOne(targetEntity=OrderProduct.class) 
	@JoinColumn(name="orderproduct_id",referencedColumnName="id") 
	private OrderProduct belongOrderProduct;
			
	public OrderProduct getBelongOrderProduct() {
		return belongOrderProduct;
	}
			
	public void setBelongOrderProduct(OrderProduct BelongOrderProduct) {
		this.belongOrderProduct = BelongOrderProduct;
	}
		}
