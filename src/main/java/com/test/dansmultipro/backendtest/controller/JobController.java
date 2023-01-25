package com.test.dansmultipro.backendtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.dansmultipro.backendtest.service.JobService;

@CrossOrigin
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/jobs")
    public ResponseEntity<?> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping(value = "/jobs/{id}")
    public ResponseEntity<?> getJobById(@PathVariable String id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }
}
