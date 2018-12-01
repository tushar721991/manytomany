package com.tt.manytomany.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.tt.manytomany.model.Customer;
import com.tt.manytomany.model.Vendor;

public class SessionFactoryProvider {

	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	static {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure().build();
		sessionFactory = new MetadataSources(registry)				
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Vendor.class)
				.buildMetadata().buildSessionFactory();
	}
}
