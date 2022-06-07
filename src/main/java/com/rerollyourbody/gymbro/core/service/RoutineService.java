package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Exercise;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.Set;

import java.util.UUID;

public interface RoutineService {

    RoutineDTO createRoutine(RoutineDTO routineDTO);
    RoutineDTO getRoutine(UUID routineId);
    RoutineDTO modifyRoutine(UUID routineId, RoutineDTO dto);
    void deleteRoutine(UUID routineId);

}
