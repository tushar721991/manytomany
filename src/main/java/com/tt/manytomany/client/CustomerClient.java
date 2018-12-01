package com.tt.manytomany.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tt.manytomany.model.Customer;
import com.tt.manytomany.model.Vendor;
import com.tt.manytomany.util.SessionFactoryProvider;

public class CustomerClient {

	public static void main(String[] args) {
		Vendor vendor1 = new Vendor(101, "OFSS", "Goregaon");
		Vendor vendor2 = new Vendor(102, "Quinnox", "Andheri");
		
		Customer customer1 = new Customer(1234, "Capgemini", "Airoli");
		Customer customer2 = new Customer(1235, "Accenture", "Airoli");

		vendor1.getCustomers().add(customer1);
		vendor1.getCustomers().add(customer2);

		vendor2.getCustomers().add(customer1);
		vendor2.getCustomers().add(customer2);

		customer1.getVendors().add(vendor1);
		customer1.getVendors().add(vendor2);
		
		customer2.getVendors().add(vendor1);
		customer2.getVendors().add(vendor2);
		
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(vendor1);
		session.save(vendor2);

		session.save(customer1);
		session.save(customer2);
		
		tx.commit();
		session.close();
		factory.close();
	}
}
