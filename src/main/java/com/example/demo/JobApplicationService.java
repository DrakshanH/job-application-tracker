package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

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

        JobApplication savedApplication = repository.save(application);

        JobApplicationResponse response = new JobApplicationResponse();

        response.setId(savedApplication.getId());
        response.setCompany(savedApplication.getCompany());
        response.setRole(savedApplication.getRole());
        response.setApplicationDate(savedApplication.getApplicationDate());
        response.setStatus(savedApplication.getStatus());
        response.setNotes(savedApplication.getNotes());

        return response;
    }

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
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