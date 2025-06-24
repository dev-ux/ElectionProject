# Voting System Frontend

Frontend application for managing association voting system.

## Features

- List and manage voters
- Mark voters as voted
- Real-time statistics
- Search functionality
- Responsive design

## Tech Stack

- Angular 17
- TypeScript
- Bootstrap 5
- RxJS
- Docker

## Setup

1. Install dependencies:
```bash
npm install
```

2. Start development server:
```bash
npm start
```

3. Build for production:
```bash
npm run build
```

## Docker

Build Docker image:
```bash
docker build -t voting-system-frontend .
```

Run Docker container:
```bash
docker run -p 80:80 voting-system-frontend
```

## API Configuration

The frontend expects the backend API to be available at `http://localhost:8080/api`.
You can change this configuration in `src/environments/environment.ts`.
