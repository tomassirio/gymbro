package com.rerollyourbody.gymbro.core.model.DTO;

import com.rerollyourbody.gymbro.core.model.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDTO {
    private String planId;
    private String userId;

    private List<RoutineDTO> routines;
    private Integer week;
    private Integer totalWeeks;

    public static PlanDTO of(Plan plan){
        return new PlanDTO(
                plan.getId().toString(),
                plan.getUserId().toString(),
                plan.getRoutines()
                        .stream()
                        .map(RoutineDTO::of)
                        .collect(Collectors.toList()),
                plan.getWeek(),
                plan.getTotalWeeks()
        );
    }
}
