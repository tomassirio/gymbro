package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Routine {
    @Id
    private UUID routineId;
    private Map<Exercise, List<Set>> exercises;
}

