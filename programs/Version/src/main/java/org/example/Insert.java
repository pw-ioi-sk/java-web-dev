package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Insert {

    public static void main(String[] args) {

        SessionFactory sessionFactory =
                new Configuration()
                        .configure()
                        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Student student = new Student();

        student.setName("Swapnendu");
        student.setBranch("CSE");

        session.persist(student);

        session.getTransaction().commit();

        System.out.println(student);

        session.close();
        sessionFactory.close();
    }
}