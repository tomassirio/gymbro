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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.rerollyourbody.gymbro.core.APIResource.APIPaths.PLAN_ID_PATH;
import static com.rerollyourbody.gymbro.core.APIResource.APIPaths.PLAN_ID_PATH_VARIABLE;

@RestController
@RequestMapping(value = APIPaths.API_VERSION_1_PLAN, produces = {MediaType.APPLICATION_JSON_VALUE})
public class PlanController {

    @Autowired
    private PlanServiceImpl planService;

    @PostMapping("")
    public ResponseEntity<PlanDTO> createPlan(PlanDTO planDTO) {
        PlanDTO plan = planService.createPlan(planDTO);
        return ResponseEntity.ok(plan);
    }

    @GetMapping(PLAN_ID_PATH)
    public ResponseEntity<PlanDTO> getPlanById(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId) {
        try {
            PlanDTO plan = planService.getPlan(UUID.fromString(planId));
            return ResponseEntity.ok(plan);
        } catch (RuntimeException e) {
            throw new PlanNotFoundException(e.getMessage());
        }
    }



    @DeleteMapping(PLAN_ID_PATH)
    public void deletePlan(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId) {
        //validate planId
        try {
            planService.deletePlan(UUID.fromString(planId));
        } catch (RuntimeException e){
            throw new PlanNotFoundException(e.getMessage());

        }

    }
}
