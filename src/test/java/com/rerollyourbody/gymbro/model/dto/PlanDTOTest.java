package com.rerollyourbody.gymbro.model.dto;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.mapper.RoutineMapper;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.stream.Collectors;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createPlan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlanDTOTest {
    @Test
    public void testOfWhenPlanIsValid() {
        Plan plan = createPlan();
        PlanDTO planDTO = PlanDTO.of(plan);

        assertEquals(plan.getId(), UUID.fromString(planDTO.getPlanId()));
        assertEquals(plan.getUserId(), UUID.fromString(planDTO.getUserId()));
        assertEquals(plan.getWeek(), planDTO.getWeek());
        assertEquals(plan.getTotalWeeks(), planDTO.getTotalWeeks());
        assertEquals(plan.getRoutines().size(), planDTO.getRoutines().size());
//        assertTrue(plan.getRoutines().containsAll(planDTO.getRoutines().stream().map(RoutineMapper::map).collect(Collectors.toList())));

    }
}
