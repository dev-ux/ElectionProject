# Application de Vote - Gestion des Élections de l'Association

## Présentation
Cette application gère le processus de vote pour l'élection du conseil d'administration de l'association. Elle fournit une interface simple pour l'émargement des membres et le suivi des votes.

## Architecture

### Frontend
- **Framework**: Angular
- **Fonctionnalités**:
  - Liste des membres de l'association
  - Interface de vote simple
  - Mise à jour en temps réel du statut de vote

### Backend
- **Framework**: Spring Boot (Java)
- **Fonctionnalités**:
  - API REST
  - Gestion des membres
  - Suivi des votes

### Base de données
- **Système**: MySQL
- **Entités principales**:
  - Membres (nom, prénom, date de naissance)
  - Historique des votes

## Stack Technique

### Frontend
- Angular
- Bootstrap pour le design
- HttpClient pour les appels API

### Backend
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (pour futures versions)

### Base de données
- MySQL
- Hibernate/JPA pour l'ORM

### Conteneurisation
- Docker
- Docker Compose

### Tests
- JUnit pour le backend
- Jasmine/Karma pour le frontend

## API REST (Version 1)

### Points d'entrée

#### GET /api/membres
- Liste tous les membres de l'association
- Retourne un tableau de membres avec leur statut de vote

#### POST /api/membres/{id}/vote
- Marque un membre comme ayant voté
- Action irréversible
- Validation du statut de membre

## Projections pour les futures versions

### Gestion des scrutins multiples
- Ajout d'une entité Scrutin
- Association membre-scrutin
- Historique des votes par scrutin

### Anonymisation des votes
- Génération d'identifiants uniques anonymes
- Séparation des données personnelles et des votes
- Statistiques anonymes

### Sécurité
- Authentification des membres
- Autorisations basées sur les rôles
- Journalisation sécurisée

## Configuration requise
- Java 17+
- Node.js 18+
- Docker et Docker Compose
- MySQL 8+

## Installation

1. Cloner le repository
2. Configurer les variables d'environnement
3. Lancer les conteneurs avec Docker Compose
4. Accéder à l'application via le navigateur

## Tests

### Backend
```bash
docker-compose exec backend mvn test
```

### Frontend
```bash
docker-compose exec frontend ng test
```

## CI/CD
Utilisation de GitLab CI pour:
- Tests automatisés
- Build Docker
- Déploiement automatique

## Documentation API
Disponible via Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

## Contributing
Pour contribuer au projet, veuillez suivre ces étapes:
1. Fork le repository
2. Créer une branche pour votre fonctionnalité
3. Commit vos changements
4. Push vers votre branche
5. Créer une Pull Request

## Licence
Ce projet est sous licence MIT - voir le fichier LICENSE pour plus de détails.