package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Plan {
    @Id
    private UUID id;
    private UUID userId;

    private List<UUID> routineIds;
    private Integer week;
    private Integer totalWeeks;

}

