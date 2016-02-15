package cn.panda.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.panda.dao.CustomerDao;
import cn.panda.dao.TrackingDao;
import cn.panda.domain.Customer;
import cn.panda.domain.Tracking;

@Controller
@Scope("prototype")
//追踪记录action
public class TrackingAction extends ActionSupport implements ModelDriven<Tracking> {
	
	//tracking 追踪记录model
	private Tracking tracking;
	@Override
	public Tracking getModel() {
		if (tracking == null) {
			tracking = new Tracking();
		}
		return tracking;
	}
	
	@Resource
	//customerDao 	客户信息DAO
	private CustomerDao customerDao;

	@Resource
	//trackingDao 	追踪记录DAO
	private TrackingDao trackingDao;

	//新增追踪信息
	public String addTracking() {
		if (tracking.getText() == null || tracking.getText().trim().equals(Messages.getString("TrackingAction.0"))) { //$NON-NLS-1$
			System.out.println(Messages.getString("TrackingAction.1")); //$NON-NLS-1$
			return Messages.getString("TrackingAction.2"); //$NON-NLS-1$
		} else {
			String text = tracking.getText().trim();
			text = StringEscapeUtils.escapeHtml4(text);
			tracking.setText(text);
			Date nowDate = new Date();
			Long customerId = (Long) ActionContext.getContext().getSession().get(Messages.getString("TrackingAction.3")); //$NON-NLS-1$
			Customer customer = customerDao.find(customerId);
			tracking.setCustomer(customer);
			tracking.setTrackingSaveDate(nowDate);
			trackingDao.save(tracking);

			return Messages.getString("TrackingAction.4"); //$NON-NLS-1$
		}

	}
	
	
	//删除追踪信息
	public String deleteTracking() {

		System.out.println(Messages.getString("TrackingAction.5") + tracking.getId()); //$NON-NLS-1$
		trackingDao.delete(tracking.getId());

		return Messages.getString("TrackingAction.6"); //$NON-NLS-1$
	}
}
