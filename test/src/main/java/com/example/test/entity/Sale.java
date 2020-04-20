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
public class Sale  implements Serializable{
		
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Date time;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	private Boolean isComplete;
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	private Double amount;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	private Boolean isReadytoPay;
	public Boolean getIsReadytoPay() {
		return isReadytoPay;
	}
	public void setIsReadytoPay(Boolean isReadytoPay) {
		this.isReadytoPay = isReadytoPay;
	}
	@ManyToOne(targetEntity=Store.class) 
	@JoinColumn(name="store_id",referencedColumnName="id") 
	private Store belongstore;
			
	public Store getBelongstore() {
		return belongstore;
	}
			
	public void setBelongstore(Store Belongstore) {
		this.belongstore = Belongstore;
	}
	@ManyToOne(targetEntity=CashDesk.class) 
	@JoinColumn(name="cashdesk_id",referencedColumnName="id") 
	private CashDesk belongCashDesk;
			
	public CashDesk getBelongCashDesk() {
		return belongCashDesk;
	}
			
	public void setBelongCashDesk(CashDesk BelongCashDesk) {
		this.belongCashDesk = BelongCashDesk;
	}
		}
