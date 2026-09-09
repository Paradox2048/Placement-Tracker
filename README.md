PLACEMENT TRACKER
A Spring Boot REST API to track internship or placement applications — designed to replace the tedious task of managing applications on a spreadsheet or site such as Trackr.

It's a continuation of the [core Java Personal Finance Tracker](https://github.com/Paradox2048/Private-Finance-Tracker) project, from basic Java (inheritance, collections, IO from files, etc) to a Spring Boot + JPA stack: entities, repositories, services, REST controllers, scheduled tasks, and custom exception handling.

Features
•	Add New Applications (company, role, status, date applied, deadline, notes)
•	Change the status of an application (Applied, Interview, Offer/Rejected)
•	List all applications
•	Change the filter to "Submitted" or "Approved"
•	Applications with deadlines will be presented by deadline.
•	A background scheduled task that verifies programs that are due for a deadline.
•	Exception handling for invalid lookups (use update on non-existent application)

Tech Stack
•	Java 21
•	Spring Web (Spring Data JPA)
•	H2 — in-memory database (development / testing)
•	Maven

Architecture
The project is structured in the typical manner of a Spring Boot project:
com.haras.placementtracker
├── model/         Entities: Company, Application, Status (enum)
├── repository/     JpaRepository interfaces for persistence
├── service/        Business logic (add, update, filter)
├── controller/      REST endpoints
├── scheduler/       @Scheduled deadline-checking task
└── exception/       Custom exceptions

•	The relationship between Company and Application is a ManyToOne relationship (many applications belong to one company).
•	The @Enumerated annotation is used to store `Status` (as a string) instead of being stored by default as an ordinal, so that existing data will not be silently corrupted if the order of the Enum’s elements changes or new elements are added later.
•	The Service layer is the only layer that directly interacts with the repository — all business logic is contained in this layer and controllers should not interact with persistence themselves.
•	This is deadlines soon checker, it's running on a schedule, and it's logging the apps which have upcoming deadlines, and that's a first step towards a ‘reminder’ like behaviour.
•	ApplicationNotFoundException is thrown when an update targets an id that doesn't exist, giving a clear, specific error instead of a generic unhandled exception.

Running Locally
1. Clone the repository
2. Open in IntelliJ (or your IDE of choice) as a Maven project
3. Run `PlacementTrackerApplication`
4. The API can be accessed through the URL http://localhost:8080.

The app runs with an in-memory H2 database (data will be lost when the app is restarted).

Status
Finished Core functionality (data model, persistence, business logic, REST API, scheduled task, basic exception handling). Possible future improvements:

•	Range-based deadline filtering (currently only supports exact-date match)
•	Return appropriate HTTP status codes rather than generic error messages (e.g. 404)
•	Validation of incoming data will be done in an additional way.
