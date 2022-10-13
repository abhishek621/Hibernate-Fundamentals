package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// start a transaction
			session.beginTransaction();

			// retrieve the student object
			System.out.println("Getting Student with id : " + studentId);
			Student student = session.get(Student.class, studentId);

			// update the student object
			System.out.println("Updating Student");
			student.setFirstName("Scooby");

			// commit the transaction
			session.getTransaction().commit();
			
			//new code : create Session and start a transaction
			
			session = factory.getCurrentSession();
		      session.beginTransaction();
		      
		    //update email for all students
		      System.out.println("Updating emails of students");
		      session.createQuery("UPDATE Student SET email='foo@gmail.com'")
		      .executeUpdate();
		      
		   // commit the transaction
				session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
