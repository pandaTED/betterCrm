package cn.panda.bettercrm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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
	private String Lname;

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

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
	
		if(model.getLoginName()==null || model.getLoginName().trim().equals("") || model.getPassword()==null ||model.getPassword().trim().equals("")){
			
			return "register_fail";
		}else{
			String LName = model.getLoginName().trim();
			User user = ud.findByLName(LName);
			if(user==null){
				ud.save(model);
				return "register_success";
			}else{
				System.out.println("登录名："+LName+"已存在，请更换！");
				return "register_fail";
			}
		}
	}
	
	public String logout(){
		ActionContext.getContext().getSession().remove("user");
		return "loginUI";
	}

	HttpServletRequest  req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();
	
	
	public String register_loginNameCheck() throws IOException{
	
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String loginName = Lname.trim();
		if(loginName == null || loginName.equals("")){
			return null;
		}else{
			User user = ud.findByLName(loginName);
			if(user == null){
				writer.println("<font color='green'>当前用户名没人使用，可以注册</font>");
			}else{
				writer.println("<font color='red'>当前用户名已注册，请更换！</font>");
			}
		}
		writer.close();
		return null;
	}
	
	public String login_loginNameCheck() throws IOException{
		System.out.println("login_loginNameCheck执行了！");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String loginName = Lname.trim();
		if(loginName == null || loginName.equals("")){
			return null;
		}else{
			User user = ud.findByLName(loginName);
			if(user == null){
				writer.println("<font color='red'>用户名不存在</font>");
			}else{
				return null;
			}
		}
		writer.close();
		return null;
	}
	
//	public void validateRegister() {
//		if(model.getLoginName() == null || model.getLoginName().trim().equals("")){
//			this.addFieldError("loginName", "登录名不能为空！");
//		}
//		
//	}
	
}
