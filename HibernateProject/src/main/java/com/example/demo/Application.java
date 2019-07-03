package com.example.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.demo.entity.Customer;

/**
 * @author MSfata Programming Help
 */
public class Application {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
//		insert("Mohammed Shafiq Fata",25000.0, session, transaction);
		delete(2L, session, transaction);
	}

	private static void insert(String string,Double salary, Session session, Transaction transaction) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.getTransaction();
		transaction.begin();
		Customer customer = new Customer();
		customer.setName(string);
		customer.setSalary(salary);
		session.save(customer);
		transaction.commit();
		session.close();
		HibernateUtil.shutdown();
	}

	private static void delete(long l, Session session, Transaction transaction) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.getTransaction();
		transaction.begin();
		Customer customer = new Customer();
		customer.setId(l);
		session.delete(customer);
		transaction.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}