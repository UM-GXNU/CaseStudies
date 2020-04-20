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
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Payment  implements Serializable{
		
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Double amountTendered;
	public Double getAmountTendered() {
		return amountTendered;
	}
	public void setAmountTendered(Double amountTendered) {
		this.amountTendered = amountTendered;
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
		}
