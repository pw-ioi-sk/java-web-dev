package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        try (sessionFactory; session) {
            ClassRoom classRoom = new ClassRoom(1, "Batch 2", "SOT");

            session.persist(classRoom);

            transaction.commit();

            System.out.println("Product saved successfully!");
            System.out.println(classRoom);

        } catch (Exception e) {
            transaction.rollback();

            e.printStackTrace();

        }
    }
}