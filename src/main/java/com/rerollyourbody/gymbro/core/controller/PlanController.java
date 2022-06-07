package com.rerollyourbody.gymbro.core.controller;

import com.rerollyourbody.gymbro.core.APIResource.APIPaths;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
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

    @PostMapping("")
    public ResponseEntity<PlanDTO> createPlan() {
        return ResponseEntity.ok(new PlanDTO());
    }

    @GetMapping(PLAN_ID_PATH)
    public ResponseEntity<PlanDTO> getPlan(@PathVariable(PLAN_ID_PATH_VARIABLE) UUID planId) {
        return ResponseEntity.ok(new PlanDTO());
    }

    @PutMapping(PLAN_ID_PATH)
    public ResponseEntity<PlanDTO> changePlan(@PathVariable(PLAN_ID_PATH_VARIABLE) UUID planId, @RequestParam PlanDTO planDTO) {
        return ResponseEntity.ok(new PlanDTO());
    }

    @DeleteMapping(PLAN_ID_PATH)
    public void deletePlan(@PathVariable(PLAN_ID_PATH_VARIABLE) UUID planId) {
    }
}
