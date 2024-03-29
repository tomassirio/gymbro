package com.rerollyourbody.gymbro.core.model.factory;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

public class RoutineFactory {
    public static Routine createRoutine(){
     return Routine.builder()
             .routineId(UUID.randomUUID())
             .workoutExercises(new ArrayList<>())
             .build();
    }

    public static Routine createRoutine(RoutineDTO dto) {
        return Routine.builder()
                .routineId(UUID.randomUUID())
                .workoutExercises(dto.getWorkoutExercises())
                .build();
    }
}
