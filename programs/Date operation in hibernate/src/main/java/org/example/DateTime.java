package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;

public class DateTime {

    public static void main(String[] args) {

        // 1. CREATE SESSION FACTORY

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        // 2. JAVA 8 DATE/TIME API

        LocalDate today = LocalDate.now();

        LocalTime currentTime = LocalTime.now();

        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("Today's Date      : " + today);
        System.out.println("Current Time      : " + currentTime);
        System.out.println("Current Date Time : " + currentDateTime);


        // 3. CREATE SPECIFIC DATE/TIME VALUES

        LocalDate birthDate = LocalDate.of(2002, 5, 15);

        LocalTime loginTime = LocalTime.of(10, 30, 45);

        LocalDateTime admissionDateTime = LocalDateTime.of(2026, 8, 20, 10, 30, 45);


//        System.out.println("\nSpecific Values");
//
//        System.out.println("Birth Date       : " + birthDate);
//        System.out.println("Login Time       : " + loginTime);
//        System.out.println("Admission Date   : " + admissionDateTime);


        // 4. SAVE STUDENT

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        NewStudent student = new NewStudent("Rahul", birthDate, loginTime, admissionDateTime);

        session.persist(student);

        transaction.commit();

        System.out.println("\nStudent Saved!");
        System.out.println("Generated ID : " + student.getId());

        session.close();


        // 5. RETRIEVE STUDENT

//        session = sessionFactory.openSession();
//
//        NewStudent foundStudent = session.find(NewStudent.class, student.getId());
//
//        System.out.println("\nRetrieved Student");
//
//        System.out.println("ID               : " + foundStudent.getId());
//
//        System.out.println("Name             : " + foundStudent.getName());
//
//        System.out.println("Birth Date       : " + foundStudent.getBirthDate());
//
//        System.out.println("Login Time       : " + foundStudent.getLoginTime());
//
//        System.out.println("Admission Date   : " + foundStudent.getAdmissionDateTime());
//
//        System.out.println("Created At       : " + foundStudent.getCreatedAt());
//
//        System.out.println("Updated At       : " + foundStudent.getUpdatedAt());
//
//        session.close();


        // 6. UPDATE DATE/TIME

//        LocalDate birthDate = LocalDate.of(2002, 5, 15);
//
//        LocalTime loginTime = LocalTime.of(10, 30, 45);
//
//        LocalDateTime admissionDateTime = LocalDateTime.of(2026, 8, 20, 10, 30, 45);
//
//
//        NewStudent student = new NewStudent(
//                "Rahul",
//                birthDate,
//                loginTime,
//                admissionDateTime
//        );
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//
//        NewStudent studentToUpdate = session.find(NewStudent.class, 3);
//
//        studentToUpdate.setLoginTime(LocalTime.of(11, 45));
//
//        studentToUpdate.setAdmissionDateTime(
//                LocalDateTime.of(2026, 8, 21, 9, 15)
//        );
//
//        transaction.commit();
//
//        System.out.println("\nStudent Date/Time Updated!");
//
//        session.close();


        // 7. DATE CALCULATIONS
//
//        LocalDate date = LocalDate.of(2026, 8, 20);
//
//        LocalDate after10Days = date.plusDays(10);
//
//        LocalDate before2Months = date.minusMonths(2);
//
//        LocalDate nextYear = date.plusYears(1);
//
//        System.out.println("\nDate Calculations");
//
//        System.out.println("Original Date : " + date);
//
//        System.out.println("After 10 Days : " + after10Days);
//
//        System.out.println("Before 2 Months : " + before2Months);
//
//        System.out.println("After 1 Year : " + nextYear);


        // 8. TIME CALCULATIONS

//        LocalTime time = LocalTime.of(10, 30);
//
//        LocalTime after2Hours = time.plusHours(2);
//
//        LocalTime before30Minutes = time.minusMinutes(30);
//
//        System.out.println("\nTime Calculations");
//
//        System.out.println("Original Time : " + time);
//
//        System.out.println("After 2 Hours : " + after2Hours);
//
//        System.out.println("Before 30 Minutes : " + before30Minutes);


        // 9. DATETIME CALCULATIONS

//        LocalDateTime dateTime =
//                LocalDateTime.of(
//                        2026,
//                        8,
//                        20,
//                        10,
//                        30
//                );
//
//        LocalDateTime after5Hours = dateTime.plusHours(5);
//
//        LocalDateTime after3Days = dateTime.plusDays(3);
//
//        System.out.println("\nDateTime Calculations");
//
//        System.out.println("Original : " + dateTime);
//
//        System.out.println("After 5 Hours : " + after5Hours);
//
//        System.out.println("After 3 Days : " + after3Days);


        // 10. DATE COMPARISON
//
//        LocalDate date1 = LocalDate.of(2026, 8, 20);
//
//        LocalDate date2 = LocalDate.of(2026, 8, 25);
//
//        System.out.println("\nDate Comparison");
//
//        System.out.println("date1 is before date2 : " + date1.isBefore(date2));
//
//        System.out.println("date1 is after date2 : " + date1.isAfter(date2));
//
//        System.out.println("date1 equals date2 : " + date1.isEqual(date2));


        // 11. PERIOD
        // Difference between two dates

//        LocalDate startDate = LocalDate.of(2020, 1, 1);
//
//        LocalDate endDate = LocalDate.of(2026, 8, 20);
//
//        Period period = Period.between(startDate, endDate);
//
//        System.out.println("\nPeriod");
//
//        System.out.println("Years  : " + period.getYears());
//
//        System.out.println("Months : " + period.getMonths());
//
//        System.out.println("Days   : " + period.getDays());


        // 12. DURATION
        // Difference between times

//        LocalTime startTime = LocalTime.of(10, 0);
//
//        LocalTime endTime = LocalTime.of(12, 30);
//
//        Duration duration = Duration.between(startTime, endTime);
//
//        System.out.println("\nDuration");
//
//        System.out.println("Hours : " + duration.toHours());
//
//        System.out.println("Minutes : " + duration.toMinutes());


        // 13. HQL DATE QUERY
        // Find students born after a particular date

//        session = sessionFactory.openSession();
//
//        LocalDate cutoffDate = LocalDate.of(2000, 1, 1);
//
//        List<NewStudent> students = session.createQuery("from Student s where s.birthDate > :date",
//                                NewStudent.class
//                        )
//                        .setParameter("date", cutoffDate)
//                        .getResultList();
//
//        System.out.println("\nStudents born after " + cutoffDate);
//
//        for (NewStudent s : students) {
//            System.out.println(s);
//        }
//
//        session.close();


        // 14. HQL DATE RANGE QUERY

//        session = sessionFactory.openSession();
//
//        LocalDate start = LocalDate.of(2000, 1, 1);
//
//        LocalDate end = LocalDate.of(2005, 12, 31);
//
//        List<NewStudent> studentsInRange = session.createQuery("from Student s where s.birthDate between :start and :end",
//                                NewStudent.class
//                        )
//                        .setParameter("start", start)
//                        .setParameter("end", end)
//                        .getResultList();
//
//        System.out.println("\nStudents born between " + start + " and " + end);
//
//        for (NewStudent s : studentsInRange) {
//            System.out.println(s);
//        }
//
//        session.close();


        // 15. HQL DATETIME QUERY

//        session = sessionFactory.openSession();
//
//        LocalDateTime cutoffDateTime =
//                LocalDateTime.of(
//                        2026,
//                        1,
//                        1,
//                        0,
//                        0
//                );
//
//        List<NewStudent> recentStudents = session.createQuery("from Student s where s.admissionDateTime > :dateTime",
//                                NewStudent.class
//                        )
//                        .setParameter(
//                                "dateTime",
//                                cutoffDateTime
//                        )
//                        .getResultList();
//
//        System.out.println(
//                "\nStudents admitted after "
//                        + cutoffDateTime
//        );
//
//        for (NewStudent s : recentStudents) {
//            System.out.println(s);
//        }
//
//        session.close();
//
//
//        // 16. CLOSE SESSION FACTORY
//
//        sessionFactory.close();
//
//        System.out.println("\nProgram Finished!");
    }
}