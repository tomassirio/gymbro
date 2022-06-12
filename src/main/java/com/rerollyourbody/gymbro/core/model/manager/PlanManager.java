package com.rerollyourbody.gymbro.core.model.manager;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.mapper.RoutineMapper;

import java.util.List;
import java.util.UUID;

public class PlanManager {
    public static Plan addRoutinesToPlan(final List<Routine> routines, Plan plan){
        routines.forEach(r -> addRoutineToPlan(r, plan));
        return plan;
    }

    public static Plan removeRoutinesFromPlan(final List<UUID> routineIds, Plan plan) {
        routineIds.forEach(rId -> removeRoutineFromPlan(rId, plan));
        return plan;
    }

    public static void removeRoutineFromPlan(final UUID routineId, Plan plan) {
        plan.getRoutines().removeIf(r -> r.getRoutineId().equals(routineId));
    }

    public static void addRoutineToPlan(final Routine routine, Plan plan){
        plan.getRoutines().add(routine);
    }
}
