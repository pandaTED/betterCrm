package cn.panda.bettercrm.action;

import javax.annotation.Resource;

import cn.panda.bettercrm.dao.TrackingDao;
import cn.panda.bettercrm.domain.Tracking;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TrackingAction extends ActionSupport implements ModelDriven<Tracking> {
	
	private Tracking tracking;

	@Override
	public Tracking getModel() {
		if(tracking == null){
			tracking = new Tracking();
		}
		return tracking;
	}
	
//	@Resource
//	private TrackingDao td;
	
	

}
