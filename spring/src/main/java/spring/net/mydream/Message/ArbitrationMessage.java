package spring.net.mydream.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class ArbitrationMessage{
	public Integer tbId;
	public Integer getTbId() {
		return tbId;
	}
					
	public void setTbId(Integer tbId) {
		this.tbId = tbId;
	}
	public Integer departmentid;
	public Integer getDepartmentid() {
		return departmentid;
	}
					
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
}
