package cn.panda.bettercrm.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panda.bettercrm.dao.UserDao;
import cn.panda.bettercrm.domain.User;

import com.opensymphony.xwork2.ActionContext;
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
		User loginedUser = null;
		loginedUser =  (User) ActionContext.getContext().getSession().get("user");
		if(loginedUser == null ){
			return "loginUI";
		}else{
			return "login_success";
		}
	
	}
	
	public String login(){
		
		if((model.getLoginName()!=null) && (!model.getPassword().trim().equals("")) && (model.getPassword() != null) && (!model.getPassword().trim().equals(""))){
			User user = ud.findByLNameAndPwd(model.getLoginName(), model.getPassword());
			if(user != null){
				ActionContext.getContext().getSession().put("user", user);
				return "login_success";
			}else{
				return "login_fail";
			}
		}else{
			return "login_fail";
		}
	}
	
	public String registerUI(){
		return "registerUI";
	}
	
	
	public String register(){
		
		if(model.getLoginName()!=null && !model.getPassword().trim().equals("") && model.getPassword() != null && !model.getPassword().trim().equals("")){
			ud.save(model);
			return "register_success";
		}else{
			return "register_fail";
		}
	}
	
}
