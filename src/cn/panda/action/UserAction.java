package cn.panda.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.panda.dao.UserDao;
import cn.panda.domain.User;

@Controller
@Scope("prototype")
//用户action
public class UserAction extends ActionSupport implements ModelDriven<User> {

	//loginNameForAjax 登录名	,用于ajax在登录和注册页面验证登录名是否存在
	private String loginNameForAjax;	
	
	public String getLname() {
		return loginNameForAjax;
	}
	
	public void setLname(String loginName) {
		loginNameForAjax = loginName;
	}
	
	
	//user model的生成
	private User user;
	@Override
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp = ServletActionContext.getResponse();

	@Resource
	//userDao 用户数据的DAO
	private UserDao userDao;
	
	
	
	//转向注册界面
	public String registerUI() {
		return Messages.getString("UserAction.26"); //$NON-NLS-1$
	}

	
	//转向登录界面
	public String loginUI() {
		User loginedUser = null;
		loginedUser = (User) ActionContext.getContext().getSession().get(Messages.getString("UserAction.10")); //$NON-NLS-1$
		if (loginedUser == null) {
			return Messages.getString("UserAction.11"); //$NON-NLS-1$
		} else {
			return Messages.getString("UserAction.12"); //$NON-NLS-1$
		}

	}
	
	
	//用户注销
	public String logout() {
		ActionContext.getContext().getSession().remove(Messages.getString("UserAction.13")); //$NON-NLS-1$
		return Messages.getString("UserAction.14"); //$NON-NLS-1$
	}

	
	//用户注册功能
	public String register() {
		if (user.getLoginName() == null || user.getLoginName().trim().equals(Messages.getString("UserAction.15")) || user.getPassword() == null //$NON-NLS-1$
				|| user.getPassword().trim().equals(Messages.getString("UserAction.16"))) { //$NON-NLS-1$

			return Messages.getString("UserAction.17"); //$NON-NLS-1$
		} else {
			String LName = user.getLoginName().trim();
			User u = userDao.findByLName(LName);
			if (u == null) {
				userDao.save(user);
				return Messages.getString("UserAction.18"); //$NON-NLS-1$
			} else {
				System.out.println(Messages.getString("UserAction.19") + LName + Messages.getString("UserAction.20")); //$NON-NLS-1$ //$NON-NLS-2$
				return Messages.getString("UserAction.21"); //$NON-NLS-1$
			}
		}
	}
	
	//用户登录功能
	public String login() {

		if ((user.getLoginName() != null) && (!user.getPassword().trim().equals(Messages.getString("UserAction.0"))) && (user.getPassword() != null) //$NON-NLS-1$
				&& (!user.getPassword().trim().equals(Messages.getString("UserAction.1")))) { //$NON-NLS-1$
			User u = userDao.findByLNameAndPwd(user.getLoginName(), user.getPassword());
			if (u != null) {
				ActionContext.getContext().getSession().put(Messages.getString("UserAction.2"), u); //$NON-NLS-1$
				return Messages.getString("UserAction.3"); //$NON-NLS-1$
			} else {
				return Messages.getString("UserAction.4"); //$NON-NLS-1$
			}
		} else {
			return Messages.getString("UserAction.5"); //$NON-NLS-1$
		}
	}
	
	
	//登录界面AJAX验证登录名是否存在
	public String login_loginNameCheck() throws IOException {
		System.out.println(Messages.getString("UserAction.6")); //$NON-NLS-1$
		resp.setContentType(Messages.getString("UserAction.7")); //$NON-NLS-1$
		PrintWriter writer = resp.getWriter();
		String loginName = loginNameForAjax.trim();
		if (loginName == null || loginName.equals(Messages.getString("UserAction.8"))) { //$NON-NLS-1$
			return null;
		} else {
			User u = userDao.findByLName(loginName);
			if (u == null) {
				writer.println(Messages.getString("UserAction.9")); //$NON-NLS-1$
			} else {
				return null;
			}
		}
		writer.close();
		return null;
	}

	//注册界面验证登录名是否存在
	public String register_loginNameCheck() throws IOException {
		resp.setContentType(Messages.getString("UserAction.22")); //$NON-NLS-1$
		PrintWriter writer = resp.getWriter();
		String loginName = loginNameForAjax.trim();
		if (loginName == null || loginName.equals(Messages.getString("UserAction.23"))) { //$NON-NLS-1$
			return null;
		} else {
			User u = userDao.findByLName(loginName);
			if (u == null) {
				writer.println(Messages.getString("UserAction.24")); //$NON-NLS-1$
			} else {
				writer.println(Messages.getString("UserAction.25")); //$NON-NLS-1$
			}
		}
		writer.close();
		return null;
	}
	
	//struts2自带的表单数据验证功能，因为太繁琐，更换为validate框架
	// public void validateRegister() {
	// if(model.getLoginName() == null ||
	// model.getLoginName().trim().equals("")){
	// this.addFieldError("loginName", "登录名不能为空！");
	// }
	//
	// }

}
