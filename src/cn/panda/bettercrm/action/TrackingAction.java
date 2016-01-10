package cn.panda.bettercrm.action;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panda.bettercrm.dao.CustomerDao;
import cn.panda.bettercrm.dao.TrackingDao;
import cn.panda.bettercrm.domain.Customer;
import cn.panda.bettercrm.domain.Tracking;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class TrackingAction extends ActionSupport implements ModelDriven<Tracking> {
	
	private Tracking tracking;
	
	@Override
	public Tracking getModel() {
		if(tracking == null){
			tracking = new Tracking();
		}
		return tracking;
	}
	
	@Resource
	private TrackingDao td;
	
	@Resource
	private CustomerDao cd;
	
	
	public String addTracking(){
		if(tracking.getText() == null || tracking.getText().trim().equals("")){
			
			return "customerDetail";
		}else{
			Date nowDate = new Date();
			Long customerId = (Long) ActionContext.getContext().getSession().get("customerId");
			System.out.println("addtracking中customerId"+customerId);
			Customer customer = cd.find(customerId);
			
			tracking.setCustomer(customer);
			tracking.setTrackingSaveDate(nowDate);
			
			td.save(tracking);
			
			return "saveTrackingSuccess";	
		}
		
	}
	
	public String deleteTracking(){
		
		System.out.println("deletTracking内："+tracking.getId());
		td.delete(tracking.getId());
		
		return "deleteTrackingSuccess";
	}
	
}
