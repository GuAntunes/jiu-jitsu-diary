package br.com.gustavoantunes.jiujitsudiary.domain.model.user;

import java.util.Objects;

public class Belt {
    private final BeltRank beltRank;
    private final Grade grade;

    public Belt(BeltRank beltRank, Grade grade) {
        this.beltRank = beltRank;
        this.grade = grade;
    }

    public BeltRank getBeltRank() {
        return beltRank;
    }

    public Grade getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Belt belt = (Belt) o;
        return beltRank == belt.beltRank && grade == belt.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beltRank, grade);
    }
}
