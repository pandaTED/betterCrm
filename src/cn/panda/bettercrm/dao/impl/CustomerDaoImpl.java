package cn.panda.bettercrm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.CustomerDao;
import cn.panda.bettercrm.domain.Customer;
import cn.panda.bettercrm.domain.User;
import cn.panda.bettercrm.utils.HibernateUtils;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Customer customer) {
		
		getSession().save(customer);
		
	}

	@Override
	public void delete(Long id) {
		
		Customer customer = (Customer) getSession().get(Customer.class, id);
		getSession().delete(customer);
		
	}

	@Override
	public void update(Customer customer) {
		
		getSession().update(customer);
		
	}

	@Override
	public Customer find(Long id) {
		
		return (Customer) getSession().get(Customer.class, id);
	}

	@Override
	public List<Customer> findAll() {
		
		return getSession().createCriteria(Customer.class).list();
		
	}

}
