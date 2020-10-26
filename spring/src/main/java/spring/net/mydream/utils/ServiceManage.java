package spring.net.mydream.utils;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;
	import spring.net.mydream.service.*;
	@Component
	public class ServiceManage {
	@Autowired
	private SystemService systemService;
	@Autowired
	private RoutineService routineService;
	@Autowired
	private RepairService repairService;
	@Autowired
	private HandleService handleService;
	@Autowired
	private MaintainService maintainService;
	@Autowired
	private ManageService manageService;
	public Object getService(String name) {
		if("SystemService".equals(name)) {
			return systemService;
		}
		else if("RoutineService".equals(name)) {
			return routineService;
		}
		else if("RepairService".equals(name)) {
			return repairService;
		}
		else if("HandleService".equals(name)) {
			return handleService;
		}
		else if("MaintainService".equals(name)) {
			return maintainService;
		}
		else if("ManageService".equals(name)) {
			return manageService;
		}
		return null;
	}
	}
	