package com.example.demo.controller;

import com.example.demo.entity.JobApplication;
import com.example.demo.dto.JobApplicationRequest;
import com.example.demo.dto.JobApplicationResponse;
import com.example.demo.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public JobApplicationResponse createApplication(
            @Valid @RequestBody JobApplicationRequest request) {

        return service.createApplication(request);
    }

    @GetMapping
    public Page<JobApplication> getAllApplications(Pageable pageable) {
        return service.getAllApplications(pageable);
    }

    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @GetMapping("/filter")
    public List<JobApplication> getApplicationsByStatus(
            @RequestParam String status) {

        return service.getApplicationsByStatus(status);
    }

    @GetMapping("/filter/company")
    public List<JobApplication> getApplicationsByCompany(
            @RequestParam String company) {

        return service.getApplicationsByCompany(company);
    }

    @PutMapping("/{id}")
    public JobApplication updateApplication(
            @PathVariable Long id,
            @RequestBody JobApplication application) {

        return service.updateApplication(id, application);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
        return "Application " + id + " deleted";
    }
}