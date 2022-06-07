package com.rerollyourbody.gymbro.core.controller;

import com.rerollyourbody.gymbro.core.APIResource.APIPaths;
import com.rerollyourbody.gymbro.core.exception.RoutineNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.service.RoutineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = APIPaths.API_VERSION_1_ROUTINE, produces = {MediaType.APPLICATION_JSON_VALUE})
public class RoutineController {

    private static final String ROUTINE_ID_PATH = "/{routineId}";
    private static final String ROUTINE_ID_PATH_VARIABLE = "routineId";

    @Autowired
    private RoutineServiceImpl routineService;

    @GetMapping(ROUTINE_ID_PATH)
    public ResponseEntity<RoutineDTO> getRoutineById(@PathVariable(ROUTINE_ID_PATH_VARIABLE) String routineId){
        try {
            UUID id = UUID.fromString(routineId);
            RoutineDTO routineDTO = routineService.getRoutineById(id);
            return ResponseEntity.ok(routineDTO);

        }catch (RuntimeException e){
            throw new RoutineNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping(ROUTINE_ID_PATH)
    public void deleteRoutine(@PathVariable(ROUTINE_ID_PATH_VARIABLE) String routineId) {
        try {
            UUID id = UUID.fromString(routineId);
            routineService.deleteRoutine(id);
        }catch (RuntimeException e){
            throw new RoutineNotFoundException(e.getMessage());
        }
    }
}
