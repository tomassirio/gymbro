package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

    private final PlanRepository planRepository;
    private final RoutineServiceImpl routineService;

    @Override
    public Plan createPlan(PlanDTO planDTO) {
        Plan plan = PlanFactory.createPlan();
        if (!planDTO.getRoutines().isEmpty() && planDTO.getTotalWeeks() != null) {
            planDTO.getRoutines().forEach(dto -> plan.getRoutines().add(routineService.createRoutine(dto)));
        }
        return planRepository.save(plan);
    }

    @Override
    public Plan getPlan(UUID planId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        return planOptional.get();
    }

    @Override
    public Plan addRoutineToPlan(UUID planId, RoutineDTO dto) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        Routine routine;
        try {
            routine = routineService.getRoutineById(UUID.fromString(dto.getId()));
        } catch (NoSuchElementException e) {
            routine = routineService.createRoutine(dto);
        }

        plan.getRoutines().add(routine);

        return plan;
    }

    @Override
    public Plan removeRoutineFromPlan(UUID planId, UUID routineId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        Routine routine = routineService.getRoutineById(routineId);
        plan.getRoutines().removeIf(rout -> rout.getRoutineId().equals(routine.getRoutineId()));

        return plan;
    }

    @Override
    public Plan modifyRoutineToPlan(UUID planId, UUID routineId, RoutineDTO dto) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if(planOptional.isEmpty()){
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        Routine finalRoutine = routineService.modifyRoutine(dto);
        plan.setRoutines(plan.getRoutines().stream()
                .map(routine -> routine.getRoutineId().equals(routineId) ? finalRoutine : routine)
                .collect(Collectors.toList()));
        return plan;
    }

    @Override
    public void deletePlan(UUID planId) {
        planRepository.deleteById(planId);
    }
}
