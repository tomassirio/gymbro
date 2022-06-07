package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class PlanServiceImpl implements PlanService{
    @Override
    public PlanDTO createPlan(PlanDTO planDTO) {
        UUID uuid = UUID.randomUUID();
        Plan plan = PlanFactory.createPlan(uuid);
        if (planDTO.getRoutines() != null && planDTO.getTotalWeeks() != null) {
            plan.setRoutines(planDTO.getRoutines());
            plan.setTotalWeeks(planDTO.getTotalWeeks());
        }
        return PlanDTO.of(plan);
    }

    @Override
    public PlanDTO getPlan(UUID id) {
        //Retrieve plan from Repository if id exists
        return null;
    }

    @Override
    public PlanDTO changePlan(UUID planId, PlanDTO planDTO) {
        //Retrieve plan from Repository if id exists
        Plan plan = PlanFactory.createPlan(planId);
        plan.setWeek(planDTO.getWeek());
        plan.setRoutines(planDTO.getRoutines());
        plan.setTotalWeeks(planDTO.getTotalWeeks());
        return PlanDTO.of(plan);
    }

    @Override
    public void deletePlan(UUID planId) {
        //Delete id from Repository
    }
}
