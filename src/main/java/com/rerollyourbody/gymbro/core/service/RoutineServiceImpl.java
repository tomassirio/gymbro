package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.exception.RoutineNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.RoutineFactory;
import com.rerollyourbody.gymbro.core.repository.RoutineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepository;

    @Override
    public Routine getRoutineById(UUID routineId) {
        Optional<Routine> routineOptional = routineRepository.findById(routineId);
        if (routineOptional.isEmpty()) {
            throw new RoutineNotFoundException("No existing plan with id: " + routineId);
        }

        return routineOptional.get();
    }

    @Override
    public Routine modifyRoutine(RoutineDTO routineDTO) {
        Optional<Routine> routineOptional = routineRepository.findById(UUID.fromString(routineDTO.getId()));
        if (routineOptional.isEmpty()) {
            throw new RoutineNotFoundException("No existing plan with id: " + routineDTO.getId());
        }
        Routine routine = routineOptional.get();
        routine.setWorkoutExercises(routineDTO.getWorkoutExercises());

        return routine;

    }

    @Override
    public Routine createRoutine(RoutineDTO routineDTO) {
        Routine routine = RoutineFactory.createRoutine();
        routine.getWorkoutExercises().addAll(routineDTO.getWorkoutExercises());

        routineRepository.save(routine);
        return routine;
    }

    @Override
    public void deleteRoutine(UUID routineId) {
        routineRepository.deleteById(routineId);
    }
}
