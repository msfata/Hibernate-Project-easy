package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.demo.entity.Customer;

/**
 * @author MSfata Programming Help
 */
public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<String, String> settings = new HashMap<>();
				settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
				settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
				settings.put("hibernate.connection.username", "root");
				settings.put("hibernate.connection.password", "");
				settings.put("hibernate.show_sql", "true");
				// create = create table auto original was update
				settings.put("hibernate.hbm2ddl.auto", "update");

				registryBuilder.applySettings(settings);
				registry = registryBuilder.build();
				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Customer.class);

				sessionFactory = sources.buildMetadata().buildSessionFactory();

			} catch (Exception e) {
				System.out.println("SessionFactory creation failed");
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}