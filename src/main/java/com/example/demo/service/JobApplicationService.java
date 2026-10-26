package com.example.demo.service;

import com.example.demo.dto.JobApplicationRequest;
import com.example.demo.dto.JobApplicationResponse;
import com.example.demo.entity.JobApplication;
import com.example.demo.exception.ApplicationNotFoundException;
import com.example.demo.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(JobApplicationService.class);

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplicationResponse createApplication(JobApplicationRequest request) {

        JobApplication application = new JobApplication();

        application.setCompany(request.getCompany());
        application.setRole(request.getRole());
        application.setApplicationDate(request.getApplicationDate());
        application.setStatus(request.getStatus());
        application.setNotes(request.getNotes());

        logger.info("Creating job application for company: {}",
                request.getCompany());

        JobApplication savedApplication = repository.save(application);

        logger.info("Created job application with ID: {}",
                savedApplication.getId());

        JobApplicationResponse response = new JobApplicationResponse();

        response.setId(savedApplication.getId());
        response.setCompany(savedApplication.getCompany());
        response.setRole(savedApplication.getRole());
        response.setApplicationDate(savedApplication.getApplicationDate());
        response.setStatus(savedApplication.getStatus());
        response.setNotes(savedApplication.getNotes());

        return response;
    }

    public Page<JobApplication> getAllApplications(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public JobApplication getApplicationById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ApplicationNotFoundException("Application not found"));
    }

    public List<JobApplication> getApplicationsByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<JobApplication> getApplicationsByCompany(String company) {
        return repository.findByCompany(company);
    }

    public JobApplication updateApplication(Long id, JobApplication application) {

        JobApplication existingApplication =
                repository.findById(id).orElse(null);

        if (existingApplication == null) {
            return null;
        }

        existingApplication.setCompany(application.getCompany());
        existingApplication.setRole(application.getRole());
        existingApplication.setApplicationDate(application.getApplicationDate());
        existingApplication.setStatus(application.getStatus());
        existingApplication.setNotes(application.getNotes());

        return repository.save(existingApplication);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }
}