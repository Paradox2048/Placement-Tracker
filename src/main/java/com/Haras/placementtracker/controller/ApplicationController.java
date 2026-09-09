package com.Haras.placementtracker.controller;

import com.Haras.placementtracker.model.Application;
import com.Haras.placementtracker.model.Status;
import com.Haras.placementtracker.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @PostMapping
    public Application addApplication(@RequestBody Application application) {
        return applicationService.addApplication(
                application.getRole(),
                application.getDateApplied(),
                application.getDeadline(),
                application.getNotes()
        );
    }

    @PatchMapping("/{id}")
    public Application updateApplication(@PathVariable int id, @RequestParam Status status){
        return applicationService.updateApplication(id, status);
    }

    @GetMapping("/by-status")
    public List<Application> getAllApplicationByStatus(@RequestParam Status status) {
        return applicationService.getApplicationByStatus(status);
    }

}