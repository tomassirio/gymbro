package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;

import java.util.UUID;

public interface PlanService {
    PlanDTO createPlan(PlanDTO planDTO);
    PlanDTO getPlan(UUID id);
    PlanDTO addRoutineToPlan(UUID planId, RoutineDTO routineDTO);
    PlanDTO removeRoutineFromPlan(UUID planId, UUID routineId);
    PlanDTO modifyRoutineToPlan(UUID planId, UUID routineId, RoutineDTO dto);
    void deletePlan(UUID planId);

}
