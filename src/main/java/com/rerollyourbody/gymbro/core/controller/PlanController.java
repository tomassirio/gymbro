package com.rerollyourbody.gymbro.core.controller;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/v1/plan")
public class PlanController {

    @PostMapping("")
    public ResponseEntity<PlanDTO> createPlan() {
        return ResponseEntity.ok(new PlanDTO());
    }

    @GetMapping("/{planId}")
    public ResponseEntity<PlanDTO> getPlan(@PathVariable("planId") UUID planId) {
        return ResponseEntity.ok(new PlanDTO());
    }

    @PutMapping("/{planId}")
    public ResponseEntity<PlanDTO> changePlan(@PathVariable("planId") UUID planId, @RequestParam PlanDTO planDTO) {
        return ResponseEntity.ok(new PlanDTO());
    }

    @DeleteMapping("/{planId}")
    public void deletePlan(@PathVariable("planId") UUID planId) {
    }
}
