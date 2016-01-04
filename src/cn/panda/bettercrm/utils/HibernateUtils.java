package cn.panda.bettercrm.utils;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
@Deprecated
public class HibernateUtils {
	
	
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
