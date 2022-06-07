package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Set;

import java.util.UUID;

public interface RoutineService {

    RoutineDTO createRoutine();
    RoutineDTO getRoutineById(UUID routineId);
    RoutineDTO addExercise(Exercise exercise, UUID routineId);
    RoutineDTO removeExercise(Exercise exercise, UUID routineId);
    RoutineDTO addSetToExercise(Exercise exercise, Set set, UUID routineId);
    RoutineDTO removeSetToExercise(Exercise exercise, Set set, UUID routineId);

    void deleteRoutine(UUID routineId);

}
