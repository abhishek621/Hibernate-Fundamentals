package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create SessionFactory

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session

		Session session = factory.getCurrentSession();

		// use the session object to save the java object
		
		try {
			// create the student object

			System.out.println("Creating new Student object...");

			Student student = new Student("Abhishek", "Singh", "abhishek@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(student);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
