package com.rerollyourbody.gymbro.service;

import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.repository.PlanRepository;
import com.rerollyourbody.gymbro.core.service.PlanServiceImpl;
import com.rerollyourbody.gymbro.core.service.RoutineServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createPlan;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createValidPlanDTO;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlanServiceTest {

    @Mock
    private PlanRepository repository;
    @Mock
    private RoutineServiceImpl routineService;

    @InjectMocks
    private PlanServiceImpl planService;

    @Test
    public void test_createPlan_when_planDto_is_valid() {
        PlanDTO planDTO = createValidPlanDTO();
        Plan expectedResponse = createPlan();

        when(repository.save(any(Plan.class))).thenReturn(expectedResponse);
        Plan response = planService.createPlan(planDTO);

        verify(repository, Mockito.times(1)).save(any(Plan.class));

        Assertions.assertEquals(expectedResponse.getUserId(), response.getUserId());
        Assertions.assertEquals(expectedResponse.getId(), response.getId());
        Assertions.assertTrue(expectedResponse.getRoutines().containsAll(response.getRoutines()));
        Assertions.assertEquals(expectedResponse.getWeek(), response.getWeek());
        Assertions.assertEquals(expectedResponse.getTotalWeeks(), response.getTotalWeeks());
    }
}
