package betterCRM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.panda.bettercrm.domain.Customer;
import cn.panda.bettercrm.domain.Tracking;
import cn.panda.bettercrm.domain.User;

public class HibernateTest {
	
	@Test
	public void create(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sf.getCurrentSession();
		Customer customer = new Customer();
		User user = new User();
		Tracking tracking = new Tracking();
		
	}
	
	
	

}
