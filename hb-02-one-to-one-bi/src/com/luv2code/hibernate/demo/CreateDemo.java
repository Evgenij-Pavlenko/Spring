package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        try {
            // create the object
            Instructor tempInstructor =
                    new Instructor("John3", "Doe", "john@gmail.com");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://my3/youtube.com", "my hobby");
            // associate the object

            tempInstructor.setInstructorDetail(tempInstructorDetail);
            // start a transaction
            session.beginTransaction();

            // save the instructor
            // Note: this will ALSO save details object
            // because of CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }
}
