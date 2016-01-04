package cn.panda.bettercrm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.CustomerDao;
import cn.panda.bettercrm.domain.Customer;
import cn.panda.bettercrm.domain.User;
import cn.panda.bettercrm.utils.HibernateUtils;

@Transactional
public class CustomerDaoImpl implements CustomerDao {
	
	HibernateUtils hUtils = new HibernateUtils();
	Session session = hUtils.getCurrentSession();
	
	@Override
	public void save(Customer customer) {
		
		session.save(customer);
		
	}

	@Override
	public void delete(Long id) {
		
		Customer customer = (Customer) session.get(Customer.class, id);
		session.delete(customer);
		
	}

	@Override
	public void update(Customer customer) {
		
		session.update(customer);
		
	}

	@Override
	public Customer find(Long id) {
		
		return (Customer) session.get(Customer.class, id);
	}

	@Override
	public List<Customer> findAll() {
		
		return session.createCriteria(Customer.class).list();
		
	}

}
