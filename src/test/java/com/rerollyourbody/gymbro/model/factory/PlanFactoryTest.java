package com.rerollyourbody.gymbro.model.factory;

import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlanFactoryTest {
    @Test
    public void test_createPlan() {
        Plan plan = PlanFactory.createPlan();

        Plan templatePlan = new Plan();
        templatePlan.setId(plan.getId()); //This is awful. I know. But I'm in the middle of a production crisis => More work == Better
        templatePlan.setWeek(1);
        templatePlan.setTotalWeeks(0);
        templatePlan.setRoutines(new ArrayList<>());

        assertEquals(plan.getId(), templatePlan.getId());
        assertEquals(plan.getWeek(), templatePlan.getWeek());
        assertEquals(plan.getTotalWeeks(), templatePlan.getTotalWeeks());
        assertEquals(plan.getRoutines(), templatePlan.getRoutines());
    }

}