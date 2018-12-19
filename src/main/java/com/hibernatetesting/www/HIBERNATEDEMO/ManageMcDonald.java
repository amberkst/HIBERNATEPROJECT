package com.hibernatetesting.www.HIBERNATEDEMO;

import java.util.Iterator;
import java.util.List;

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
		md.listItem();

	}

	private void addItem(String mcItem, int mcPrice, String mcType) {
		Session session = factory.openSession();
		// session.clear();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			McDonald mc = new McDonald(mcItem, mcPrice, mcType);

			tx.commit();
			session.save(mc);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void listItem() {
		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List lst = session.createQuery("FROM McDonald").list(); 
			Iterator itr = lst.iterator();
			while(itr.hasNext()) {
	        	 McDonald mc = (McDonald) itr.next(); 
	            System.out.print("ID:" + mc.getMcId()+" "); 
	            System.out.print("ITEM:" + mc.getMcItem()); 
	            System.out.print("  PRICE: " + mc.getMcPrice()); 
	            System.out.println("  TYPE: " + mc.getMcType()); 
	         }
	         tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
