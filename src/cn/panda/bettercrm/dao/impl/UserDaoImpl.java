package cn.panda.bettercrm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.UserDao;
import cn.panda.bettercrm.domain.User;
import cn.panda.bettercrm.utils.HibernateUtils;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(User user) {
	
		getSession().save(user);
	}

	@Override
	public void delete(Long id) {
		
		User user = (User) getSession().get(User.class, id);
		getSession().delete(user);
		
	}

	@Override
	public void update(User user) {
		
		getSession().update(user);
		
	}

	@Override
	public User find(Long id) {
		
		return (User) getSession().get(User.class, id);
	
	}

	@Override
	public List<User> findAll() {
		
		return getSession().createCriteria(User.class).list();
		
	}

	@Override
	public User findByLNameAndPwd(String loginName, String password) {
		
		return (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq("loginName",loginName))
				.add(Restrictions.eq("password", password))
				.uniqueResult();
	}

	@Override
	public User findByLName(String loginName) {
		
		return (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq(loginName, loginName))
				.uniqueResult();
	}
	

}
