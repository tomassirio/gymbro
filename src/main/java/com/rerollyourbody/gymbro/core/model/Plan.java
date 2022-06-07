package com.rerollyourbody.gymbro.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    @Id
    private UUID id;
    private UUID userId;

    private List<Routine> routines;
    private Integer week;
    private Integer totalWeeks;

}

