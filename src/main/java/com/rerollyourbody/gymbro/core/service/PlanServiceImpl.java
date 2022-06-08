package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanRepository planRepository;

    @Override
    public PlanDTO createPlan(PlanDTO planDTO) {
        UUID uuid = UUID.randomUUID();
        Plan plan = PlanFactory.createPlan(uuid);
        if (!planDTO.getRoutineIds().isEmpty() && planDTO.getTotalWeeks() != null) {
            plan.setRoutineIds(planDTO.getRoutineIds()
                    .stream()
                    .map(UUID::fromString)
                    .collect(Collectors.toList()));
            plan.setTotalWeeks(planDTO.getTotalWeeks());
        }
        planRepository.save(plan);
        return PlanDTO.of(plan);
    }

    @Override
    public PlanDTO getPlan(UUID planId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        return PlanDTO.of(planOptional.get());
    }

    @Override
    public PlanDTO changePlan(UUID planId, PlanDTO planDTO) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        plan.setRoutineIds(planDTO.getRoutineIds().stream().map(UUID::fromString).collect(Collectors.toList()));
        plan.setWeek(planDTO.getWeek());
        plan.setTotalWeeks(planDTO.getTotalWeeks());
        planRepository.save(plan);

        return PlanDTO.of(plan);
    }

    @Override
    public void deletePlan(UUID planId) {
        planRepository.deleteById(planId);
    }
}
