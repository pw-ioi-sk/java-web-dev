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

        // 1. BULK UPDATE

//        String updateHql = "UPDATE Student s SET s.branch = :newBranch WHERE s.branch = :oldBranch";
//
//        int updatedRows = session
//                .createMutationQuery(updateHql)
//                .setParameter("newBranch", "SOT")
//                .setParameter("oldBranch", "CSE")
//                .executeUpdate();
//
//        System.out.println("Updated rows: " + updatedRows);


        // 2. BULK DELETE

//        String deleteHql = "DELETE FROM Student s WHERE s.branch = :branch";
//
//        int deletedRows = session
//                .createMutationQuery(deleteHql)
//                .setParameter("branch", "SOT")
//                .executeUpdate();
//
//        System.out.println("Deleted rows: " + deletedRows);


        // 3. BULK SELECT

//        String selectHql = "FROM Student s WHERE s.branch = :branch";
        String sql = "select * from student where branch = :branch";

        List<Student> students = session
                .createNativeQuery(sql, Student.class)
                .setParameter("branch", "IT")
                .getResultList();

        System.out.println("Students:");

        for (Student student : students) {
            System.out.println(student);
        }


        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}