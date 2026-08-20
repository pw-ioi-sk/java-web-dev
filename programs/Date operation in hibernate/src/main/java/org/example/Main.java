package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // 1. INSERT

//        String insertSQL = "INSERT INTO student (name, branch) VALUES (:name, :branch)";
//
//        int inserted = session
//                .createNativeMutationQuery(insertSQL)
//                .setParameter("name", "Rahul")
//                .setParameter("branch", "CSE")
//                .executeUpdate();
//
//        System.out.println("Inserted rows: " + inserted);


        // 2. SELECT

//        String selectSQL = "SELECT * FROM student WHERE branch = :branch";
//
//        List<Student> students = session
//                .createNativeQuery(selectSQL, Student.class)
//                .setParameter("branch", "CSE")
//                .getResultList();
//
//        System.out.println("\nCSE Students:");
//
//        for (Student student : students) {
//            System.out.println(student);
//        }


        // 3. BULK UPDATE

//        String updateSQL = "UPDATE student SET branch = :newBranch WHERE branch = :oldBranch";
//
//        int updated = session
//                .createNativeMutationQuery(updateSQL)
//                .setParameter("newBranch", "CSE")
//                .setParameter("oldBranch", "IT")
//                .executeUpdate();
//
//        System.out.println("\nUpdated rows: " + updated);


        // 4. BULK DELETE

//        String deleteSQL = "DELETE FROM student WHERE branch = :branch";
//
//        int deleted = session
//                .createNativeMutationQuery(deleteSQL)
//                .setParameter("branch", "ME")
//                .executeUpdate();
//
//        System.out.println("Deleted rows: " + deleted);


        // COMMIT

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}