package com.hibernatetesting.www.HIBERNATEDEMO;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageMcDonald {

	static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ManageMcDonald md = new ManageMcDonald();
		md.addItem("McChicken", 50, "Veg");
	}

	private void addItem(String mcItem, int mcPrice, String mcType) {
		Session session = factory.openSession();
		session.clear();
		org.hibernate.Transaction tx = null;
		try {
			tx =session.beginTransaction();
			McDonald mc = new McDonald(mcItem, mcPrice, mcType);
			
			tx.commit();
			session.save(mc);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
