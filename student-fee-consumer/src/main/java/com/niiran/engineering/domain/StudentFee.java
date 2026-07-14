package com.niiran.engineering.domain;

import jakarta.persistence.*;

@Entity
@Table(name="fee_details")
public class StudentFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private String course;
    private double amount;
    private String status;

    public StudentFee(Long id, Long studentId, String course, double amount, String status) {
        this.id = id;
        this.studentId = studentId;
        this.course = course;
        this.amount = amount;
        this.status = status;
    }

    public StudentFee(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentFee{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", course='" + course + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
