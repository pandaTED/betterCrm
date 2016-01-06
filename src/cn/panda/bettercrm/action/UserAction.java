package cn.panda.bettercrm.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panda.bettercrm.dao.UserDao;
import cn.panda.bettercrm.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User model;
	@Override
	public User getModel() {
		if(model == null){
			model = new User();
		}
		return model;
	}
	
	@Resource
	private UserDao ud;
	
	public String loginUI(){
		return "loginUI";
	}
	
	public String login(){
		User user = ud.findByLNameAndPwd(model.getLoginName(), model.getPassword());
		if(user != null){
			return "login_sucess";
		}else{
			return "login_fail";
		}
	}
	
	public String registerUI(){
		return "registerUI";
	}
	
	
	public String register(){
		
		if((model.getLoginName() !=null) 
				&& !(model.getLoginName().equals(""))
				&&(model.getPassword() != null)
				&& !(model.getPassword().equals(""))){
			
			ud.save(model);
			return "register_sucess";
		}else{
			return "register_fail";
		}
	}
	
	
}
