package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteJohnStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the student John from DB
            int studentID = 1;
            Student tempStudent = session.get(Student.class, studentID);

            System.out.println("\nLoaded student: " + tempStudent);
            System.out.println("Course: " + tempStudent.getCourses());

            // delete student
            System.out.println("\nDeleting student: "+ tempStudent);
            session.delete(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {

            // add clean up code
            session.close();
            factory.close();
        }

    }
}
