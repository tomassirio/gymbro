package com.rerollyourbody.gymbro.core.service;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;


public interface RoutineService {
    Routine getRoutineById(UUID routineId);
    Routine modifyRoutine(RoutineDTO routineDTO);
    Routine createRoutine(RoutineDTO routineDTO);
    void deleteRoutine(UUID routineId);
}
