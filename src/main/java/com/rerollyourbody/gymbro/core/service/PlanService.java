package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;

import java.util.Optional;

public interface PlanService {
    Optional<Plan> createPlan();
    Optional<Plan> getPlan(Long id);
    Optional<Plan> modifyPlan(Long id, PlanDTO planDTO);
    void deletePlan(Long id);

}
