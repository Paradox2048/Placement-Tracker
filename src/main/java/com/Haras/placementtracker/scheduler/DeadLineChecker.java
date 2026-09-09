package com.Haras.placementtracker.scheduler;

import com.Haras.placementtracker.model.Application;
import com.Haras.placementtracker.service.ApplicationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DeadLineChecker {

    private final ApplicationService applicationService;

    public DeadLineChecker(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @Scheduled(fixedRate = 10000)
    public void checkDeadlines() {
        LocalDate cutoff = LocalDate.now().plusDays(14);
        List<Application> upcoming = applicationService.findByDeadline(cutoff);
        for (Application app : upcoming) {
            System.out.println(app);
        }
    }
}
