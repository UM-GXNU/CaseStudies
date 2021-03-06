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
public class CashDesk  implements Serializable{
		
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Boolean isOpened;
	public Boolean getIsOpened() {
		return isOpened;
	}
	public void setIsOpened(Boolean isOpened) {
		this.isOpened = isOpened;
	}
	@ManyToOne(targetEntity=Store.class) 
	@JoinColumn(name="store_id",referencedColumnName="id") 
	private Store belongStore;
			
	public Store getBelongStore() {
		return belongStore;
	}
			
	public void setBelongStore(Store BelongStore) {
		this.belongStore = BelongStore;
	}
		}
