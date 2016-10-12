package ja.dao.impl;

import ja.dao.impl.PersonDTO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import ja.dao.api.Dao;


public class DaoImplHibernate implements Dao {
	private static SessionFactory factory;

	public DaoImplHibernate() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			
			throw new ExceptionInInitializerError(ex);
		}
	}

	public void AddPerson(String first, String last, int age) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			PersonDTO person = new PersonDTO(first, last, age);
			session.save(person);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
