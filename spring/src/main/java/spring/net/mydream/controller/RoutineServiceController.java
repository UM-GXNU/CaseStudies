package spring.net.mydream.controller;
import spring.net.mydream.service.*;
import spring.net.mydream.Message.*;
import java.util.Date;
import spring.net.mydream.utils.PreconditionException;
import spring.net.mydream.utils.StandardOPs;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/RoutineService")
public class RoutineServiceController {
	
	//@Autowired HttpSession hs;
	
	@Autowired 
	private RoutineService routineService;
	
	
	@RequestMapping(value="/userLogin",method=RequestMethod.GET)	
	public String userLogin(UserLoginMessage userLoginMsg) {
		
		
		JSONObject object = new JSONObject();
		try {
			object.put("data", routineService.userLogin(userLoginMsg.name,userLoginMsg.password));
			object.put("msg", "success");
			object.put("code", "200");
		} catch (Exception e) {
			if (e instanceof PreconditionException) {
				object.put("msg", "PreConditionException");
			}else {
				object.put("msg", "PostConditionException");
				e.printStackTrace();
			}
			object.put("code", "400");
		}
		String s=JSON.toJSONString(object);
		return s;
	}
	
	@RequestMapping(value="/WorkReportSubmit",method=RequestMethod.POST)	
	public String WorkReportSubmit(WorkReportSubmitMessage workReportSubmitMsg) {
		
		
		JSONObject object = new JSONObject();
		try {
			object.put("data", routineService.WorkReportSubmit(workReportSubmitMsg.name,workReportSubmitMsg.content,workReportSubmitMsg.section,workReportSubmitMsg.remark));
			object.put("msg", "success");
			object.put("code", "200");
		} catch (Exception e) {
			if (e instanceof PreconditionException) {
				object.put("msg", "PreConditionException");
			}else {
				object.put("msg", "PostConditionException");
				e.printStackTrace();
			}
			object.put("code", "400");
		}
		String s=JSON.toJSONString(object);
		return s;
	}
}
