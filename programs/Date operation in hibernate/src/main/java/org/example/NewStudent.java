package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "student")
public class NewStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Date only
    private LocalDate birthDate;

    // Time only
    private LocalTime loginTime;

    // Date + Time
    private LocalDateTime admissionDateTime;

    // Automatically maintained by Hibernate
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Required by Hibernate
    public NewStudent() {
    }

    public NewStudent(String name, LocalDate birthDate, LocalTime loginTime, LocalDateTime admissionDateTime) {
        this.name = name;
        this.birthDate = birthDate;
        this.loginTime = loginTime;
        this.admissionDateTime = admissionDateTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalTime getLoginTime() {
        return loginTime;
    }

    public LocalDateTime getAdmissionDateTime() {
        return admissionDateTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setLoginTime(LocalTime loginTime) {
        this.loginTime = loginTime;
    }

    public void setAdmissionDateTime(LocalDateTime admissionDateTime) {
        this.admissionDateTime = admissionDateTime;
    }

    @Override
    public String toString() {

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", loginTime=" + loginTime +
                ", admissionDateTime=" + admissionDateTime +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}