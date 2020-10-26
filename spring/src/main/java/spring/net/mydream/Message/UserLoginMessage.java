package spring.net.mydream.Message;
import java.sql.Date;
import javax.json.bind.annotation.JsonbDateFormat;

public class UserLoginMessage{
	public String name;
	public String getName() {
		return name;
	}
					
	public void setName(String name) {
		this.name = name;
	}
	public String password;
	public String getPassword() {
		return password;
	}
					
	public void setPassword(String password) {
		this.password = password;
	}
}
