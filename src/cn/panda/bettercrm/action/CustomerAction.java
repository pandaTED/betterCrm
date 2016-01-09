package cn.panda.bettercrm.action;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panda.bettercrm.dao.CustomerDao;
import cn.panda.bettercrm.dao.TrackingDao;
import cn.panda.bettercrm.dao.UserDao;
import cn.panda.bettercrm.domain.Customer;
import cn.panda.bettercrm.domain.Tracking;
import cn.panda.bettercrm.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer;
	
	@Override
	public Customer getModel() {
		if(customer == null){
			customer = new Customer();
		}
		return customer;
	}
	
	
	@Resource
	private CustomerDao cd;
	
//	@Resource
//	private TrackingDao td;
	
	@Resource
	private UserDao ud;
	
	public String saveCustomerUI(){	//准备保存客户的页面
		return "saveCustomerUI";
	}
	public String saveCustomer(){	//保存客户
		User user = (User) ActionContext.getContext().getSession().get("user");
		Long userId = user.getId();
		if(userId==null){
			return "saveCustomerFail";
		}else{
		try{
			Date nowDate = new Date();		//此时的时间	
			customer.setUser(user);
			customer.setCustomerSaveDate(nowDate);
			cd.save(customer);
			return "saveCustomerSuccess";
		}catch(Exception e){
			
			return "saveCustomerFail";
		}
		}
		
	
	}
	
	public String listCustomer(){	//列出所有客户
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Customer> customerList = cd.findByUser(user);
		ActionContext.getContext().put("customerList", customerList);
		
		return "listCustomer";
	}
	
	public String customerDetail(){	//查看客户细节
		
		Customer c = cd.find(customer.getId());
		ActionContext.getContext().getValueStack().push(c);
		
		return "customerDetail";
	}
	
	public String updateCustomerUI(){	//准备修改客户的页面，数据回显
		Customer c = cd.find(customer.getId());
		ActionContext.getContext().getValueStack().push(c);
		
		return "updateCustomerUI";
	}
	
	public String updateCustomer(){		//修改客户信息
		Customer c = cd.find(customer.getId()); 
		
		c.setAge(customer.getAge());
		c.setCellphone(customer.getCellphone());
		c.setCompanyName(customer.getCompanyName());
		c.setCompanyPhone(customer.getCompanyPhone());
		c.setEmail(customer.getEmail());
		c.setName(customer.getName());
		c.setStatus(customer.getStatus());
		c.setBirthday(customer.getBirthday());
		
		cd.update(customer);
		
		return "updateCustomerSuccess";
	}
	
	public String deleteCustomer(){
		
		try{
			cd.delete(customer.getId());
			
			return "deleteCustomerSuccess";
		}catch(Exception e){
			
			return "deleteCustomerFail";
		}
		
	}
	
}
