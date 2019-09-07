package com.mohdfai.dto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author mohdfai
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final Logger logger = LogManager.getLogger("HibernateUtil");

	/**
	 * This is a generic method used to build SessionFactory object
	 * @return SessionFactory object
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException exception) {
			// Make sure you log the exception, as it might be swallowed
			logger.info("SessionFactory creation failed." + exception);
			throw new ExceptionInInitializerError(exception);
		}
	}

	/**
	 * Loads session factory object
	 * @return SessionFactory object
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Close caches and connection pools
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}

}
