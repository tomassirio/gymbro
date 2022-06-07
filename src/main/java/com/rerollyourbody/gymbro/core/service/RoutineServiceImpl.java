package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.BodyFocus;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoutineServiceImpl implements RoutineService{

    @Override
    public RoutineDTO createRoutine() {
        return null;
    }

    @Override
    public RoutineDTO addExercise(Exercise exercise, UUID routineId) {
        return null;
    }

    @Override
    public RoutineDTO removeExercise(Exercise exercise, UUID routineId) {
        return null;
    }

    @Override
    public RoutineDTO addSetToExercise(Exercise exercise, Set set, UUID routineId) {
        return null;
    }

    @Override
    public RoutineDTO removeSetToExercise(Exercise exercise, Set set, UUID routineId) {
        return null;
    }

    @Override
    public RoutineDTO getRoutineById(UUID id) {
        Routine routine = new Routine();
        Exercise exercise = new Exercise("Squat", BodyFocus.LEGS);
        Set set = new Set(5, 100.0f);
        routine.addExercise(exercise);
        routine.addSet(exercise, set);
        return RoutineDTO.of(routine);
    }

    @Override
    public void deleteRoutine(UUID id) {

    }
}
