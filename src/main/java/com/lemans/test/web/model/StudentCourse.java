package com.lemans.test.web.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENTCOURSE")
public class StudentCourse {

    @Id
    @GeneratedValue
    private long studentCourseId;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

    private String score;
    private String grade;
    private LocalDate registedDate;

    public StudentCourse() {
    }

    public StudentCourse(String score, String grade, LocalDate registedDate) {
        this.score = score;
        this.grade = grade;
        this.registedDate = registedDate;
    }

    public long getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(long studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public LocalDate getRegistedDate() {
        return registedDate;
    }

    public void setRegistedDate(LocalDate registedDate) {
        this.registedDate = registedDate;
    }
}
