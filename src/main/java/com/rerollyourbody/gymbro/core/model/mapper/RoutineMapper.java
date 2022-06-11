package com.rerollyourbody.gymbro.core.model.mapper;

import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;

public class RoutineMapper {
    public static Routine map(RoutineDTO dto) {
        return Routine.builder()
                .exercises(dto.getExercises().isEmpty() ? new LinkedHashMap<>() : dto.getExercises())
                .routineId(dto.getId().isEmpty() ? UUID.randomUUID() : UUID.fromString(dto.getId()))
                .build();
    }
}
