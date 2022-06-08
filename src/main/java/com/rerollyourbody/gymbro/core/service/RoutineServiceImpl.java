package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.model.BodyFocus;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;
import com.rerollyourbody.gymbro.core.model.factory.RoutineFactory;
import com.rerollyourbody.gymbro.core.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoutineServiceImpl implements RoutineService{

    @Autowired
    private RoutineRepository routineRepository;

    @Override
    public RoutineDTO createRoutine(RoutineDTO routineDTO) {
        UUID routineId = UUID.randomUUID();
        Routine routine = RoutineFactory.createRoutine(routineId);
        if (routineDTO.getExercises() != null) {
                routine.setExercises(routineDTO.getExercises());
        }

        routineRepository.save(routine);
        return RoutineDTO.of(routine);
    }


    @Override
    public RoutineDTO getRoutine(UUID routineId) {
        Optional<Routine> routineOptional = routineRepository.findById(routineId);
        if(routineOptional.isEmpty()){
            throw new PlanNotFoundException("No existing routine with id: " + routineId);
        }
        return RoutineDTO.of(routineOptional.get());
    }

    @Override
    public RoutineDTO modifyRoutine(UUID routineId, RoutineDTO dto) {
        Optional<Routine> routineOptional = routineRepository.findById(routineId);
        if(routineOptional.isEmpty()){
            throw new PlanNotFoundException("No existing routine with id: " + routineId);
        }
        Routine routine = routineOptional.get();
        routine.setRoutineId(routineId);
        routine.setExercises(dto.getExercises());
        return RoutineDTO.of(routine);
    }

    @Override
    public void deleteRoutine(UUID routineId) {
        routineRepository.deleteById(routineId);
    }
}
