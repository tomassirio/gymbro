package com.rerollyourbody.gymbro.core.model.factory;

import com.rerollyourbody.gymbro.core.model.Plan;

import java.util.ArrayList;
import java.util.UUID;

public class PlanFactory {
    public static Plan createPlan(){
     return Plan.builder()
             .id(UUID.randomUUID())
             .routines(new ArrayList<>())
             .week(1)
             .totalWeeks(0)
             .build();
    }
}
