package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();


            // query students
            List<Student> theStudents = session.createQuery("from Student")
                    .list();

            //dispay the students
            displayStudents(theStudents);

            // query students: lastName='Doe'
            theStudents =  session.createQuery("from Student s where s.lastName='Doe'")
                    .getResultList();
            //dispay the students
            System.out.println("Students who have last name of Doe");
            displayStudents(theStudents);

            // query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student where lastName='Doe' or firstName='Daffy'")
                    .getResultList();

            //dispay the students
            System.out.println("\n\nStudents who have last name of Doe or first name of Daffy");
            displayStudents(theStudents);

            // query students: email LIKE '%luv2code.com'
            theStudents = session.createQuery("from Student where email like '%luv2code.com'")
                    .getResultList();

            //dispay the students
            System.out.println("\n\nStudents who email ends with 'luv2code.com'");
            displayStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student theStudent : theStudents) {
            System.out.println(theStudent);
        }
    }
}
