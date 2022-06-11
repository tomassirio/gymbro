package com.rerollyourbody.gymbro.testUtils;

import com.rerollyourbody.gymbro.core.model.BodyFocus;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TestUtils {
    public static Plan createPlan(){
        return Plan.builder()
                .id(UUID.randomUUID())
                .userId(UUID.randomUUID())
                .routines(List.of(createRoutine()))
                .week(2)
                .totalWeeks(13)
                .build();
    }

    public static Routine createRoutine() {
        return Routine.builder()
                .routineId(UUID.randomUUID())
                .exercises(Map.of(createExercise(), List.of(createSet())))
                .build();
    }

    public static Exercise createExercise() {
        return Exercise.builder()
                .name("Squat")
                .bodyFocus(BodyFocus.LEGS)
                .build();
    }

    public static Set createSet() {
        return Set.builder()
                .weight(69.0f)
                .repetitions(420)
                .build();
    }
}