# Spring Boot Profile Microservice

Spring Boot REST API microservice for managing user profiles with full CRUD operations.

## Quick Start

```bash
cd /workspaces/manage-profile-ms
mvn clean install
mvn spring-boot:run
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/profiles` | Get all profiles |
| GET | `/api/profiles/{id}` | Get profile by ID |
| GET | `/api/profiles/active/list` | Get active profiles |
| GET | `/api/profiles/search?name=keyword` | Search profiles |
| POST | `/api/profiles` | Create profile |
| PUT | `/api/profiles/{id}` | Update profile |
| DELETE | `/api/profiles/{id}` | Delete profile |

Service runs on `http://localhost:8082`
H2 Console: `http://localhost:8082/h2-console`
