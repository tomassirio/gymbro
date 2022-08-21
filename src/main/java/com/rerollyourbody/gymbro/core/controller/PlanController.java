package com.rerollyourbody.gymbro.core.controller;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController("/v1/plan")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping("")
    public ResponseEntity<PlanDTO> createPlan() {
        return ResponseEntity.ok(PlanDTO.of(planService.createPlan().get()));
    }

    @GetMapping("/{planId}")
    public ResponseEntity<PlanDTO> getPlan(@PathVariable("planId") Long planId) {
        return ResponseEntity.ok(PlanDTO.of(planService.getPlan(planId).get()));
    }

    @PutMapping("/{planId}")
    public ResponseEntity<PlanDTO> modifyPlan(@PathVariable("planId") Long planId, @RequestParam PlanDTO planDTO) {
        return ResponseEntity.ok(PlanDTO.of(planService.modifyPlan(planId, planDTO).get()));
    }

    @DeleteMapping("/{planId}")
    public void deletePlan(@PathVariable("planId") Long planId) {
        planService.deletePlan(planId);
    }
}
