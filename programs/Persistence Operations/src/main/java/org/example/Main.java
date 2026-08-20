package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Kunal", "SOT");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);  // Save

        transaction.commit();

        session.close();
        sessionFactory.close();

        // Search

//        Student stu = session.find(Student.class, 1);
//        System.out.println(stu);

//        Student stu = session.find(Student.class, 1);
//        System.out.println(stu);

//        Student stu1 = session.get(Student.class, 1);
//        System.out.println(stu1);

//        Transaction transaction = session.beginTransaction();
//
//        Student stu2 = new Student(2, "Karan", "SOH");
//        session.merge(stu2);  //update
//
//        transaction.commit();

//        Transaction transaction = session.beginTransaction();
//
//        Student stu2 = session.find(Student.class, 2);
//        session.remove(stu2);  // remove
//
//        transaction.commit();
//
//        session.clear();
//        sessionFactory.close();


        // 1. persist()

//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();


//        System.out.println("\n1. Before persist()");
//        System.out.println("s1 ID = " + s1.getId());
//
//        session.persist(s1);
//
//        System.out.println("After persist()");
//        System.out.println("s1 ID = " + s1.getId());

        /*
         * persist() makes s1 a MANAGED object.
         *
         * The INSERT may not immediately execute.
         * Hibernate normally executes it when flush happens.
         */


        // 2. flush()

//        System.out.println("\n2. Calling flush()");
//
//        Student student =  session.find(Student.class, 1);
//
//        System.out.println(student);
//
//        student.setName("Kunal");
//        student.setBranch("SOH");
//
//        session.flush();

        /*
         * flush() synchronizes the Persistence Context
         * with the database.
         *
         * The INSERT SQL is sent to the database here.
         */

//        transaction.commit();

        /*
         * commit() commits the database transaction.
         */

//        session.close();


        // 3. find()

//        session = sessionFactory.openSession();
//
//        System.out.println("\n3. find()");
//
//        Student student1 = session.find(Student.class, s1.getId());
//
//        System.out.println("Student found using find(): " + student1.getName());
//
//
//        // 4. get()
//
//        System.out.println("\n4. get()");
//
//        Student student2 = session.get(Student.class, s1.getId());
//
//        System.out.println("Student found using get(): " + student2.getName());
//
//
        // 5. evict()

//        System.out.println("\n5. evict()");
//
//        session.evict(student2);

        /*
         * evict() removes ONE particular object
         * from the Persistence Context.
         *
         * student2 is now DETACHED.
         */

//        System.out.println("student2 evicted from Persistence Context");
//
//
//        // 6. clear()
//
//        System.out.println("\n6. clear()");
//
//        Student student3 = session.find(Student.class, s1.getId());
//
//        Student student4 = session.find(Student.class, s1.getId());
//
//        session.clear();
//
//        /*
//         * clear() removes ALL managed objects
//         * from the Persistence Context.
//         */
//
//        System.out.println("All entities removed from Persistence Context");
//
//
        // 7. merge()

//        System.out.println("\n7. merge()");
//
//        /*
//         * student1 is detached because of session.clear().
//         */
//
//        Student student = new Student("Swap", "SOT");
//
//        Student managedStudent = session.merge(student);
//
//        /*
//         * IMPORTANT:
//         *
//         * merge() does NOT make student1 managed.
//         *
//         * It copies the state of student1 into a managed
//         * object and returns that managed object.
//         */
//
//        System.out.println("Merged student name = " + managedStudent.getName());
//
//
        // 8. refresh()

//        System.out.println("\n8. refresh()");

        /*
         * refresh() reloads the entity's state from the database.
         *
         * Any unsaved changes in the managed object can be
         * overwritten by the database values.
         */


//        Student student = session.find(Student.class, 1);
//        System.out.println(student);
//
//        student.setName("Swap");
//        student.setBranch("SOT");
//
//        System.out.println(student);
//
//        session.refresh(student);
//
//        System.out.println(student);

//
//
//        // 9. remove()
//
//        System.out.println("\n9. remove()");
//
//        /*
//         * remove() marks a managed entity for deletion.
//         *
//         * DELETE SQL is normally executed during flush.
//         */
//
//        session.remove(managedStudent);
//
//        System.out.println("Student marked for deletion");
//
//
        // 10. rollback()

//        System.out.println("\n10. rollback()");

//        Transaction transaction2 = session.beginTransaction();

        /*
         * NOTE:
         * remove() above was done outside this transaction in
         * this illustrative sequence, so let's use a fresh
         * transaction for a proper rollback demonstration.
         */

//        Student rollbackStudent = new Student("Rollback Student", "IT");

//        session.persist(rollbackStudent);

//        System.out.println("Rollback student persisted");

//        transaction2.rollback();

//        System.out.println("Transaction rolled back");


        // 11. Commit a transaction

//        System.out.println("\n11. commit()");
//
//        Transaction transaction3 = session.beginTransaction();
//
//        Student finalStudent = new Student("Final Student", "CSE");
//
//        session.persist(finalStudent);
//
//        transaction3.commit();
//
//        System.out.println("Final student successfully committed");
//
//
//        session.close();
//        sessionFactory.close();
//
//        System.out.println("\nProgram finished.");
    }
}