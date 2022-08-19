package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.exception.PlanCreationException;
import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.exception.RoutineNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.model.factory.RoutineFactory;
import com.rerollyourbody.gymbro.core.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    @Override
    public Plan createPlan(PlanDTO planDTO) {
        if (planDTO.getTotalWeeks() == null || planDTO.getTotalWeeks() < 1) {
            throw new PlanCreationException("Plan must be at least 1 week long");
        }
        Plan plan = PlanFactory.createPlan(planDTO.getTotalWeeks());

        planDTO.getRoutines().forEach(dto -> plan.getRoutines().add(RoutineFactory.createRoutine(dto)));
        return planRepository.save(plan);
    }

    @Override
    public Plan getPlan(UUID planId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if (planOptional.isEmpty()) {
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        return planOptional.get();
    }

    @Override
    public Plan addRoutineToPlan(UUID planId, RoutineDTO dto) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if (planOptional.isEmpty()) {
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        plan.getRoutines().add(RoutineFactory.createRoutine(dto));

        return planRepository.save(plan);
    }

    @Override
    public Plan removeRoutineFromPlan(UUID planId, UUID routineId) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if (planOptional.isEmpty()) {
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        plan.getRoutines().removeIf(rout -> rout.getRoutineId().equals(routineId));

        return planRepository.save(plan);
    }

    @Override
    public Plan modifyRoutineToPlan(UUID planId, UUID routineId, RoutineDTO dto) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if (planOptional.isEmpty()) {
            throw new PlanNotFoundException("No existing plan with id: " + planId);
        }
        Plan plan = planOptional.get();
        Optional<Routine> finalRoutine = plan.getRoutines().stream().filter(routine -> routine.getRoutineId().equals(routineId)).findFirst();
        if (finalRoutine.isEmpty()) {
            throw new RoutineNotFoundException("Routine with id: " + routineId + " not found in plan with id: " + planId);
        }
        finalRoutine.get().setWorkoutExercises(dto.getWorkoutExercises());
        plan.setRoutines(plan.getRoutines().stream()
                .map(routine -> routine.getRoutineId().equals(routineId) ? finalRoutine.get() : routine)
                .collect(Collectors.toList()));

        return planRepository.save(plan);
    }

    @Override
    public void deletePlan(UUID planId) {
        planRepository.deleteById(planId);
    }
}
