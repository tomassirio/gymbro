package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Routine;

import java.util.UUID;

public interface PlanService {
    PlanDTO createPlan();
    PlanDTO addRoutineToPlan(Routine routine, UUID planId);
    PlanDTO changeRoutineToPlan(Routine routine, UUID planId);
    void deletePlan(UUID planId);

}
