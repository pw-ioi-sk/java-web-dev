package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) throws Exception {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Load the same record using two different sessions
        Session sessionA = sessionFactory.openSession();
        Session sessionB = sessionFactory.openSession();

        Student studentA = sessionA.find(Student.class, 1L);
        Student studentB = sessionB.find(Student.class, 1L);

        System.out.println("User A:");
        System.out.println(studentA);

        System.out.println("\nUser B:");
        System.out.println(studentB);

        // Both users currently have version = 0
        System.out.println("\nUser A version = " + studentA.getVersion());

        System.out.println("User B version = " + studentB.getVersion());

        // --------------------------------
        // USER A
        // --------------------------------

        Transaction transaction = sessionA.beginTransaction();

        studentA.setBranch("IT");

        transaction.commit();

        System.out.println("\nUser A updated successfully.");

        // --------------------------------
        // USER B
        // --------------------------------

        try {

            sessionB.beginTransaction();

            studentB.setBranch("ECE");

            sessionB.getTransaction().commit();

            System.out.println("User B updated successfully.");

        } catch (Exception e) {

            System.out.println("\nUser B update failed!");

            System.out.println("Reason: " + e.getClass().getName());

            if (sessionB.getTransaction().isActive()) {
                sessionB.getTransaction().rollback();
            }
        }

        sessionA.close();
        sessionB.close();

        sessionFactory.close();
    }
}