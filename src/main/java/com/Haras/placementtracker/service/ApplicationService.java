package com.Haras.placementtracker.service;

import com.Haras.placementtracker.exception.ApplicationNotFoundException;
import com.Haras.placementtracker.model.Application;
import com.Haras.placementtracker.model.Status;
import com.Haras.placementtracker.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application addApplication(String role, LocalDate dateApplied, LocalDate deadline, String notes){
        Application newApplication = new Application(role, dateApplied, deadline, notes);
        return applicationRepository.save(newApplication);
    }

    public Application updateApplication(int id, Status newStatus){
        Optional<Application> result = applicationRepository.findById(id);
        Application updateApplication = result.orElseThrow(() -> new ApplicationNotFoundException("No application found with id " + id));
        updateApplication.setStatus(newStatus);
        return applicationRepository.save(updateApplication);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> getApplicationByStatus(Status status){
        return applicationRepository.findByStatus(status);
    }

    public List<Application> findByDeadline(LocalDate cutoff){
        return applicationRepository.findByDeadline(cutoff);
    }

}

