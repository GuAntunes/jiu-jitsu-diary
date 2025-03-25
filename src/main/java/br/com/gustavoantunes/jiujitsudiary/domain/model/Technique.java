package br.com.gustavoantunes.jiujitsudiary.domain.model;

import java.util.UUID;

public class Technique {
    private final UUID id;
    private final String name;
    private final String description;
    private final String position;

    public Technique(UUID id, String name, String description, String position) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.position = position;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPosition() {
        return position;
    }
}