package com.niiran.engineering.event;

public class FeeEvent {

    private Long studentId;
    private String course;
    private double amount;
    private String status;

    public FeeEvent() {}

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
        return "FeeEvent{" +
                "studentId=" + studentId +
                ", course='" + course + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
