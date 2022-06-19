package com.rerollyourbody.gymbro.testUtils;

import com.rerollyourbody.gymbro.core.model.BodyFocus;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import com.rerollyourbody.gymbro.core.model.WorkoutExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TestUtils {

    private static final UUID PLAN_ID = UUID.fromString("2bac64a9-b811-4756-96c4-cf9b067f8182");
    private static final UUID USER_ID = UUID.fromString("fde630e0-6ceb-4750-946c-83b410f1d726");
    private static final UUID ROUTINE_ID = UUID.fromString("cd086b6d-7afc-421f-b8cf-b9bfe4fe2d06");

    public static Plan createPlan(){
        return Plan.builder()
                .id(PLAN_ID)
                .userId(USER_ID)
                .routines(new ArrayList<>(Arrays.asList(createRoutine())))
                .week(2)
                .totalWeeks(13)
                .build();
    }

    public static Routine createRoutine() {
        return Routine.builder()
                .routineId(ROUTINE_ID)
                .workoutExercises(
                        new ArrayList<>(Arrays.asList(
                                WorkoutExercise.builder()
                                        .exercise(createExercise())
                                        .sets(List.of(createSet()))
                                        .build())))
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

    public static PlanDTO createValidPlanDTO() {
        return PlanDTO.of(createPlan());
    }

    public static RoutineDTO createValidRoutineDTO() {
        return RoutineDTO.of(createRoutine());
    }
}
