package br.com.gustavoantunes.jiujitsudiary.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public record TrainingSession(
        LocalDateTime dateTime,
        TrainingType type,
        List<Technique> techniques,
        Integer sparringRounds
) {}