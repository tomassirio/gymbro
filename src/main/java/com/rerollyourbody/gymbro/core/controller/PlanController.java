package com.rerollyourbody.gymbro.core.controller;

import com.rerollyourbody.gymbro.core.APIResource.APIPaths;
import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.exception.RoutineNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.service.PlanService;
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

@RestController
@RequestMapping(value = APIPaths.API_VERSION_1_PLAN, produces = {MediaType.APPLICATION_JSON_VALUE})
public class PlanController {

    private static final String PLAN_ID_PATH = "/{planId}";
    private static final String PLAN_ID_PATH_VARIABLE = "planId";

    @Autowired
    private PlanServiceImpl planService;

    @PostMapping("")
    public ResponseEntity<PlanDTO> createPlan(PlanDTO planDTO) {
        PlanDTO plan = planService.createPlan(planDTO);
        return ResponseEntity.ok(plan);
    }

    @GetMapping(PLAN_ID_PATH)
    public ResponseEntity<PlanDTO> getPlanById(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId) {
        //validate planId
        try {
            UUID id = UUID.fromString(planId);
            PlanDTO plan = planService.getPlan(id);
            return ResponseEntity.ok(plan);
        } catch (RuntimeException e) {
            throw new PlanNotFoundException(e.getMessage());
        }
    }

    @PutMapping(PLAN_ID_PATH)
    public ResponseEntity<PlanDTO> changePlan(@PathVariable(PLAN_ID_PATH_VARIABLE) String planId, @RequestParam PlanDTO planDTO) {
        //Validate DTO and planId
        try {
            UUID id = UUID.fromString(planId);
            PlanDTO result = planService.changePlan(id, planDTO);
            return ResponseEntity.ok(result);
        }catch (RuntimeException e){
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
