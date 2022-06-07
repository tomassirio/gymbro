package com.rerollyourbody.gymbro.core.controller;

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
@RequestMapping(value = "/v1/routine", produces = {MediaType.APPLICATION_JSON_VALUE})
public class RoutineController {

    @Autowired
    private RoutineServiceImpl routineService;

    @GetMapping("/{routineId}")
    public ResponseEntity<RoutineDTO> getRoutineById(@PathVariable("routineId") String routineId){
        try {
            UUID id = UUID.fromString(routineId);
            RoutineDTO routineDTO = routineService.getRoutineById(id);
            return ResponseEntity.ok(routineDTO);

        }catch (RuntimeException e){
            throw new RoutineNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{routineId}")
    public void deleteRoutine(@PathVariable("routineId") String routineId) {
        try {
            UUID id = UUID.fromString(routineId);
            routineService.deleteRoutine(id);
        }catch (RuntimeException e){
            throw new RoutineNotFoundException(e.getMessage());
        }
    }
}
