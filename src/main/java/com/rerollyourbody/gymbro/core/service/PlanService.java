package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;

import java.util.UUID;

public interface PlanService {
    Plan createPlan(PlanDTO planDTO);
    Plan getPlan(UUID id);
    Plan addRoutineToPlan(UUID planId, RoutineDTO routineDTO);
    Plan removeRoutineFromPlan(UUID planId, UUID routineId);
    Plan modifyRoutineToPlan(UUID planId, UUID routineId, RoutineDTO dto);
    void deletePlan(UUID planId);

}
