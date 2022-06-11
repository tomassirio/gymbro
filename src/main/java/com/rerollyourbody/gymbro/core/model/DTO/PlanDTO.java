package com.rerollyourbody.gymbro.core.model.DTO;

import com.rerollyourbody.gymbro.core.model.Plan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private UUID planId;
    private UUID userId;

    private List<RoutineDTO> routines;
    private Integer week;
    private Integer totalWeeks;

    public static PlanDTO of(Plan plan){
        return new PlanDTO(
                plan.getId(),
                plan.getUserId(),
                plan.getRoutines()
                        .stream()
                        .map(RoutineDTO::of)
                        .collect(Collectors.toList()),
                plan.getWeek(),
                plan.getTotalWeeks()
        );
    }
}
