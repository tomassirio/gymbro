package com.rerollyourbody.gymbro.core.model.factory;

import com.rerollyourbody.gymbro.core.model.Routine;

import java.util.LinkedHashMap;
import java.util.UUID;

public class RoutineFactory {
    public static Routine createRoutine(UUID uuid){
     return Routine.builder()
             .routineId(uuid)
             .exercises(new LinkedHashMap<>())
             .build();
    }
}
