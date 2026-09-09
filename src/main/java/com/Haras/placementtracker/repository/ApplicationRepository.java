package com.Haras.placementtracker.repository;
import com.Haras.placementtracker.model.Application;
import com.Haras.placementtracker.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ApplicationRepository extends JpaRepository <Application, Integer>{
    List<Application> findByStatus(Status status);
    List<Application> findByDeadline(LocalDate deadline);
}
