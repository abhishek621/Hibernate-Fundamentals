package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			// delete the student object
			//System.out.println("Deleting Student : " + student);
			//session.delete(student);
			
			//delete student=2 with second approach
			System.out.println("Deleting student where id=2");
		   session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
		
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
