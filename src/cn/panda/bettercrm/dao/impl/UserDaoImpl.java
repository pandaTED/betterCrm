package cn.panda.bettercrm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.UserDao;
import cn.panda.bettercrm.domain.User;
import cn.panda.bettercrm.utils.HibernateUtils;

@Transactional
public class UserDaoImpl implements UserDao{
	
	HibernateUtils hbUtils = new HibernateUtils();
	protected Session session = hbUtils.getCurrentSession();
	
	@Override
	public void save(User user) {
	
		session.save(user);
	}

	@Override
	public void delete(Long id) {
		
		User user = (User) session.get(User.class, id);
		session.delete(user);
		
	}

	@Override
	public void update(User user) {
		
		session.update(user);
		
	}

	@Override
	public User find(Long id) {
		
		return (User) session.get(User.class, id);
	
	}

	@Override
	public List<User> findAll() {
		
		return session.createCriteria(User.class).list();
		
	}

	@Override
	public User findByLNameAndPwd(String loginName, String password) {
		
		return (User) session.createCriteria(User.class)
				.add(Restrictions.eq(loginName, loginName))
				.add(Restrictions.eq(password, password));
	}

	@Override
	public User findByLName(String loginName) {
		
		return (User) session.createCriteria(User.class)
				.add(Restrictions.eq(loginName, loginName));
	}
	

}
