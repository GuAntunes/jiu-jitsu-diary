package br.com.gustavoantunes.jiujitsudiary.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthDate;
    private final BeltRank beltRank;
    private final List<TrainingSession> trainingSessions;

    public User(
            UUID id,
            String name,
            String email,
            String password,
            LocalDate birthDate,
            BeltRank beltRank,
            List<TrainingSession> trainingSessions
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.beltRank = beltRank;
        this.trainingSessions = trainingSessions;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public BeltRank getBeltRank() {
        return beltRank;
    }

    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }
}