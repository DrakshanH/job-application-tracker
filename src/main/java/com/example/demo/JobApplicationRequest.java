package com.example.demo;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class JobApplicationRequest {

    @NotBlank
    private String company;

    @NotBlank
    private String role;

    @NotNull
    private LocalDate applicationDate;

    @NotBlank
    private String status;

    private String notes;

    // getters and setters
    public String getCompany() {return  company;}
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