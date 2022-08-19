package com.rerollyourbody.gymbro.model.factory;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.RoutineFactory;
import com.rerollyourbody.gymbro.testUtils.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createRoutine;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createValidRoutineDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RoutineFactoryTest {
    @Test
    public void test_createRoutine() {
        Routine routine = RoutineFactory.createRoutine();

        Routine templateRoutine = Routine.builder().build();
        templateRoutine.setWorkoutExercises(new ArrayList<>());

        assertNotEquals(routine.getRoutineId(), templateRoutine.getRoutineId());
        assertEquals(routine.getWorkoutExercises(), templateRoutine.getWorkoutExercises());
    }

    @Test
    public void test_createRoutine_from_DTO() {
        RoutineDTO routineDTO = createValidRoutineDTO();
        Routine routine = RoutineFactory.createRoutine(routineDTO);

        Routine templateRoutine = createRoutine();

        assertNotEquals(routine.getRoutineId(), templateRoutine.getRoutineId());
        assertEquals(routine.getWorkoutExercises(), templateRoutine.getWorkoutExercises());
    }

}