package br.com.gustavoantunes.jiujitsudiary.domain.model.technique;

import java.util.UUID;

public class Technique {
    private final UUID id;
    private final String name;
    private final String description;
    private final MoveCategory moveCategory;

    public Technique(UUID id, String name, String description, MoveCategory moveCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.moveCategory = moveCategory;
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

    public MoveCategory getMoveCategory() {
        return moveCategory;
    }
}