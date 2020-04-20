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
public class Cashier  implements Serializable{
		
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
	@ManyToOne(targetEntity=Store.class) 
	@JoinColumn(name="store_id",referencedColumnName="id") 
	private Store workedStore;
			
	public Store getWorkedStore() {
		return workedStore;
	}
			
	public void setWorkedStore(Store WorkedStore) {
		this.workedStore = WorkedStore;
	}
		}
