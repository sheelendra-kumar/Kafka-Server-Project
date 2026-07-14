package com.niiran.engineering.event;

public class StudentEvent {
    private Long studentId;
    private String course;
    private double amount;
    private String status;

   public StudentEvent(){}

    public StudentEvent(Long studentId, String course, double amount, String status) {
        this.studentId = studentId;
        this.course = course;
        this.amount = amount;
        this.status = status;
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
        return "StudentEvent{" +
                "studentId=" + studentId +
                ", course='" + course + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
