package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.model.manager.PlanManager;
import com.rerollyourbody.gymbro.core.model.mapper.RoutineMapper;
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
        if (!planDTO.getRoutines().isEmpty() && planDTO.getTotalWeeks() != null) {
            planDTO.getRoutines().forEach(dto ->
                    PlanManager.addRoutineToPlan(
                            RoutineMapper.map(dto), plan));
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
    public PlanDTO addRoutineToPlan(UUID planId, RoutineDTO dto) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        PlanManager.addRoutineToPlan(RoutineMapper.map(dto), plan);
        planRepository.save(plan);

        return PlanDTO.of(plan);
    }

    @Override
    public PlanDTO removeRoutineFromPlan(UUID planId, UUID routineId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        PlanManager.removeRoutineFromPlan(routineId, plan);
        planRepository.save(plan);

        return PlanDTO.of(plan);
    }

    @Override
    public PlanDTO modifyRoutineToPlan(UUID planId, UUID routineId, RoutineDTO dto) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        plan.getRoutines().stream().map(r -> r.equals(routineId) ? RoutineMapper.map(dto) : r);
        return PlanDTO.of(plan);
    }

    @Override
    public void deletePlan(UUID planId) {
        planRepository.deleteById(planId);
    }
}
