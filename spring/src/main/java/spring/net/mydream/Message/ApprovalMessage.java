package spring.net.mydream.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class ApprovalMessage{
	public Integer tbId;
	public Integer getTbId() {
		return tbId;
	}
					
	public void setTbId(Integer tbId) {
		this.tbId = tbId;
	}
	public Boolean isApproved;
	public Boolean getIsApproved() {
		return isApproved;
	}
					
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
}
