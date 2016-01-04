package cn.panda.bettercrm.dao;

import java.util.List;

import cn.panda.bettercrm.domain.User;

/**
 * 增
 * save(User user)		注册
 * 删
 * delete(Long id)		注销
 * 改
 * update(User user)	改密码，邮箱，姓名
 * 查
 * find(Long id)		提供功能
 * findAll()			方便管理员管理
 * findByLNameAndPwd(String loginName,String Password)	验证登录
 * findByLName(String loginName)  用户名查重
 * 
 * @author panda
 */
public interface UserDao {
	
//	 增
	 void save(User user);		//注册
//	 删
	 void delete(Long id);		//注销
//	 改
	 void update(User user);	//改密码，邮箱，姓名
//	 查
	 User find(Long id);		//提供功能
	 List<User> findAll();			//方便管理员管理
	 User findByLNameAndPwd(String loginName,String password);	//验证登录
	 User findByLName(String loginName);  //用户名查重
	
}
