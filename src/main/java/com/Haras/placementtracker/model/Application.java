package com.Haras.placementtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Application {
    @Id
    @GeneratedValue
    int id;
    String role;
    @Enumerated(EnumType.STRING)
    Status status;
    LocalDate dateApplied = LocalDate.now();
    LocalDate deadline;
    String notes;
    @ManyToOne
    Company company;

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public Application() {}
    public Application (String role, LocalDate dateApplied, LocalDate deadline, String notes) {
        this.role = role;
        this.dateApplied = dateApplied;
        this.deadline = deadline;
        this.notes = notes;
    }


    public LocalDate getDeadline() {
        return deadline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public Status getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

}
