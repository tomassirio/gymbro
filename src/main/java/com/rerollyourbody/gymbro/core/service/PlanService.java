package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Routine;

import java.util.UUID;

public interface PlanService {
    PlanDTO createPlan(PlanDTO planDTO);
    PlanDTO getPlan(UUID id);
    PlanDTO changePlan(UUID planId, PlanDTO planDTO);
    void deletePlan(UUID planId);

}
