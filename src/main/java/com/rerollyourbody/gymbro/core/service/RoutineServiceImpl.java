package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.BodyFocus;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import com.rerollyourbody.gymbro.core.model.factory.RoutineFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.UUID;

@Service
public class RoutineServiceImpl implements RoutineService{

    @Override
    public RoutineDTO createRoutine(RoutineDTO routineDTO) {
        UUID routineId = UUID.randomUUID();
        Routine routine = RoutineFactory.createRoutine(routineId);
        if (routineDTO.getExercises() != null) {
                routine.setExercises(routineDTO.getExercises());
        }
        //Repository Save
        return RoutineDTO.of(routine);
    }


    @Override
    public RoutineDTO getRoutine(UUID id) {
        //Repository get id
        Routine routine = new Routine();
        Exercise exercise = new Exercise("Squat", BodyFocus.LEGS);
        Set set = new Set(5, 100.0f);
        routine.addExercise(exercise);
        routine.addSet(exercise, set);
        return RoutineDTO.of(routine);
    }

    @Override
    public RoutineDTO modifyRoutine(UUID routineId, RoutineDTO dto) {
        //Repository get id
        Routine routine = new Routine();
        routine.setRoutineId(routineId);
        routine.setExercises(dto.getExercises());
        return RoutineDTO.of(routine);
    }

    @Override
    public void deleteRoutine(UUID id) {
        //Repository delete id
    }
}
