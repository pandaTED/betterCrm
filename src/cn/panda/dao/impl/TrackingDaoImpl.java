package cn.panda.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.dao.TrackingDao;
import cn.panda.domain.Customer;
import cn.panda.domain.Tracking;

@Transactional
@Repository
public class TrackingDaoImpl implements TrackingDao {

	@Resource
	//自动注入sessionFactory
	private SessionFactory sessionFactory;
	
	//获取session  
	//currentSession
	private Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	@Override
	//新增
	public void save(Tracking tracking) {

		getSession().save(tracking);

	}

	@Override
	//更新
	public void update(Tracking tracking) {

		getSession().update(tracking);
	}
	
	@Override
	//删除
	public void delete(Long id) {
		Tracking tracking = (Tracking) getSession().get(Tracking.class, id);
		getSession().delete(tracking);

	}

	@Override
	//根据id查找
	public Tracking find(Long id) {

		return (Tracking) getSession().get(Tracking.class, id);
	}

	@Override
	//查询所有
	public List<Tracking> findAll() {

		return getSession().createCriteria(Tracking.class).list();

	}

	@Override
	//查询customer下的所有追踪信息
	public List<Tracking> findByCustomer(Customer customer) {

		return getSession().createCriteria(Tracking.class).add(Restrictions.eq(Messages.getString("TrackingDaoImpl.0"), customer.getId())) //$NON-NLS-1$
				.addOrder(Order.desc(Messages.getString("TrackingDaoImpl.1"))).list(); //$NON-NLS-1$
	}

	


}
