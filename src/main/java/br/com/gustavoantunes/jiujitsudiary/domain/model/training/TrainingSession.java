package br.com.gustavoantunes.jiujitsudiary.domain.model.training;

import br.com.gustavoantunes.jiujitsudiary.domain.model.technique.Technique;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public record TrainingSession(
        UUID id,
        LocalDateTime dateTime,
        TrainingType type,
        List<Technique> techniques
) {
    public TrainingSession{
        techniques = Collections.unmodifiableList(techniques);
    }
}