package cn.panda.bettercrm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import cn.panda.bettercrm.dao.TrackingDao;
import cn.panda.bettercrm.domain.Tracking;
import cn.panda.bettercrm.utils.HibernateUtils;

@Transactional
public class TrackingDaoImpl implements TrackingDao {

	HibernateUtils hUtils = new HibernateUtils();
	Session session = hUtils.getCurrentSession();
	
	@Override
	public void save(Tracking tracking) {
		
		session.save(tracking);
		
	}

	@Override
	public void delete(Long id) {
		
		Tracking tracking = (Tracking) session.get(Tracking.class, id);
		session.delete(tracking);
		
	}

	@Override
	public void update(Tracking tracking) {	
		
		session.update(tracking);
	}

	@Override
	public Tracking find(Long id) {
		
		return (Tracking) session.get(Tracking.class, id);
	}

	@Override
	public List<Tracking> findAll() {
		
		return session.createCriteria(Tracking.class).list();
		
		
	}

}
