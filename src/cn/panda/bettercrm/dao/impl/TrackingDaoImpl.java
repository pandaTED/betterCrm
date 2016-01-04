package cn.panda.bettercrm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.TrackingDao;
import cn.panda.bettercrm.domain.Tracking;
import cn.panda.bettercrm.utils.HibernateUtils;

@Transactional
@Repository
public class TrackingDaoImpl implements TrackingDao {

	@Resource
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(Tracking tracking) {
		
		getSession().save(tracking);
		
	}

	@Override
	public void delete(Long id) {
		
		Tracking tracking = (Tracking) getSession().get(Tracking.class, id);
		getSession().delete(tracking);
		
	}

	@Override
	public void update(Tracking tracking) {	
		
		getSession().update(tracking);
	}

	@Override
	public Tracking find(Long id) {
		
		return (Tracking) getSession().get(Tracking.class, id);
	}

	@Override
	public List<Tracking> findAll() {
		
		return getSession().createCriteria(Tracking.class).list();
		
		
	}

}
