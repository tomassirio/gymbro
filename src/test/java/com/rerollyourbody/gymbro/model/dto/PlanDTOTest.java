package com.rerollyourbody.gymbro.model.dto;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createPlan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlanDTOTest {
    @Test
    public void test_of_when_plan_is_valid() {
        Plan plan = createPlan();
        PlanDTO planDTO = PlanDTO.of(plan);

        assertEquals(plan.getId(), UUID.fromString(planDTO.getPlanId()));
        assertEquals(plan.getUserId(), UUID.fromString(planDTO.getUserId()));
        assertEquals(plan.getWeek(), planDTO.getWeek());
        assertEquals(plan.getTotalWeeks(), planDTO.getTotalWeeks());
        assertEquals(plan.getRoutines().size(), planDTO.getRoutines().size());
    }
}
