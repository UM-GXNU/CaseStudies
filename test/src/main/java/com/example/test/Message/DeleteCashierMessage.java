package com.example.test.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class DeleteCashierMessage{
	public Integer id;
	public Integer getId() {
		return id;
	}
					
	public void setId(Integer id) {
		this.id = id;
	}
}
