package com.rerollyourbody.gymbro.core.model.DTO;

import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Long planId;
    private Long userId;

    private List<Routine> routines;
    private Integer week;
    private Integer totalWeeks;

    public static PlanDTO of(Plan plan){
        return new PlanDTO(
                plan.getId(),
                plan.getUser().getId(),
                plan.getRoutines(),
                plan.getWeek(),
                plan.getTotalWeeks()
        );
    }
}
