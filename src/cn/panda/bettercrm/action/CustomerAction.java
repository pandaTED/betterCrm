package cn.panda.bettercrm.action;

import javax.annotation.Resource;

import cn.panda.bettercrm.dao.CustomerDao;
import cn.panda.bettercrm.dao.TrackingDao;
import cn.panda.bettercrm.domain.Customer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

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
	
	@Resource
	private TrackingDao td;
	
	public String saveCustomerUI(){	//准备保存客户的页面
		return "saveCustomerUI";
	}
	public String saveCustomer(){	//保存客户
		
		return "saveCustomer";
	}
	
	public String listCustomer(){	//列出所有客户
		
		return "listCustomer";
	}
	
	public String customerDetail(){	//查看客户细节
		
		return "customerDetail";
	}
	
	public String updateCustomerUI(){	//准备修改客户的页面，数据回显
		
		return "updateCustomerUI";
	}
	
	public String updateCustomer(){		//修改客户信息
		
		return "updateCustomer";
	}
	
}
