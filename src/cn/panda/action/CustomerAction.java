package cn.panda.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.panda.dao.CustomerDao;
import cn.panda.dao.TrackingDao;
import cn.panda.dao.UserDao;
import cn.panda.domain.Customer;
import cn.panda.domain.User;

@Controller
@Scope("prototype")
//客户信息action
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//customer 客户信息model
	private Customer customer;
	
	//customer model的生成
	@Override
	public Customer getModel() {
		if (customer == null) {
			customer = new Customer();
		}
		return customer;
	}
	
	@Resource
	//customerDao 	客户信息DAO
	private CustomerDao customerDao;

	@Resource
	//trackingDao 	追踪记录DAO
	private TrackingDao trackingDao;
	
	@Resource
	//userDao			用户DAO
	private UserDao userDao;
	

	// 准备保存客户的页面
	public String saveCustomerUI() { 
		return Messages.getString("CustomerAction.17"); //$NON-NLS-1$
	}

	// 准备修改客户的页面，数据回显
	public String updateCustomerUI() { 
		Customer c = customerDao.find(customer.getId());
		ActionContext.getContext().getValueStack().push(c);

		return Messages.getString("CustomerAction.19"); //$NON-NLS-1$
	}

	
	// 新增客户
	public String saveCustomer() { 
		User user = (User) ActionContext.getContext().getSession().get(Messages.getString("CustomerAction.13")); //$NON-NLS-1$
		Long userId = user.getId();
		if (userId == null) {
			return Messages.getString("CustomerAction.14"); //$NON-NLS-1$
		} else {
			try {
				Date nowDate = new Date(); // 此时的时间
				customer.setUser(user);
				customer.setCustomerSaveDate(nowDate);
				customerDao.save(customer);
				return Messages.getString("CustomerAction.15"); //$NON-NLS-1$
			} catch (Exception e) {

				return Messages.getString("CustomerAction.16"); //$NON-NLS-1$
			}
		}
	}
	
	//删除客户
	public String deleteCustomer() {
		try {
			customerDao.delete(customer.getId());
			return Messages.getString("CustomerAction.7"); //$NON-NLS-1$
		} catch (Exception e) {
			return Messages.getString("CustomerAction.8"); //$NON-NLS-1$
		}
	}
	
	
	// 查看详细客户信息
	public String customerDetail() { 
		Long customerId = null;
		customerId = (Long) ActionContext.getContext().getSession().get(Messages.getString("CustomerAction.0")); //$NON-NLS-1$
		if (customerId == null) {
			Customer c = customerDao.find(customer.getId());
			System.out.println(c.getBirthday());
			List trackingList = trackingDao.findByCustomer(c);
			ActionContext.getContext().put(Messages.getString("CustomerAction.1"), trackingList); //$NON-NLS-1$
			ActionContext.getContext().getValueStack().push(c);
			Long cId = c.getId();
			System.out.println(Messages.getString("CustomerAction.2") + cId); //$NON-NLS-1$
			ActionContext.getContext().getSession().put(Messages.getString("CustomerAction.3"), cId); //$NON-NLS-1$
		} else {
			Customer c = customerDao.find(customerId);
			System.out.println(c.getBirthday());
			ActionContext.getContext().getValueStack().push(c);
			ActionContext.getContext().getSession().put(Messages.getString("CustomerAction.4"), c.getId()); //$NON-NLS-1$
			List trackingList = trackingDao.findByCustomer(c);
			ActionContext.getContext().put(Messages.getString("CustomerAction.5"), trackingList); //$NON-NLS-1$
		}
		return Messages.getString("CustomerAction.6"); //$NON-NLS-1$
	}
	
	

	// 列出所有客户
	public String listCustomer() { 
		User user = (User) ActionContext.getContext().getSession().get(Messages.getString("CustomerAction.9")); //$NON-NLS-1$
		List<Customer> customerList = customerDao.findByUser(user);
		ActionContext.getContext().put(Messages.getString("CustomerAction.10"), customerList); //$NON-NLS-1$
		ActionContext.getContext().getSession().remove(Messages.getString("CustomerAction.11")); //$NON-NLS-1$
		return Messages.getString("CustomerAction.12"); //$NON-NLS-1$
	}

	
	// 修改客户信息
	public String updateCustomer() { 
		Customer c = customerDao.find(customer.getId());

		c.setAge(customer.getAge());
		c.setGender(customer.getGender());
		c.setCellphone(customer.getCellphone());
		c.setCompanyName(customer.getCompanyName());
		c.setCompanyPhone(customer.getCompanyPhone());
		c.setEmail(customer.getEmail());
		c.setName(customer.getName());
		c.setStatus(customer.getStatus());
		c.setBirthday(customer.getBirthday());

		customerDao.update(c);

		return Messages.getString("CustomerAction.18"); //$NON-NLS-1$
	}
	
	

}
