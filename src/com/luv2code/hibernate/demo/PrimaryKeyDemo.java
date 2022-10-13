package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create SessionFactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session

		Session session = factory.getCurrentSession();

		// use the session object to save the java object

		try {
			// create 3 student objects

			System.out.println("Creating new Student object...");

			Student student1 = new Student("John", "Doe", "john@luv2code.com");
			Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
