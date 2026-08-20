package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QBCExample {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        // 1. QBC SELECT

        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> student = cq.from(Student.class);

        cq.select(student).where(cb.equal(student.get("branch"), "CSE"));

        List<Student> students = session.createQuery(cq).getResultList();

        System.out.println("CSE Students:");

        for (Student s : students) {
            System.out.println(s);
        }


        // 2. QBC SELECT WITH MULTIPLE CONDITIONS

        CriteriaQuery<Student> cq2 = cb.createQuery(Student.class);

        Root<Student> student2 = cq2.from(Student.class);

        Predicate branchCondition = cb.equal(student2.get("branch"), "CSE");

        Predicate nameCondition = cb.like(student2.get("name"), "A%");

        cq2.select(student2).where(cb.and(branchCondition, nameCondition));

        List<Student> result = session.createQuery(cq2).getResultList();

        System.out.println("\nCSE Students whose name starts with A:");

        for (Student s : result) {
            System.out.println(s);
        }


        // 3. QBC BULK UPDATE

        Transaction transaction = session.beginTransaction();

        var updateCriteria = cb.createCriteriaUpdate(Student.class);

        Root<Student> updateStudent = updateCriteria.from(Student.class);

        updateCriteria
                .set(
                        updateStudent.get("branch"),
                        "CSE"
                )
                .where(
                        cb.equal(
                                updateStudent.get("branch"),
                                "IT"
                        )
                );

        int updated =
                session.createMutationQuery(updateCriteria)
                        .executeUpdate();

        System.out.println("\nUpdated rows: " + updated);


        // 4. QBC BULK DELETE

        var deleteCriteria =
                cb.createCriteriaDelete(Student.class);

        Root<Student> deleteStudent =
                deleteCriteria.from(Student.class);

        deleteCriteria.where(
                cb.equal(
                        deleteStudent.get("branch"),
                        "ME"
                )
        );

        int deleted =
                session.createMutationQuery(deleteCriteria)
                        .executeUpdate();

        System.out.println("Deleted rows: " + deleted);


        // COMMIT

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}