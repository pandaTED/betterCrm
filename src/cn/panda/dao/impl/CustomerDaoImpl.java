package cn.panda.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.dao.CustomerDao;
import cn.panda.domain.Customer;
import cn.panda.domain.User;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Resource
	// 自动注入sessionFactory
	private SessionFactory sessionFactory;

	// 获取session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	// 新增客户信息
	public void save(Customer customer) {
		getSession().save(customer);
	}

	@Override
	// 更新客户信息
	public void update(Customer customer) {

		getSession().update(customer);

	}

	@Override
	// deleteById 根据id删除客户
	public void delete(Long id) {
		Customer customer = (Customer) getSession().get(Customer.class, id);
		getSession().delete(customer);

	}

	@Override
	// findById 根据id查找客户
	public Customer find(Long id) {

		return (Customer) getSession().get(Customer.class, id);
	}

	@Override
	// findAllCustomer 查询所有的客户
	public List<Customer> findAll() {
		return getSession().createCriteria(Customer.class).list();
	}

	@Override
	// 查询某个用户的所有客户信息
	public List<Customer> findByUser(User user) {
		return getSession().createCriteria(Customer.class)
				.add(Restrictions.eq(Messages.getString("CustomerDaoImpl.0"), user.getId())).list(); //$NON-NLS-1$
	}

}
