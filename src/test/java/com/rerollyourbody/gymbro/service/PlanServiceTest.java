package com.rerollyourbody.gymbro.service;

import com.rerollyourbody.gymbro.core.exception.PlanNotFoundException;
import com.rerollyourbody.gymbro.core.model.DTO.PlanDTO;
import com.rerollyourbody.gymbro.core.model.DTO.RoutineDTO;
import com.rerollyourbody.gymbro.core.model.Plan;
import com.rerollyourbody.gymbro.core.model.Routine;
import com.rerollyourbody.gymbro.core.model.factory.PlanFactory;
import com.rerollyourbody.gymbro.core.repository.PlanRepository;
import com.rerollyourbody.gymbro.core.service.PlanServiceImpl;
import com.rerollyourbody.gymbro.core.service.RoutineServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static com.rerollyourbody.gymbro.testUtils.TestUtils.createPlan;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createRoutine;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createValidPlanDTO;
import static com.rerollyourbody.gymbro.testUtils.TestUtils.createValidRoutineDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
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

        when(repository.save(any())).thenReturn(expectedResponse);
        Plan response = planService.createPlan(planDTO);

        verify(repository, Mockito.times(1)).save(any());

        Assertions.assertEquals(expectedResponse.getUserId(), response.getUserId());
        Assertions.assertEquals(expectedResponse.getId(), response.getId());
        Assertions.assertTrue(expectedResponse.getRoutines().containsAll(response.getRoutines()));
        Assertions.assertEquals(expectedResponse.getWeek(), response.getWeek());
        Assertions.assertEquals(expectedResponse.getTotalWeeks(), response.getTotalWeeks());
    }

    @Test
    public void test_createPlan_when_planDto_has_no_routines() {
        PlanDTO planDTO = createValidPlanDTO();
        planDTO.setRoutines(new ArrayList<>());

        Plan expectedResponse = PlanFactory.createPlan();

        when(repository.save(any())).thenReturn(expectedResponse);
        Plan response = planService.createPlan(planDTO);

        verify(repository, Mockito.times(1)).save(any());

        Assertions.assertEquals(expectedResponse.getUserId(), response.getUserId());
        Assertions.assertEquals(expectedResponse.getId(), response.getId());
        Assertions.assertTrue(expectedResponse.getRoutines().containsAll(response.getRoutines()));
        Assertions.assertEquals(expectedResponse.getWeek(), response.getWeek());
        Assertions.assertEquals(expectedResponse.getTotalWeeks(), response.getTotalWeeks());
    }

    @Test
    public void test_createPlan_when_planDto_has_no_totalWeeks() {
        PlanDTO planDTO = createValidPlanDTO();
        planDTO.setTotalWeeks(null);

        Plan expectedResponse = PlanFactory.createPlan();

        when(repository.save(any())).thenReturn(expectedResponse);
        Plan response = planService.createPlan(planDTO);

        verify(repository, Mockito.times(1)).save(any());

        Assertions.assertEquals(expectedResponse.getUserId(), response.getUserId());
        Assertions.assertEquals(expectedResponse.getId(), response.getId());
        Assertions.assertTrue(expectedResponse.getRoutines().containsAll(response.getRoutines()));
        Assertions.assertEquals(expectedResponse.getWeek(), response.getWeek());
        Assertions.assertEquals(expectedResponse.getTotalWeeks(), response.getTotalWeeks());
    }

    @Test
    public void test_getPlan_when_plan_exists() {
        Plan expectedResponse = createPlan();
        when(repository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedResponse));

        Plan response = planService.getPlan(UUID.randomUUID());

        verify(repository, Mockito.times(1)).findById(any());

        Assertions.assertEquals(expectedResponse.getUserId(), response.getUserId());
        Assertions.assertEquals(expectedResponse.getId(), response.getId());
        Assertions.assertTrue(expectedResponse.getRoutines().containsAll(response.getRoutines()));
        Assertions.assertEquals(expectedResponse.getWeek(), response.getWeek());
        Assertions.assertEquals(expectedResponse.getTotalWeeks(), response.getTotalWeeks());
    }

    @Test(expected = PlanNotFoundException.class)
    public void test_getPlan_when_plan_doesnt_exist() {
        when(repository.findById(any())).thenReturn(Optional.empty());

        planService.getPlan(UUID.randomUUID());

        verify(repository, Mockito.times(1)).findById(any());
    }

    @Test
    public void test_addRoutineToPlan_when_plan_exists() {
        Plan expectedPlan = createPlan();
        expectedPlan.setRoutines(new ArrayList<>());
        when(repository.findById(any())).thenReturn(java.util.Optional.ofNullable(expectedPlan));

        RoutineDTO routineDTO = createValidRoutineDTO();
        Routine routine = createRoutine();

        when(routineService.getRoutineById(any())).thenReturn(routine);

        Plan response = planService.addRoutineToPlan(UUID.randomUUID(), routineDTO);

        assertTrue(response.getRoutines().contains(routine));
        assertEquals(response.getRoutines().size(), 1);
    }

}
