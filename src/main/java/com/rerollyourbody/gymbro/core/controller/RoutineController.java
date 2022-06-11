package com.rerollyourbody.gymbro.core.controller;

import com.rerollyourbody.gymbro.core.APIResource.APIPaths;
import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.service.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.rerollyourbody.gymbro.core.APIResource.APIPaths.PLAN_ID_PATH_VARIABLE;
import static com.rerollyourbody.gymbro.core.APIResource.APIPaths.ROUTINE_ID_PATH;
import static com.rerollyourbody.gymbro.core.APIResource.APIPaths.ROUTINE_ID_PATH_VARIABLE;

@RestController
@RequestMapping(value = APIPaths.API_VERSION_1_ROUTINE, produces = {MediaType.APPLICATION_JSON_VALUE})
public class RoutineController {

    @Autowired
    private PlanServiceImpl planService;

    @PostMapping("")
    public ResponseEntity<PlanDTO> addRoutineToPlan(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId, @RequestParam RoutineDTO routineDTO) {
        //Validate DTO and planId
        try {
            PlanDTO result = planService.addRoutineToPlan(UUID.fromString(planId), routineDTO);
            return ResponseEntity.ok(result);
        }catch (RuntimeException e){
            throw new PlanNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping(ROUTINE_ID_PATH)
    public ResponseEntity<PlanDTO> removeRoutineFromPlan(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId, @PathVariable(ROUTINE_ID_PATH_VARIABLE) String routineId) {
        //Validate DTO and planId
        try {
            PlanDTO result = planService.removeRoutineFromPlan(UUID.fromString(planId), UUID.fromString(routineId));
            return ResponseEntity.ok(result);
        }catch (RuntimeException e){
            throw new PlanNotFoundException(e.getMessage());
        }
    }

    @PutMapping(ROUTINE_ID_PATH)
    public ResponseEntity<PlanDTO> modifyRoutineToPlan(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId, @PathVariable String routineId, @RequestParam RoutineDTO routineDTO) {
        //Validate DTO and planId
        try {
            PlanDTO result = planService.modifyRoutineToPlan(UUID.fromString(planId), UUID.fromString(routineId), routineDTO);
            return ResponseEntity.ok(result);
        }catch (RuntimeException e){
            throw new PlanNotFoundException(e.getMessage());
        }
    }
}
