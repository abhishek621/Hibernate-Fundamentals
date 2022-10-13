package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create SessionFactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session

		Session session = factory.getCurrentSession();

		// use the session object to save the java object

		try {
			// create the student object

			System.out.println("Creating new Student object...");

			Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);

			// commit the transaction
			session.getTransaction().commit();

			// My new code

			// find out student'd id : primary key
			System.out.println("Saved student generated id : " + student.getId());

			// now get a new session and start new session
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on id : primary key
			System.out.println("\nGetting student with id : " + student.getId());

			Student myStudent = session.get(Student.class, student.getId());

			System.out.println("Get complete detail : " + myStudent);

			// commit the transaction

			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
