# 📌 Jiu-Jitsu Training & Diet Tracker

## 📖 About the Project
This application is designed to help users track and organize their jiu-jitsu training and diet.  
The system allows each user to monitor physical progress, set goals, and gain insights to improve performance.

## 🚀 Features

### ✅ Core Features
- [ ] User registration and authentication.
- [ ] Custom training log with techniques, drills, and sparring sessions.
- [ ] Historical training records for progress tracking.
- [ ] Meal logging with automatic calorie and macronutrient calculation.
- [ ] Graphs and statistics to visualize progress.
- [ ] Notifications and reminders to maintain routine.

### 🔜 Future Features
- [ ] **Belt & Rank Tracking** – Users can log their current belt and promotion history.
- [ ] **Technique Journal** – A dedicated space to save techniques, videos, and notes.
- [ ] **Competition Tracking** – Log tournament participation and results.
- [ ] **AI-Based Personalized Training Plans** – Smart recommendations for training routines.
- [ ] **Community Features** – Users can share training insights, techniques, and diet plans.
- [ ] **Wearable Device Integration** – Smartwatch and fitness tracker support.
- [ ] **Offline Mode** – Syncs data when back online.

## 🛠️ Tech Stack

### **Backend**
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** PostgreSQL
- **Authentication:** JWT (JSON Web Token)

### **Frontend** *(Planned)*
- React.js or React Native

### **DevOps** *(Planned)*
- Docker & Kubernetes
- AWS Deployment

## 📦 How to Run the Project

### **Prerequisites**
- Java 17+
- Maven
- PostgreSQL

# Hexagonal Architecture

**Hexagonal Architecture** aims to isolate the **domain** of the application from external dependencies (such as infrastructure, frameworks, and databases), allowing the system to be more flexible, testable, and maintainable with business logic independent of technologies.

## Layer Structure

### 1. **Domain (`domain`)**
- **Defines the ports (interfaces)** that external layers (such as application and infrastructure) should implement.
- Contains **business rules** and domain models. It does not depend on any external technology.
- **Types of Ports:**
    - **Inbound Ports (Driving Ports):** Interfaces representing use cases.
    - **Outbound Ports (Driven Ports):** Interfaces for interaction with external systems, such as repositories or external services.

### 2. **Application Layer (`application`)**
- **Interacts with the domain** via the **inbound ports** defined in the domain.
- **Orchestrates the use cases** but does not contain business logic.
- **Calls outbound ports** to interact with infrastructure, such as saving data or making calls to external services.

### 3. **Infrastructure Layer (`infrastructure`)**
- **Implements outbound ports** defined by the domain.
- Contains the implementation of **adapters**, such as database repositories, external services, and other dependencies.
- **Does not directly interact with the application layer**, ensuring business logic is independent of external technologies.

## Interaction Flow:
1. The **Application Layer** calls an **inbound port** (use case).
2. The **Domain** executes business logic and interacts with **outbound ports**.
3. The **Infrastructure** layer implements the outbound ports and interacts with external systems (e.g., databases, APIs).

## Benefits:
- **Decoupling**: The domain does not depend on external databases, frameworks, or libraries.
- **Testability**: Business logic can be easily tested in isolation without dependencies on infrastructure.
- **Flexibility**: External technologies (such as databases or frameworks) can be swapped without impacting the core business logic.

### **Run Locally** *TODO*
```bash
# Clone the repository
git clone https://github.com/your-username/project-name.git
cd project-name

# Configure the database in application.properties

# Build and run the project
mvn spring-boot:run
