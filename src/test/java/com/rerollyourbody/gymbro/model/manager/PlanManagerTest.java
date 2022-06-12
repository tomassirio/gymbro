package com.rerollyourbody.gymbro.model.manager;

import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.model.manager.PlanManager;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createPlan;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createRoutine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlanManagerTest {
    @Test
    public void test_add_routine_to_existing_plan() {
        Plan plan = createPlan();
        int routinesBeforeMethod = plan.getRoutines().size();
        Routine routine = createRoutine();

        PlanManager.addRoutineToPlan(routine, plan);

        assertEquals(plan.getRoutines().size(), routinesBeforeMethod + 1);
        assertTrue(plan.getRoutines().contains(routine));
    }

    @Test
    public void test_add_routine_to_empty_plan() {
        Plan plan = PlanFactory.createPlan();

        Routine routine = createRoutine();

        PlanManager.addRoutineToPlan(routine, plan);

        assertEquals(plan.getRoutines().size(), 1);
        assertTrue(plan.getRoutines().contains(routine));
    }

    @Test
    public void test_remove_routine_to_existing_plan() {
        Plan plan = createPlan();
        int routinesBeforeMethod = plan.getRoutines().size();
        Routine routine = createRoutine();

        PlanManager.addRoutineToPlan(routine, plan);

        assertEquals(plan.getRoutines().size(), routinesBeforeMethod + 1);
        assertTrue(plan.getRoutines().contains(routine));

        PlanManager.removeRoutineFromPlan(routine.getRoutineId(), plan);

        assertEquals(plan.getRoutines().size(), routinesBeforeMethod);
        assertFalse(plan.getRoutines().contains(routine));
    }

    @Test
    public void test_remove_routine_not_existing_in_plan() {
        Plan plan = createPlan();
        int routinesBeforeMethod = plan.getRoutines().size();

        UUID routineId = UUID.randomUUID();

        PlanManager.removeRoutineFromPlan(routineId, plan);

        assertEquals(plan.getRoutines().size(), routinesBeforeMethod);
    }
}
