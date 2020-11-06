package com.luv2code.employee.demo;

import com.luv2code.employee.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/*
Create an app using Hibernate to read/write data to database table. Here is the database table design:

Table: Employee

Columns
- first_name : varchar
- last_name: varchar
- company : varchar


Steps You Must Complete

Create the database table.
Set up the Hibernate configuration file.
Create a Java class (entity) with Hibernate annotations.
Develop a main application.
Develop code to save objects.
Develop code to retrieve an object by primary key.
Develop code to query objects to find employees for a given company.
Develop code to delete an object by primary key.

 */

public class EmployeeMain {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        Employee employee1 = new Employee("John1", "Jonson1", "J&J");
        Employee employee2 = new Employee("John2", "Jonson2", "J&J");
        Employee employee3 = new Employee("John3", "Jonson3", "J&J");
        Employee employee4 = new Employee("John4", "Jonson4", "J&J");
        try {
            session.beginTransaction();

            // Develop code to save objects.
//        session.save(employee1);
//        session.save(employee2);
//        session.save(employee3);
//        session.save(employee4);
//        session.getTransaction().commit();

            // Develop code to retrieve an object by primary key.

            Employee myEmployee = new Employee();
            int idEmployee = 2;
            myEmployee = session.get(Employee.class, idEmployee);
            System.out.println("Employee from DB: ");
            System.out.println(myEmployee);

            // Update employee's company with id 3

            session.createQuery("update Employee set company='M&M' where id=3").executeUpdate();


            // Develop code to query objects to find employees for a given company.

            List<Employee> employees = session.createQuery("from Employee where company='M&M'").getResultList();
            System.out.println("Employee from M&M:");
            System.out.println(employees);

            // Develop code to delete an object by primary key.

            session.createQuery("delete Employee where id=5").executeUpdate();
            session.getTransaction().commit();
        } finally {

            factory.close();
        }


    }
}
