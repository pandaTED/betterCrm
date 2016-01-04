package cn.panda.bettercrm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtils {
	
	private SessionFactory sessionFactory;
	
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
