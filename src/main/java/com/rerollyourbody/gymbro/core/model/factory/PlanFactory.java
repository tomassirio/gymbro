package com.rerollyourbody.gymbro.core.model.factory;

import com.rerollyourbody.gymbro.core.model.Plan;

import java.util.ArrayList;
import java.util.UUID;

public class PlanFactory {
    public static Plan createPlan(UUID uuid){
     return Plan.builder()
             .id(uuid)
             .routines(new ArrayList<>())
             .week(1)
             .totalWeeks(0)
             .build();
    }
}
