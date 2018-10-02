package test;

import org.hibernate.Session;

import dao.HibernateUtil;



public class Test {

	public static void main(String[] args) {
			Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		session.close();
	}

}
