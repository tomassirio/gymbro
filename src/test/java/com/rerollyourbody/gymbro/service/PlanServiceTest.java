package com.rerollyourbody.gymbro.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.repository.PlanRepository;
import com.rerollyourbody.gymbro.core.service.PlanServiceImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createPlan;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createValidPlanDTO;

public class PlanServiceTest {

    @Autowired
    private PlanRepository repository;

    @Autowired
    private PlanServiceImpl planService;

    @Before
    public void setUp() {
    }

    @Test
    @Ignore
    public void test_createPlan_when_planDto_is_valid() {
        PlanDTO planDTO = createValidPlanDTO();

        Plan expectedResponse = createPlan();

        Mockito.when(planService.createPlan(planDTO)).thenReturn(expectedResponse);

        Plan response = planService.createPlan(planDTO);

        Assertions.assertEquals(expectedResponse.getUserId(), response.getUserId());

    }
}
