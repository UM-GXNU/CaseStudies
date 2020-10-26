package spring.net.mydream.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.FetchType;
import java.util.ArrayList;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
public class TbRepairExtra implements Serializable {
	
	/* all primary attributes */
	@Id  // 主键
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 自增长策略
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Boolean admin;
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	private Boolean isReject;
	public Boolean getIsReject() {
		return isReject;
	}
	public void setIsReject(Boolean isReject) {
		this.isReject = isReject;
	}
	
	private String rejectCause;
	public String getRejectCause() {
		return rejectCause;
	}
	public void setRejectCause(String rejectCause) {
		this.rejectCause = rejectCause;
	}
	
	private Integer relayNum;
	public Integer getRelayNum() {
		return relayNum;
	}
	public void setRelayNum(Integer relayNum) {
		this.relayNum = relayNum;
	}
	
	private Boolean arbitrate;
	public Boolean getArbitrate() {
		return arbitrate;
	}
	public void setArbitrate(Boolean arbitrate) {
		this.arbitrate = arbitrate;
	}
	
	private Boolean isAccept;
	public Boolean getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(Boolean isAccept) {
		this.isAccept = isAccept;
	}
	
	private Boolean isComplete;
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	private Date time;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	private String resolvent;
	public String getResolvent() {
		return resolvent;
	}
	public void setResolvent(String resolvent) {
		this.resolvent = resolvent;
	}
	
	private String cause;
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	
		
	
	
	@JsonIgnore	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "belonged_tb_repair_id")
	private TbRepair belongedTbRepair;
			
	public TbRepair getBelongedTbRepair() {
		return belongedTbRepair;
	}
			
	public void setBelongedTbRepair(TbRepair BelongedTbRepair) {
		this.belongedTbRepair = BelongedTbRepair;
	}
		
	
	@ManyToOne(targetEntity=Department.class)
	@JoinColumn(name="belongedassigndepart_id",referencedColumnName="id")
	private Department belongedAssignDepart;
			
	public Department getBelongedAssignDepart() {
		return belongedAssignDepart;
	}
			
	public void setBelongedAssignDepart(Department BelongedAssignDepart) {
		this.belongedAssignDepart = BelongedAssignDepart;
	}
		
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="belongeddistribution_id",referencedColumnName="id")
	private User belongedDistribution;
			
	public User getBelongedDistribution() {
		return belongedDistribution;
	}
			
	public void setBelongedDistribution(User BelongedDistribution) {
		this.belongedDistribution = BelongedDistribution;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TbRepairExtra other = (TbRepairExtra) obj;
		if (!this.getId().equals(other.getId()))
			return false;
		else
			return true;
	}

}
