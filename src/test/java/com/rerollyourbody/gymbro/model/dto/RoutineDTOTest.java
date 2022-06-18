package com.rerollyourbody.gymbro.model.dto;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;
import org.junit.jupiter.api.Test;


import java.util.UUID;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createRoutine;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoutineDTOTest {
    @Test
    public void test_of_when_routine_is_valid() {
        Routine routine = createRoutine();
        RoutineDTO routineDTO = RoutineDTO.of(routine);

        assertEquals(UUID.fromString(routineDTO.getId()), routine.getRoutineId());
        assertEquals(routineDTO.getExercises().size(), routine.getExercises().size());
    }
}
