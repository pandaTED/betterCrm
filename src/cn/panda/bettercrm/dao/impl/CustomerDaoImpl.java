package cn.panda.bettercrm.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.CustomerDao;
import cn.panda.bettercrm.domain.Customer;

@Transactional
public class CustomerDaoImpl implements CustomerDao {
	
	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
