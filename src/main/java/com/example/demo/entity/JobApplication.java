package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;

    private String role;

    private LocalDate applicationDate;

    private String status;

    private String notes;

    // getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getCompany() {return company;}
    public void setCompany(String company) {this.company = company;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public LocalDate getApplicationDate() {return applicationDate;}
    public void setApplicationDate(LocalDate applicationDate) {this.applicationDate = applicationDate;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}


}