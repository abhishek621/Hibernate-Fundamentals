package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create SessionFactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> studentList = session.createQuery("from Student").getResultList();

			// display students
			displayStudents(studentList);

			// query student's last name='Doe'
			studentList = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			// display students
			System.out.println("\nStudent whose last name is Doe");
			displayStudents(studentList);
			
			//query students : where lastName='Doe' or firstName=''Daffy
			studentList = session.createQuery("from Student s where s.lastName='Doe'"
					+ "OR s.firstName='Daffy'").getResultList();
			
			// display students
			System.out.println("\nStudent whose lastName=Doe OR firstName=Daffy");
			displayStudents(studentList);
			
			//query students : where LIKE '%luv2code.com'
			studentList = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			
			// display students
			System.out.println("\nStudent where email ends with luv2code.com");
			displayStudents(studentList);
			
			//query students : where LIKE 'gmail.com'
			studentList = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			// display students
			System.out.println("\nStudent where email ends with gmail.com");
			displayStudents(studentList);
			
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> studentList) {
		System.out.println(studentList);
	}

}
