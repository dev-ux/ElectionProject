# Voting Management System

A web application for managing voting processes in an association.

## Project Overview

This application is designed to manage the voting process for association elections. It provides a simple interface for managing voter registration and tracking who has voted.

## Technical Stack

- Frontend: Angular
- Backend: Spring Boot
- Database: MySQL
- Containerization: Docker
- CI/CD: GitLab CI

## Project Structure

```
├── frontend/           # Angular application
├── backend/           # Spring Boot application
├── docker/            # Docker configuration files
└── docs/             # Documentation
```

## Setup Instructions

1. Prerequisites:
   - Docker and Docker Compose
   - Node.js (for frontend development)
   - Java JDK (for backend development)

2. Build and Run:
```bash
# Build and run with Docker
docker-compose up --build

# Access the application
http://localhost:4200
```

## Features (V1)

- List all association members
- Track voting status
- Simple and intuitive UI
- Dockerized deployment
- Basic testing

## Future Enhancements (Planned)

- Multiple election management
- Anonymous vote recording
- User authentication
- Advanced reporting
- Mobile responsiveness

## License

MIT License
