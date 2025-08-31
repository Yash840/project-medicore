# Medicore - Medical Management System

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-42.7.7-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Database Schema](#database-schema)
- [Usage Examples](#usage-examples)
- [Development](#development)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## 🏥 Overview

Medicore is a comprehensive medical management system built with Spring Boot that provides complete healthcare facility management capabilities. The system handles patient registration, staff management, appointment scheduling, medical reporting, and billing operations through a well-designed REST API architecture.

### Key Capabilities

- **Patient Management**: Complete patient lifecycle management with auto-generated patient numbers
- **Staff Administration**: Role-based staff management with different access levels
- **Appointment Scheduling**: Comprehensive appointment system with status tracking
- **Medical Reporting**: Detailed medical reports with symptoms and medication tracking
- **Billing System**: Automated billing with tax calculations and service management
- **Document Management**: Structured document handling for medical records

## ✨ Features

### 🏥 Patient Management
- Auto-generated unique patient numbers (format: P{YEAR}{RANDOM})
- Full CRUD operations with partial update support
- Patient status tracking (ACTIVE/INACTIVE)
- Comprehensive patient information management

### 👨‍⚕️ Staff Management
- Role-based access control (DOCTOR, ADMIN, RECEPTION, MANAGEMENT)
- Medical license tracking for healthcare professionals
- Username-based authentication system
- Staff status and information management

### 📅 Appointment System
- Flexible appointment scheduling
- Multiple appointment types (CONSULTATION, EMERGENCY, VISIT)
- Status tracking (PENDING, ONGOING, DONE, CANCELLED)
- Integration with patient and doctor information

### 📊 Medical Reports
- Comprehensive medical documentation
- Symptom and medication tracking
- Document inheritance structure
- Medical history management

### 💰 Billing & Receipts
- Automated bill calculations
- Tax and discount management
- Service-based billing system
- Real-time amount calculations

### 🔧 Technical Features
- RESTful API design
- Reflection-based partial updates
- Consistent error handling
- UUID-based entity identification
- Enum-based status management

## 🛠 Technology Stack

### Backend
- **Java 21** - Programming language
- **Spring Boot 3.5.4** - Application framework
- **Spring Data JPA** - Data persistence
- **PostgreSQL 42.7.7** - Primary database
- **Hibernate** - ORM framework

### Development Tools
- **Maven** - Build automation
- **Lombok 1.18.30** - Code generation
- **MapStruct 1.6.3** - Entity mapping
- **JTE 3.1.16** - Template engine
- **Spring Boot DevTools** - Development utilities

### Architecture Patterns
- **MVC Pattern** - Model-View-Controller
- **DTO Pattern** - Data Transfer Objects
- **Repository Pattern** - Data access abstraction
- **Service Layer Pattern** - Business logic separation

## 📁 Project Structure

```
medicore/
├── src/
│   ├── main/
│   │   ├── java/org/cross/medicore/
│   │   │   ├── MedicoreApplication.java          # Main application class
│   │   │   ├── controller/                       # REST controllers
│   │   │   │   ├── ApiResponse.java             # Standard API response wrapper
│   │   │   │   ├── PatientController.java       # Patient management endpoints
│   │   │   │   ├── StaffController.java         # Staff management endpoints
│   │   │   │   ├── AppointmentController.java   # Appointment endpoints
│   │   │   │   ├── ReportController.java        # Medical report endpoints
│   │   │   │   └── ReceiptController.java       # Billing endpoints
│   │   │   ├── dto/                             # Data Transfer Objects
│   │   │   │   ├── AppointmentRequestDto.java
│   │   │   │   ├── AppointmentResponseDto.java
│   │   │   │   ├── ReportRequestDto.java
│   │   │   │   ├── ReportResponseDto.java
│   │   │   │   ├── ReceiptRequestDto.java
│   │   │   │   └── ReceiptResponseDto.java
│   │   │   ├── mapper/                          # Entity-DTO mappers
│   │   │   │   ├── AppointmentMapper.java
│   │   │   │   ├── ReportMapper.java
│   │   │   │   └── ReceiptMapper.java
│   │   │   ├── model/                           # JPA entities
│   │   │   │   ├── Patient.java                 # Patient entity
│   │   │   │   ├── Staff.java                   # Staff entity
│   │   │   │   ├── Appointment.java             # Appointment entity
│   │   │   │   ├── Report.java                  # Medical report entity
│   │   │   │   ├── Receipt.java                 # Billing receipt entity
│   │   │   │   ├── Service.java                 # Medical service entity
│   │   │   │   ├── Document.java                # Base document entity
│   │   │   │   ├── Medication.java              # Medication entity
│   │   │   │   ├── Symptom.java                 # Symptom entity
│   │   │   │   └── [Enums]                      # Status and type enums
│   │   │   ├── repository/                      # JPA repositories
│   │   │   │   ├── PatientRepository.java
│   │   │   │   ├── StaffRepository.java
│   │   │   │   ├── AppointmentRepository.java
│   │   │   │   ├── ReportRepository.java
│   │   │   │   └── ReceiptRepository.java
│   │   │   └── service/                         # Business logic services
│   │   │       ├── PatientService.java
│   │   │       ├── StaffService.java
│   │   │       ├── AppointmentService.java
│   │   │       ├── ReportService.java
│   │   │       └── ReceiptService.java
│   │   └── resources/
│   │       ├── application.properties           # Application configuration
│   │       ├── static/                          # Static resources
│   │       └── templates/                       # JTE templates
│   └── test/                                    # Test classes
├── target/                                      # Compiled classes
├── pom.xml                                      # Maven configuration
├── mvnw                                         # Maven wrapper (Unix)
├── mvnw.cmd                                     # Maven wrapper (Windows)
└── README.md                                    # This file
```

## 📋 Prerequisites

- **Java 21** or higher
- **PostgreSQL 12** or higher
- **Maven 3.6** or higher
- **Git** (for version control)

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Yash840/project-medicore.git
cd project-medicore
```

### 2. Database Setup

1. Install PostgreSQL and create a database:
```sql
CREATE DATABASE cross_db;
```

2. Update database credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cross_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build and Run

Using Maven Wrapper:
```bash
# Windows
./mvnw clean install
./mvnw spring-boot:run

# Unix/Linux/Mac
./mvnw clean install
./mvnw spring-boot:run
```

Using Maven:
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8081`

## ⚙️ Configuration

### Application Properties

Key configuration options in `application.properties`:

```properties
# Server Configuration
server.port=8081

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/cross_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# JTE Template Engine
gg.jte.development-mode=true
```

### Environment Variables

You can override configuration using environment variables:

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/cross_db
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=your_password
export SERVER_PORT=8081
```

## 📚 API Documentation

### Base URL
```
http://localhost:8081/api
```

### Patient Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/patients` | Get all patients |
| GET | `/patients/{id}` | Get patient by ID |
| POST | `/patients` | Create new patient |
| PATCH | `/patients/{id}` | Update patient (partial) |
| DELETE | `/patients/{id}` | Delete patient |

### Staff Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/staff` | Get all staff members |
| GET | `/staff/{id}` | Get staff by ID |
| POST | `/staff` | Create new staff member |
| PATCH | `/staff/{id}` | Update staff (partial) |
| DELETE | `/staff/{id}` | Delete staff |

### Appointment Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/appointment` | Get all appointments |
| GET | `/appointment/{id}` | Get appointment by ID |
| POST | `/appointment` | Create new appointment |
| PATCH | `/appointment/{id}` | Update appointment |
| DELETE | `/appointment/{id}` | Delete appointment |

### Medical Reports

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/reports` | Get all reports |
| GET | `/reports/{id}` | Get report by ID |
| POST | `/reports` | Create new report |
| PATCH | `/reports/{id}` | Update report |
| DELETE | `/reports/{id}` | Delete report |

### Billing & Receipts

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/receipts` | Get all receipts |
| GET | `/receipts/{id}` | Get receipt by ID |
| POST | `/receipts` | Create new receipt |
| PATCH | `/receipts/{id}` | Update receipt |
| DELETE | `/receipts/{id}` | Delete receipt |

### Request/Response Examples

#### Create Patient
```bash
POST /api/patients
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "dateOfBirth": "1990-01-15",
  "gender": "MALE",
  "phone": "+1234567890",
  "email": "john.doe@email.com",
  "address": "123 Main St, City, State"
}
```

#### Create Appointment
```bash
POST /api/appointment
Content-Type: application/json

{
  "patientId": "patient-uuid",
  "doctorId": "doctor-uuid",
  "appointmentDate": "2025-09-01T10:00:00",
  "appointmentType": "CONSULTATION",
  "purpose": "Regular checkup"
}
```

## 🗄️ Database Schema

### Core Entities

#### Patient
- `id` (UUID) - Primary key
- `patientNumber` (String) - Auto-generated unique identifier
- `firstName`, `lastName` (String) - Patient name
- `dateOfBirth` (LocalDate) - Birth date
- `gender` (Enum) - MALE, FEMALE, OTHER
- `phone`, `email` (String) - Contact information
- `address` (String) - Residential address
- `status` (Enum) - ACTIVE, INACTIVE

#### Staff
- `id` (UUID) - Primary key
- `username` (String) - Unique username
- `firstName`, `lastName` (String) - Staff name
- `role` (Enum) - DOCTOR, ADMIN, RECEPTION, MANAGEMENT
- `licenseNumber` (String) - Medical license (for doctors)
- `phone`, `email` (String) - Contact information

#### Appointment
- `id` (UUID) - Primary key
- `patientId` (UUID) - Foreign key to Patient
- `doctorId` (UUID) - Foreign key to Staff
- `appointmentDate` (LocalDateTime) - Scheduled date/time
- `appointmentType` (Enum) - CONSULTATION, EMERGENCY, VISIT
- `status` (Enum) - PENDING, ONGOING, DONE, CANCELLED
- `purpose` (String) - Appointment purpose

## 💡 Usage Examples

### Patient Registration Flow

1. **Register a new patient**:
```bash
curl -X POST http://localhost:8081/api/patients \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Smith",
    "dateOfBirth": "1985-03-20",
    "gender": "FEMALE",
    "phone": "+1987654321",
    "email": "jane.smith@email.com",
    "address": "456 Oak Ave, City, State"
  }'
```

2. **Schedule an appointment**:
```bash
curl -X POST http://localhost:8081/api/appointment \
  -H "Content-Type: application/json" \
  -d '{
    "patientId": "{patient-id}",
    "doctorId": "{doctor-id}",
    "appointmentDate": "2025-09-01T14:30:00",
    "appointmentType": "CONSULTATION",
    "purpose": "Annual physical examination"
  }'
```

3. **Create a medical report**:
```bash
curl -X POST http://localhost:8081/api/reports \
  -H "Content-Type: application/json" \
  -d '{
    "appointmentId": "{appointment-id}",
    "diagnosis": "Hypertension",
    "symptoms": ["High blood pressure", "Headache"],
    "medications": [
      {
        "name": "Lisinopril",
        "dosage": "10mg",
        "frequency": "Once daily"
      }
    ]
  }'
```

## 🔧 Development

### Setting up Development Environment

1. **IDE Setup**: Use IntelliJ IDEA or Eclipse with Spring Boot support
2. **Lombok**: Install Lombok plugin for your IDE
3. **Database**: Use PostgreSQL or H2 for development

### Code Style Guidelines

- Follow Java naming conventions
- Use meaningful variable and method names
- Add Javadoc comments for public methods
- Use appropriate logging levels
- Follow Spring Boot best practices

### Adding New Features

1. Create the entity in the `model` package
2. Create the repository interface
3. Implement the service class
4. Create DTOs and mappers if needed
5. Implement the REST controller
6. Add appropriate tests

## 🧪 Testing

### Running Tests

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=PatientServiceTest

# Run tests with coverage
./mvnw test jacoco:report
```

### Test Structure

- Unit tests for services and utilities
- Integration tests for repositories
- API tests for controllers
- Test data builders for consistent test setup

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Contribution Guidelines

- Write tests for new features
- Follow existing code style
- Update documentation as needed
- Ensure all tests pass before submitting

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

If you encounter any issues or have questions:

1. Check the [Issues](https://github.com/Yash840/project-medicore/issues) page
2. Create a new issue if your problem isn't already reported
3. Provide detailed information about the issue

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- PostgreSQL community for the robust database
- All contributors who help improve this project

---

**Medicore** - Simplifying Healthcare Management 🏥
