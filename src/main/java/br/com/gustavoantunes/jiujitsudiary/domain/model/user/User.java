package br.com.gustavoantunes.jiujitsudiary.domain.model.user;

import br.com.gustavoantunes.jiujitsudiary.domain.model.training.TrainingSession;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthDate;
    private final UserType userType;
    private final Belt currentlyBelt;
    private final List<TrainingSession> trainingSessions;

    public User(UUID id, String name, String email, String password, LocalDate birthDate, UserType userType, Belt belt, List<TrainingSession> trainingSessions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.userType = userType;
        this.currentlyBelt = belt;
        this.trainingSessions = Collections.unmodifiableList(trainingSessions);
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

    public UserType getUserType() {
        return userType;
    }

    public Belt getCurrentlyBelt() {
        return currentlyBelt;
    }

    public List<TrainingSession> getTrainingSessions() {
        return trainingSessions;
    }
}