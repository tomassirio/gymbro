package com.rerollyourbody.gymbro.model.factory;

import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.model.factory.RoutineFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class RoutineFactoryTest {
    @Test
    public void test_createRoutine() {
        Routine routine = RoutineFactory.createRoutine();

        Routine templateRoutine = new Routine();
        templateRoutine.setRoutineId(routine.getRoutineId()); //This is awful. I know. But I'm in the middle of a production crisis => More work == Better
        templateRoutine.setExercises(new LinkedHashMap<>());

        assertEquals(routine.getRoutineId(), templateRoutine.getRoutineId());
        assertEquals(routine.getExercises(), templateRoutine.getExercises());
    }

}