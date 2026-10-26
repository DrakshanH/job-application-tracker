package com.example.demo.repository;
import java.util.List;

import com.example.demo.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(String status);

    List<JobApplication> findByCompany(String company);
}