# Ubiquitous Language - Jiu-Jitsu Diary

This document defines the core terms and concepts used in the Jiu-Jitsu Diary system. The goal is to ensure that all stakeholders share a common understanding of the domain language.

## Core Concepts

### **Belt**
Represents a practitioner's rank in Brazilian Jiu-Jitsu (BJJ). It consists of:
- `BeltRank`: The primary rank (White, Blue, Purple, Brown, Black, Red).
- `Grade`: A subdivision of the rank, represented by degrees (1-8).

### **Technique**
A specific move or sequence of moves in BJJ. It includes:
- `Name`: The technique's common name.
- `Description`: A textual explanation of how to execute the technique.
- `MoveCategory`: The classification of the technique (e.g., Submissions, Guard Passing).

### **Training Session**
A recorded practice session that consists of:
- `DateTime`: The timestamp of when the session occurred.
- `TrainingType`: The type of session (Drilling, Technique, Sparring).
- `Techniques`: A list of techniques practiced during the session.

### **User**
A registered practitioner in the system. Each user has:
- `Name`, `Email`, `BirthDate`: Basic identity information.
- `UserType`: Defines the role (Admin, Athlete, Teacher).
- `Belt`: The current rank of the user.
- `TrainingSessions`: A history of training sessions the user has logged.

## System Roles

### **Admin**
A system administrator who can manage users and their training logs.

### **Athlete**
A practitioner of BJJ who uses the system to track their progress and training sessions.

### **Teacher**
An instructor who may oversee multiple athletes and help guide their progress.

### Move Categories
The categorization of Jiu-Jitsu movements within the ubiquitous language can be defined as:

- **Positions**: Represent the base and control of the fighter (e.g., Guard, Mount, Back Control).
- **Guard Passing**: Techniques to overcome the opponent's guard (e.g., Stack Pass, Knee Cut).
- **Takedowns and Throws**: Techniques to bring the opponent to the ground (e.g., Double Leg, O-goshi).
- **Submissions**: Techniques to force the opponent to surrender (e.g., Armbar, Rear Naked Choke).
- **Sweeps**: Techniques to reverse position and escape disadvantages (e.g., Hook Sweep, Helicopter Sweep).
- **Escapes and Defenses**: Movements to get out of bad positions (e.g., Upa, Guard Recovery).