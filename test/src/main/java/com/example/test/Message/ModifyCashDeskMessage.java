package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class ModifyCashDeskMessage{
	public Integer id;
	public Integer getId() {
		return id;
	}
					
	public void setId(Integer id) {
		this.id = id;
	}
	public String name;
	public String getName() {
		return name;
	}
					
	public void setName(String name) {
		this.name = name;
	}
	public Boolean isopened;
	public Boolean getIsopened() {
		return isopened;
	}
					
	public void setIsopened(Boolean isopened) {
		this.isopened = isopened;
	}
}
