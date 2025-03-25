package br.com.gustavoantunes.jiujitsudiary.domain.model.technique;

public enum MoveCategory {
    POSITION("Position"),
    GUARD_PASSING("Guard Passing"),
    TAKE_DOWNS("Take downs and Throws"),
    SUBMISSIONS("Submissions"),
    SWEEPS("Sweeps"),
    ESCAPES_AND_DEFENSES("Escapes and Defenses");

    private final String description;

    MoveCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
